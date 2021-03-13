package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import business.PersonelAdresBusiness;
import entities.PersonelAdres;
import model.PersonelAdresModel;

/**
 * Servlet implementation class PersonelAdresServlet
 */
@WebServlet("/personelAdres")
public class PersonelAdresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = request.getReader().lines().collect(Collectors.joining());
		JSONObject json = new JSONObject(body);
		int id = json.getInt("id");
		List<PersonelAdres> adresler = new PersonelAdresBusiness().getPersonelAdresler(id);

		JSONObject cevap = new JSONObject();
		PersonelAdresModel[] adresArr = new PersonelAdresModel[adresler.size()];
		for (int i = 0; i < adresler.size(); i++) {
			PersonelAdresModel model = new PersonelAdresModel();
			model.setId(adresler.get(i).getId());
			model.setAdres(adresler.get(i).getAdres());
			adresArr[i] = model;
		}
		cevap.put("adres", adresArr);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(cevap);
	}

}
