package hgm.gov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GirisController {

	@PostMapping("/giris")
	public ModelAndView giris(String adi, String sifre) {
		ModelAndView model = new ModelAndView();
		model.setViewName("menu.jsp");
		return model;
	}
}
