package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.PersonelBusiness;

/**
 * Servlet implementation class PersonelServlet
 */
@WebServlet("/index.jsp")
public class PersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("liste", new PersonelBusiness().getPersonelListesi());
		request.getRequestDispatcher("/WEB-INF/views/personelListesi.jsp").forward(request, response);
	}

}
