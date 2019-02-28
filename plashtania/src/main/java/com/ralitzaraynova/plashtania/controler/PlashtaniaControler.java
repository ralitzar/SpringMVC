package com.ralitzaraynova.plashtania.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlashtaniaControler {
	
	@RequestMapping("/plashtania/novo")
	public String novo() {
		return "NovoPlashtane";
	}
	
	@GetMapping("/plashtania")
	public String pokaji() {
		return "SpisukPlashtania";
	}
}
