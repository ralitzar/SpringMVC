package com.ralitzaraynova.plashtania.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ralitzaraynova.plashtania.model.Plashtane;
import com.ralitzaraynova.plashtania.model.Plashtania;
import com.ralitzaraynova.plashtania.model.SustoyaniePlashtane;

@Controller
@RequestMapping("/plashtania")
public class PlashtaniaControler {
	
	@Autowired
	private Plashtania plashtania;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("NovoPlashtane");
		return mv;
	}
	
	@PostMapping
	public ModelAndView zapazi (Plashtane plashtane) {
		this.plashtania.save(plashtane);
		ModelAndView mv = new ModelAndView("NovoPlashtane");
		mv.addObject("message", "Плащането е запазено успешно!");
		return mv;
	}
	
	@GetMapping
	public ModelAndView pokaji() {
		ModelAndView mv = new ModelAndView("SpisukPlashtania");
		mv.addObject("plashtania",plashtania.findAll());
		return mv;
	}
	
	@ModelAttribute("sustoyania")
	public List<SustoyaniePlashtane> sustoyania(){
		return Arrays.asList(SustoyaniePlashtane.values());
	}
	
}
