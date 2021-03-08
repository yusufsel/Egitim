package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.PersonelBusiness;
import exceptions.business.BusinessException;

@WebServlet("/personelListe")
public class PersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 12135412421423L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("liste", new PersonelBusiness().getPersoneller());
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("hata", e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/personelListesi.jsp").forward(request, response);
	}
}
