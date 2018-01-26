package com.lib;

/*
 * In deze klasse worden alle kernvariabelen opgeslagen om makkelijk aangepast te worden zonder te hoeven zoeken.
 */

public class CoreVariables {
	
	// Snelheid van de simulatie
	public static int simulatorSpeed = 55;
	
	public static void setSimulatorSpeed(int i) {
		simulatorSpeed = 50 - i;
	}
	
	// Titel van het programma
	public static final String SIMULATOR_NAAM = "Parkeergarage Simulator Project C";
	
	// Resolutie
	public static final int schermBreedte = 1200;
	public static final int schermHoogte = 700;
	
	// De locaties van de views
	public static final int locatie1X = 10;
	public static final int locatie2X = 420;
	public static final int locatieY = 400;
	public static final int locatieWidth = 400;
	public static final int locatieHeight = 230;
}
