package com.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.location.LocationView;


public class MenuActionListener implements ActionListener {
	
	String boxMessage = null;
	// activeView laat zien welke view op dit moment actief is.
	//String activeView;
	
	boolean viewpieAdded = false;
	boolean viewgraphAdded = false;
	boolean viewhistogramAdded = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// krijg de waarde waarop de gebruiker drukt en voer daarvoor de juiste actie.
		
		// NEW FILE
		if (e.getActionCommand().equals("Nieuwe Instantie")) {
			//boxMessage = "A new file is opened...";
			Parkeergarage.main(null);
			//System.exit(0);
		}
		// EXIT FILE
		if (e.getActionCommand().equals("Afsluiten")) {
			if (JOptionPane.showConfirmDialog(null, "Are you sure about that?",
					e.getActionCommand(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
			}
		}
		// VIEW PIE CHART
		if (e.getActionCommand().equals("Taart Weergave")) {
			if (viewpieAdded == false) {
				if (LocationView.links.isOccupied() == false || LocationView.rechts.isOccupied() == false) {
					System.out.println("1 van de views is nog beschikbaar (of allebei)");
					if (LocationView.links.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewpie, LocationView.links);
						LocationView.links.setOccupied(true);
						viewpieAdded = true;
						System.out.println("Links heeft een view ontvangen");
					}
					else if (LocationView.rechts.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewpie, LocationView.rechts);
						LocationView.rechts.setOccupied(true);
						viewpieAdded = true;
						System.out.println("Rechts heeft een view ontvangen");
					}
				}
				else if (LocationView.links.isOccupied() == true && LocationView.rechts.isOccupied() == true) {
					errorOccupied();
					Menubar.viewPie.setSelected(false);
				}
			}
			else if (viewpieAdded == true){
				Parkeergarage.haalElementWeg(Parkeergarage.scherm, Parkeergarage.viewpie);
				System.out.println("Er is een view verwijderd");
				viewpieAdded = false;
			}
		}
		

		// VIEW GRAPH
		if (e.getActionCommand().equals("Grafiek Weergave")) {
			if (viewgraphAdded == false) {
				if (LocationView.links.isOccupied() == false || LocationView.rechts.isOccupied() == false) {
					System.out.println("1 van de views is nog beschikbaar (of allebei)");
					if (LocationView.links.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewGraph, LocationView.links);
						LocationView.links.setOccupied(true);
						viewgraphAdded = true;
						System.out.println("Links heeft een graphview ontvangen");
					}
					else if (LocationView.rechts.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewGraph, LocationView.rechts);
						LocationView.rechts.setOccupied(true);
						viewgraphAdded = true;
						System.out.println("Rechts heeft een graphview ontvangen");
					}
				}
				else if (LocationView.links.isOccupied() == true && LocationView.rechts.isOccupied() == true) {
					errorOccupied();
					Menubar.viewGraph.setSelected(false);
				}
			}
			else if (viewgraphAdded == true){
				Parkeergarage.haalElementWeg(Parkeergarage.scherm, Parkeergarage.viewGraph);
				System.out.println("Er is een view verwijderd");
				viewgraphAdded = false;
			}
		}
		// VIEW HISTOGRAM
		if (e.getActionCommand().equals("Histogram Weergave")) {
			if (viewhistogramAdded == false) {
				if (LocationView.links.isOccupied() == false || LocationView.rechts.isOccupied() == false) {
					System.out.println("1 van de views is nog beschikbaar (of allebei)");
					if (LocationView.links.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewhistogram, LocationView.links);
						LocationView.links.setOccupied(true);
						viewhistogramAdded = true;
						System.out.println("Links heeft een view ontvangen");
					}
					else if (LocationView.rechts.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewhistogram, LocationView.rechts);
						LocationView.rechts.setOccupied(true);
						viewhistogramAdded = true;
						System.out.println("Rechts heeft een view ontvangen");
					}
				}
				else if (LocationView.links.isOccupied() == true && LocationView.rechts.isOccupied() == true) {
					errorOccupied();
					Menubar.viewHistogram.setSelected(false);
				}
			}
			else if (viewhistogramAdded == true){
				Parkeergarage.haalElementWeg(Parkeergarage.scherm, Parkeergarage.viewhistogram);
				System.out.println("Er is een view verwijderd");
				viewhistogramAdded = false;
			}
		}
		
		// VIEW CLOCK
		if (e.getActionCommand().equals("Klok")) {
			if (Parkeergarage.viewKlok.isShowing()) {
				Parkeergarage.viewKlok.setVisible(false);
			}
			else {
				Parkeergarage.viewKlok.setVisible(true);
			}
		}
		
		// VIEW SLIDER
		if (e.getActionCommand().equals("Snelheid Slider")) {
			if (Parkeergarage.viewSlide.isShowing()) {
				Parkeergarage.viewSlide.setVisible(false);
			}
			else {
				Parkeergarage.viewSlide.setVisible(true);
			}
		}
		
		// DEFAULT SETTINGS
		if (e.getActionCommand().equals("Standaard Instellingen Herstellen")) {
			//boxMessage = "Set to default settings.";
			
			// Maak de default views zichtbaar
			Parkeergarage.viewpie.setVisible(true);
			Parkeergarage.viewKlok.setVisible(true);
			Parkeergarage.viewSlide.setVisible(true);
			Parkeergarage.viewGraph.setVisible(false);
			Parkeergarage.viewhistogram.setVisible(false);
			// Maak de geselecteerde items gelijk aan de zichtbare items
			Menubar.viewPie.setSelected(true);
			Menubar.viewClock.setSelected(true);
			Menubar.viewSlider.setSelected(true);
			Menubar.viewGraph.setVisible(false);
			Menubar.viewHistogram.setSelected(false);
		}
		// Stuur een bericht naar een venster als er een boxMessage is.
		if (boxMessage != null) {
			JOptionPane.showMessageDialog(null, boxMessage, e.getActionCommand(), JOptionPane.DEFAULT_OPTION);
		}
	}
	private void errorOccupied() {
		JOptionPane.showMessageDialog(null, "U dient eerst een view weg te halen voordat u een nieuwe toevoegd.");
	}
}
