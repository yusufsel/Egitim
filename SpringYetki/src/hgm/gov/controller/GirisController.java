package hgm.gov.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hgm.gov.service.PersonelService;

@Controller
public class GirisController {
	@Autowired
	private PersonelService personelService;

	@PostMapping("/giris")
	public ModelAndView giris(String tcno, String sifre, HttpSession session) {
		ModelAndView model = new ModelAndView();
		if (personelService.girisYap(tcno, sifre)) {
			// giri� ba�ar�l�
			model.setViewName("menu");
			session.setAttribute("yetkiler", personelService.getPersonelYetkileri(tcno));
		} else {
			// giri� yap�lamad�
			model.addObject("mesaj", "Giri� yap�lamad�.");
			model.setViewName("../../index");
		}
		return model;
	}

}
