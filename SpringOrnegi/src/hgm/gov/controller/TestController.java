package hgm.gov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hgm.gov.business.TestBusiness;

@Controller
public class TestController {
	@Autowired
	private TestBusiness business;

	@GetMapping("/deneme")
	public ModelAndView test() {
		business.deneme();
		System.out.println("test");
		ModelAndView model = new ModelAndView();
		model.setViewName("sayfa1");
		model.addObject("isim", "Levent");
		return model;
	}
}
