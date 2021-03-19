package hgm.gov.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hgm.gov.service.PersonelService;
import hgm.gov.util.Sabitler;
import hgm.gov.util.Util;

@Controller
public class PersonelListeController {
	@Autowired
	private PersonelService personelService;

	@GetMapping("/personelListele")
	public ModelAndView personelListesi(HttpSession session) {
		ModelAndView model = new ModelAndView();
		if (Util.yetkiVarmi(session, Sabitler.YETKI_PERSONEL_LISTELEME)) {
			// yetki var
			model.addObject("liste", personelService.getPersoneller());
			model.setViewName("personelListesi");
		} else {
			// yetki yok
			model.addObject("hata", "Yetkiniz yoktur");
			model.setViewName("menu");
		}
		return model;
	}

}
