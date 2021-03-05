package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.PersonelBusiness;

@WebServlet("/personelListe")
public class PersonelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("liste", new PersonelBusiness().getPersoneller());
		request.getRequestDispatcher("/WEB-INF/personelListesi.jsp").forward(request, response);
	}
//@formatter:off
/*
	public void readProps() {
		Properties p = new Properties();
		InputStream is = getClass().getResourceAsStream("/test.properties");
		System.out.println(is);
		try {
			p.load(is);
			System.out.println(MessageFormat.format(p.getProperty("hata1"), "deneme"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
*/
//@formatter:on
}
