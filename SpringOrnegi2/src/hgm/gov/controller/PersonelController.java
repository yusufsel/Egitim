package hgm.gov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hgm.gov.business.PersonelBusiness;

@Controller
public class PersonelController {
	@Autowired
	private PersonelBusiness personelBusiness;

	@GetMapping("/")
	public ModelAndView ilkSayfa() {
		ModelAndView model = new ModelAndView();
		model.setViewName("personelListesi");
		model.addObject("liste", personelBusiness.getPersoneller());
		return model;
	}
}
