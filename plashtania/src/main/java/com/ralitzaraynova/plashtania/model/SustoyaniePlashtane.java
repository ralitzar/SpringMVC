package com.ralitzaraynova.plashtania.model;

public enum SustoyaniePlashtane {
	
	PLATENO ("Платено"),
	NEPLATENO ("Неплатено"),
	OPROSTENO ("Oпростено");
	
	private String opisanie;
	
	SustoyaniePlashtane (String opisanie){
		this.opisanie = opisanie;
	}
	
	public String getOpisanie() {
		return opisanie;
	}
}
