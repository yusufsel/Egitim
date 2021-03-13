package servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import beans.Personel;
import beans.PersonelAdres;
import business.PersonelAdresBusiness;
import exceptions.business.BusinessException;

@WebServlet("/personelAdres")
public class PersonelAdresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String islem = request.getParameter("islem");
		if ("guncelle".equals(islem)) {
			// adres guncelleme yapilacak
			try {
				request.setAttribute("adres", new PersonelAdresBusiness().getPersonelAdres(id));
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("hata", e.getMessage());
			}
			request.getRequestDispatcher("/WEB-INF/personelAdresGuncelle.jsp").forward(request, response);
		} else {
			// adres listesi okunacak
			try {
				request.setAttribute("liste", new PersonelAdresBusiness().getPersonelAdresler(id));
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("hata", e.getMessage());
			}
			request.getRequestDispatcher("/WEB-INF/personelAdresListesi.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int personelId = Integer.parseInt(req.getParameter("id"));
		PersonelAdres adres = new PersonelAdres();
		adres.setAdres(req.getParameter("adres"));
		Personel personel = new Personel();
		personel.setId(personelId);
		adres.setPersonel(personel);
		try {
			new PersonelAdresBusiness().personelAdresEkle(adres);
			req.setAttribute("mesaj", "Personel adresi eklenmiþtir");
		} catch (BusinessException e) {
			e.printStackTrace();
			req.setAttribute("hata", e.getMessage());
		}

		doGet(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = req.getReader().lines().collect(Collectors.joining());
		JSONObject json = new JSONObject(body);
		JSONObject cevap = new JSONObject();

		try {
			new PersonelAdresBusiness().personelAdresSil(json.getInt("adresId"));
			cevap.put("sonuc", "ok");
		} catch (JSONException e) {
			e.printStackTrace();
			cevap.put("sonuc", "hata");
			cevap.put("hata", "Beklenmedik bir hata oluþtu");
		} catch (BusinessException e) {
			e.printStackTrace();
			cevap.put("sonuc", "hata");
			cevap.put("hata", e.getMessage());
		}
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(cevap);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String body = req.getReader().lines().collect(Collectors.joining());
		JSONObject json = new JSONObject(body);
		JSONObject cevap = new JSONObject();

		try {
			PersonelAdres personelAdres = new PersonelAdres();
			personelAdres.setAdres(json.getString("adres"));
			new PersonelAdresBusiness().personelAdresGuncelle(json.getInt("adresId"), personelAdres);
			cevap.put("sonuc", "ok");
		} catch (JSONException e) {
			e.printStackTrace();
			cevap.put("sonuc", "hata");
			cevap.put("hata", "Beklenmedik bir hata oluþtu");
		} catch (BusinessException e) {
			e.printStackTrace();
			cevap.put("sonuc", "hata");
			cevap.put("hata", e.getMessage());
		}
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(cevap);
	}
}
