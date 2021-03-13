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

import business.IsimlerBusiness;
import entities.Isimler;

/**
 * Servlet implementation class IsimServlet
 */
@WebServlet("/isimler")
public class IsimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = request.getReader().lines().collect(Collectors.joining());
		JSONObject json = new JSONObject(body);
		int kisiSayisi = json.getInt("isimSayisi");
		List<Isimler> isimler = new IsimlerBusiness().getIsimler(kisiSayisi);

		// sayfaya sadece string olarak isimlerin döndürülmesi isteniyor.
		// List<String> isimlerList = new ArrayList<String>();
		// isimler.forEach(i -> isimlerList.add(i.getIsim()));

		System.out.println("isim listesi aliniyor. Adet: " + isimler.size());
		// json formatýnda dönüþ deðeri için result oluþturuluyor.
		JSONObject result = new JSONObject();
		result.put("liste", isimler);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
