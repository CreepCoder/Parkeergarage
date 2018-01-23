package com.lib;

/*
 * In deze klasse worden alle kernvariabelen opgeslagen om makkelijk aangepast te worden zonder te hoeven zoeken.
 */

public class CoreVariables {
	
	// Snelheid van de simulatie
	public static int simulatorSpeed = 1;
	
	public static void setSimulatorSpeed(int i) {
		simulatorSpeed = i;
	}
	
	// Titel van het programma
	public static final String SIMULATOR_NAAM = "Parkeergarage Simulator Project C";
	
	// Resolutie
	public static final int schermBreedte = 1200;
	public static final int schermHoogte = 700;
}
