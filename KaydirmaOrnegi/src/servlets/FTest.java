package servlets;

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
import javax.xml.bind.DatatypeConverter;

/**
 * Servlet implementation class FTest
 */
@WebServlet("/ftest")
@MultipartConfig
public class FTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part p = request.getPart("f");
		String sfname = p.getSubmittedFileName();
		String fileName = Paths.get(p.getSubmittedFileName()).getFileName().toString();
		System.out.println("sf:" + sfname);
		System.out.println("fn:" + fileName);
		InputStream fileContent = p.getInputStream();
		byte[] bytes = new byte[100];
		fileContent.read(bytes);
		System.out.println(new String(bytes));
		System.out.println(DatatypeConverter.printHexBinary(bytes).toUpperCase());
	}

}
