package com.main;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menubar extends JMenuBar{

	// Maak een menubar aan.
	JMenuBar menubar = new JMenuBar();
	
	public Menubar(JFrame scherm)
	{
		super();
		
		// Voeg menus toe aan de menubar.
		JMenu file = new JMenu("File");
		JMenu view = new JMenu("View");
		JMenu settings = new JMenu("Settings");
		
		// Voeg menu items toe aan de menus van de menubar.
		JMenuItem newFile = new JMenuItem("New file");
		JMenuItem exitFile = new JMenuItem("Exit");
		
		// Voeg checkbox menu items aan de view-menu.
		JCheckBoxMenuItem viewPie = new JCheckBoxMenuItem("Pie chart", true);
		JCheckBoxMenuItem viewClock = new JCheckBoxMenuItem("Clock", true);
		JCheckBoxMenuItem viewSlider = new JCheckBoxMenuItem("Slider", true);
		JCheckBoxMenuItem viewCarPark = new JCheckBoxMenuItem("Carpark", true);
		
		JMenuItem defaultSettings = new JMenuItem("Default settings");
		
		// Voeg de menus inclusief de menu items toe aan de menubar.
		menubar.add(file);
		menubar.add(view);
		menubar.add(settings);
		file.add(newFile);
		file.add(exitFile);
		view.add(viewPie);
		view.add(viewClock);
		view.add(viewSlider);
		view.add(viewCarPark);
		settings.add(defaultSettings);
		
		// Voeg de addActionListener toe aan de menu items.
		newFile.addActionListener(new MenuActionListener());
		exitFile.addActionListener(new MenuActionListener());
		viewPie.addActionListener(new MenuActionListener());
		viewClock.addActionListener(new MenuActionListener());
		viewSlider.addActionListener(new MenuActionListener());
		viewCarPark.addActionListener(new MenuActionListener());
		defaultSettings.addActionListener(new MenuActionListener());
		
		menubar.setVisible(true);
		
		scherm.add(menubar);
		scherm.setJMenuBar(menubar);
	}
}
