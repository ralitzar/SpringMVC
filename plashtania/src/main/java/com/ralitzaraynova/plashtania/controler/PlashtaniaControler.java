package com.ralitzaraynova.plashtania.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlashtaniaControler {
	
	@GetMapping("/plashtania")
	public String pokaji() {
		return "SpisukPlashtania";
	}

}
