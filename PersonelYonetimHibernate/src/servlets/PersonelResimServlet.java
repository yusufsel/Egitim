package servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Personel;
import business.PersonelBusiness;
import exceptions.business.BusinessException;

/**
 * Servlet implementation class PersonelResimServlet
 */
@WebServlet("/personelResim")
@MultipartConfig
public class PersonelResimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Personel personel = new PersonelBusiness().getPersonel(id);
			response.getOutputStream().write(personel.getResim());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// int id = 6;
		int id = Integer.parseInt(request.getParameter("id"));
		Part resimPart = request.getPart("resim");
		String fileName = Paths.get(resimPart.getSubmittedFileName()).getFileName().toString();
		System.out.println(fileName);
		InputStream fileContent = resimPart.getInputStream();

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[1024];
		while ((nRead = fileContent.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		buffer.flush();
		byte[] resimByteArray = buffer.toByteArray();
		String sayfa = "";
		try {
			new PersonelBusiness().personelResimGuncelle(id, resimByteArray);
			sayfa = "/personelListe";
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("hata", e.getMessage());
			sayfa = "/personelResimDegistir.jsp";
		}
		request.getRequestDispatcher(sayfa).forward(request, response);

	}

}
