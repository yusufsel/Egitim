package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Personel;
import beans.PersonelAdres;
import business.PersonelAdresBusiness;

@WebServlet("/personelAdres")
public class PersonelAdresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int personelId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("liste", new PersonelAdresBusiness().getPersonelAdresler(personelId));
		request.getRequestDispatcher("/WEB-INF/personelAdresListesi.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int personelId = Integer.parseInt(req.getParameter("id"));
		PersonelAdres adres = new PersonelAdres();
		adres.setAdres(req.getParameter("adres"));
		Personel personel = new Personel();
		personel.setId(personelId);
		adres.setPersonel(personel);
		new PersonelAdresBusiness().personelAdresEkle(adres);
		req.setAttribute("mesaj", "Personel adresi eklenmiþtir");
		doGet(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int personelAdresId = Integer.parseInt(req.getParameter("id"));
		new PersonelAdresBusiness().personelAdresSil(personelAdresId);
	}
}
