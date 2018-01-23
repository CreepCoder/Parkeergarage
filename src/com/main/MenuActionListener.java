package com.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;

import com.mvc.view.ViewKlok;
import com.mvc.view.ViewPie;

public class MenuActionListener implements ActionListener {
	
	String boxMessage = null;
	// activeView laat zien welke view op dit moment actief is.
	String activeView;

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
			System.exit(0);
		}
		// VIEW PIE CHART
		if (e.getActionCommand().equals("Pie chart")) {
			boxMessage = "Pie chart";
			
			if (Parkeergarage.viewpie.isShowing()) {
				boxMessage += " is now turned off.";
				Parkeergarage.viewpie.setVisible(false);
				
			}
			else {
				boxMessage += " is now turned on.";
				Parkeergarage.viewpie.setVisible(true);
			}
		}
		// VIEW CLOCK
		if (e.getActionCommand().equals("Clock")) {
			boxMessage = "Clock";
			
			if (Parkeergarage.viewKlok.isShowing()) {
				boxMessage += " is now turned off.";
				Parkeergarage.viewKlok.setVisible(false);
			}
			else {
				boxMessage += " is now turned on.";
				Parkeergarage.viewKlok.setVisible(true);
			}
		}
		// VIEW SLIDER
		if (e.getActionCommand().equals("Slider")) {
			boxMessage = "Slider";
			
			if (Parkeergarage.viewSlide.isShowing()) {
				boxMessage += " is now turned off.";
				Parkeergarage.viewSlide.setVisible(false);
			}
			else {
				boxMessage += " is now turned on.";
				Parkeergarage.viewSlide.setVisible(true);
			}
		}
		// VIEW CARPARK
		if (e.getActionCommand().equals("Carpark")) {
			boxMessage = "Carpark";
			
			if (Parkeergarage.viewcarpark.isShowing()) {
				boxMessage += " is now turned off.";
				Parkeergarage.viewcarpark.setVisible(false);
			}
			else {
				boxMessage += " is now turned on.";
				Parkeergarage.viewcarpark.setVisible(true);
			}
		}
		// DEFAULT SETTINGS
		if (e.getActionCommand().equals("Default settings")) {
			boxMessage = "Set to default settings.";
		}
		
		// laat de boxMessage in een venster zien als die er is
		if (boxMessage != null) {
			// Een gebruiker kan een view aan of uitzetten en dit mag maximaal ��n zijn.
			// Als een andere view aan staat (actief) krijgt de gebruiker hierover een melding
			// Deze view wordt bovendien niet zichtbaar voor de gebruiker.
			if (activeView != null) {
				boxMessage = "Can't view " + e.getActionCommand()
						+ "! There is already another view active... "
						+ "Please turn off the current view to be able to turn on another view";
				JOptionPane.showMessageDialog(null, boxMessage, e.getActionCommand(), JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, boxMessage, e.getActionCommand(), JOptionPane.DEFAULT_OPTION);
			}
			
			//JOptionPane.showMessageDialog(null, boxMessage, e.getActionCommand(), JOptionPane.DEFAULT_OPTION);
		}
		
	}
}
