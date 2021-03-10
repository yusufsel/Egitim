package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.PersonelBusiness;
import entities.Personel;

/**
 * Servlet implementation class BaslangicServlet
 */
@WebServlet("/index.htm")
public class BaslangicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Personel> liste = new PersonelBusiness().getPersonelListesi();
		request.setAttribute("liste", liste);
		request.getRequestDispatcher("/WEB-INF/views/personelListesi.jsp").forward(request, response);
	}

}
