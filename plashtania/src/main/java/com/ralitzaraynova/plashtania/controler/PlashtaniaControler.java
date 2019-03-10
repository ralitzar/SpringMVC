package com.ralitzaraynova.plashtania.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		mv.addObject(new Plashtane());
		return mv;
	}
	
	@PostMapping("/novo")
	public String zapazi (@Validated Plashtane plashtane, Errors e, RedirectAttributes attributes) {
		if(e.hasErrors()) {
			return "NovoPlashtane";
		}
		this.plashtania.save(plashtane);
		attributes.addFlashAttribute("message", "Плащането е запазено успешно!");
		return "redirect:/plashtania/novo";
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
