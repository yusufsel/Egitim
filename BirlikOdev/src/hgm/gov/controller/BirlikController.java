package hgm.gov.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hgm.gov.service.BirlikService;

@Controller
public class BirlikController {
	@Autowired
	private BirlikService birlikService;

	@GetMapping("/")
	public ModelAndView getBirlikSayisi() {
		List<SimpleEntry<Integer, Integer>> birlikSayilari = birlikService.getBirlikSayilari();
		ModelAndView model = new ModelAndView("liste");
		model.addObject("liste", birlikSayilari);
		return model;
	}
}
