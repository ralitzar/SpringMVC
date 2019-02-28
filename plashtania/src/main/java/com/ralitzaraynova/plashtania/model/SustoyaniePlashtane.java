package com.ralitzaraynova.plashtania.model;

public enum SustoyaniePlashtane {
	
	PLATENO ("Платено"),
	NEPLATENO ("Неплатено");
	
	private String opisanie;
	
	SustoyaniePlashtane (String opisanie){
		this.opisanie = opisanie;
	}
	
	public String getOpisanie() {
		return opisanie;
	}
}
