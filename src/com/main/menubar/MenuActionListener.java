package com.main.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.location.LocationView;
import com.main.Parkeergarage;


public class MenuActionListener implements ActionListener {
	String boxMessage = null;
	
	boolean viewpieAdded = false;
	boolean viewgraphAdded = false;
	boolean viewhistogramAdded = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Hier worden de verschillende acties voor de verschillende knoppen gedefinieerd
		
		// EXIT FILE
		if (e.getActionCommand().equals("Afsluiten")) {
			if (JOptionPane.showConfirmDialog(null, "Weet u zeker dat u het programma wilt afsluiten?",
					e.getActionCommand(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
			}
		}
		
		// OVER
		if (e.getActionCommand().equals("Over")) {
			JOptionPane.showMessageDialog(null, "<html><center>Parkeergarage Simulator<br>Gemaakt door: Daniëlle, Iris, Lorenzo, Marc en Sander<br>(C) 2017 Het KipComité (Groep C)</center></html>");
		}
		
		// VIEW PIE CHART
		if (e.getActionCommand().equals("Taart Weergave")) {
			if (viewpieAdded == false) {
				if (LocationView.links.isOccupied() == false || LocationView.rechts.isOccupied() == false) {
					if (LocationView.links.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewPie, LocationView.links);
						LocationView.links.setOccupied(true);
						viewpieAdded = true;
					}
					else if (LocationView.rechts.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewPie, LocationView.rechts);
						LocationView.rechts.setOccupied(true);
						viewpieAdded = true;
					}
				}
				else if (LocationView.links.isOccupied() == true && LocationView.rechts.isOccupied() == true) {
					errorOccupied();
					Menubar.viewPie.setSelected(false);
				}
			}
			else if (viewpieAdded == true){
				Parkeergarage.haalElementWeg(Parkeergarage.scherm, Parkeergarage.viewPie);
				viewpieAdded = false;
			}
		}
		

		// VIEW GRAPH
		if (e.getActionCommand().equals("Grafiek Weergave")) {
			if (viewgraphAdded == false) {
				if (LocationView.links.isOccupied() == false || LocationView.rechts.isOccupied() == false) {
					if (LocationView.links.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewGrafiek, LocationView.links);
						LocationView.links.setOccupied(true);
						viewgraphAdded = true;
					}
					else if (LocationView.rechts.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewGrafiek, LocationView.rechts);
						LocationView.rechts.setOccupied(true);
						viewgraphAdded = true;
					}
				}
				else if (LocationView.links.isOccupied() == true && LocationView.rechts.isOccupied() == true) {
					errorOccupied();
					Menubar.viewGraph.setSelected(false);
				}
			}
			else if (viewgraphAdded == true){
				Parkeergarage.haalElementWeg(Parkeergarage.scherm, Parkeergarage.viewGrafiek);
				viewgraphAdded = false;
			}
		}
		
		// VIEW HISTOGRAM
		if (e.getActionCommand().equals("Histogram Weergave")) {
			if (viewhistogramAdded == false) {
				if (LocationView.links.isOccupied() == false || LocationView.rechts.isOccupied() == false) {
					if (LocationView.links.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewHistogram, LocationView.links);
						LocationView.links.setOccupied(true);
						viewhistogramAdded = true;
					}
					else if (LocationView.rechts.isOccupied() == false) {
						Parkeergarage.voegViewToe(Parkeergarage.scherm, Parkeergarage.viewHistogram, LocationView.rechts);
						LocationView.rechts.setOccupied(true);
						viewhistogramAdded = true;
					}
				}
				else if (LocationView.links.isOccupied() == true && LocationView.rechts.isOccupied() == true) {
					errorOccupied();
					Menubar.viewHistogram.setSelected(false);
				}
			}
			else if (viewhistogramAdded == true){
				Parkeergarage.haalElementWeg(Parkeergarage.scherm, Parkeergarage.viewHistogram);
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
			if (Parkeergarage.viewSnelheid.isShowing()) {
				Parkeergarage.viewSnelheid.setVisible(false);
			}
			else {
				Parkeergarage.viewSnelheid.setVisible(true);
			}
		}
		
		// START SIMULATIE
		if (e.getActionCommand().equals("Start Simulatie")) {
			Parkeergarage.model.start();
		}
		
		// STOP SIMULATIE
		if (e.getActionCommand().equals("Stop Simulatie")) {
			Parkeergarage.model.stop();
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
