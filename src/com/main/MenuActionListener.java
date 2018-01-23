package com.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class MenuActionListener implements ActionListener {
	
	String boxMessage = null;
	// activeView laat zien welke view op dit moment actief is.
	//String activeView;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// krijg de waarde waarop de gebruiker drukt en voer daarvoor de juiste actie.
		
		// NEW FILE
		if (e.getActionCommand().equals("New file")) {
			boxMessage = "A new file is opened...";
			Parkeergarage.main(null);
		}
		// EXIT FILE
		if (e.getActionCommand().equals("Exit")) {
			if (JOptionPane.showConfirmDialog(null, "Are you sure about that?",
					e.getActionCommand(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		// VIEW PIE CHART
		if (e.getActionCommand().equals("Pie chart")) {
			if (Parkeergarage.viewpie.isShowing()) {
				Parkeergarage.viewpie.setVisible(false);
				
			}
			else {
				Parkeergarage.viewpie.setVisible(true);
			}
		}
		// VIEW CLOCK
		if (e.getActionCommand().equals("Clock")) {
			if (Parkeergarage.viewKlok.isShowing()) {
				Parkeergarage.viewKlok.setVisible(false);
			}
			else {
				Parkeergarage.viewKlok.setVisible(true);
			}
		}
		// VIEW SLIDER
		if (e.getActionCommand().equals("Slider")) {
			if (Parkeergarage.viewSlide.isShowing()) {
				Parkeergarage.viewSlide.setVisible(false);
			}
			else {
				Parkeergarage.viewSlide.setVisible(true);
			}
		}
		// VIEW CARPARK
		if (e.getActionCommand().equals("Carpark")) {
			if (Parkeergarage.viewcarpark.isShowing()) {
				Parkeergarage.viewcarpark.setVisible(false);
			}
			else {
				Parkeergarage.viewcarpark.setVisible(true);
			}
		}
		// DEFAULT SETTINGS
		if (e.getActionCommand().equals("Default settings")) {
			boxMessage = "Set to default settings.";
		}
		// Stuur een bericht naar een venster als er een boxMessage is.
		if (boxMessage != null) {
			JOptionPane.showMessageDialog(null, boxMessage, e.getActionCommand(), JOptionPane.DEFAULT_OPTION);
		}
	}
}
