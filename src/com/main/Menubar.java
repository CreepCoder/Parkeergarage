package com.main;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menubar extends JMenuBar{
	
	// Maak een menubar aan.
	public static JMenuBar menubar = new JMenuBar();
	// Voeg menus toe aan de menubar.
	public static JMenu file = new JMenu("File");
	public static JMenu view = new JMenu("View");
	public static JMenu settings = new JMenu("Settings");
	// Voeg menu items toe aan de menus van de menubar.
	public static JMenuItem newFile = new JMenuItem("New file");
	public static JMenuItem exitFile = new JMenuItem("Exit");
	
	// laat zien welke views zichtbaar zijn
	public static Boolean pieVisible = Parkeergarage.viewpie.isVisible();
	public static Boolean clockVisible = Parkeergarage.viewpie.isVisible();
	public static Boolean sliderVisible = Parkeergarage.viewpie.isVisible();
	public static Boolean carparkVisible = Parkeergarage.viewpie.isVisible();
	
	// Voeg checkbox menu items aan de view-menu.
	public static JCheckBoxMenuItem viewPie = new JCheckBoxMenuItem("Pie chart", pieVisible);
	public static JCheckBoxMenuItem viewClock = new JCheckBoxMenuItem("Clock", true);
	public static JCheckBoxMenuItem viewSlider = new JCheckBoxMenuItem("Slider", true);
	public static JCheckBoxMenuItem viewCarPark = new JCheckBoxMenuItem("Carpark", true);
	public static JCheckBoxMenuItem viewGraph = new JCheckBoxMenuItem("Graph", true);
	public static JCheckBoxMenuItem view2 = new JCheckBoxMenuItem("view2", true);
	public static JMenuItem defaultSettings = new JMenuItem("Default settings");
	
	public Menubar(JFrame scherm)
	{
		super();
		
		// Voeg de menus inclusief de menu items toe aan de menubar.
		menubar.add(file);
		menubar.add(view);
		menubar.add(settings);
		file.add(newFile);
		file.add(exitFile);
		view.add(viewPie);
		view.add(viewClock);
		view.add(viewSlider);
		view.add(viewGraph);
		view.add(view2);
		view.add(viewCarPark);
		settings.add(defaultSettings);
		
		// Voeg de addActionListener toe aan de menu items.
		newFile.addActionListener(new MenuActionListener());
		exitFile.addActionListener(new MenuActionListener());
		viewPie.addActionListener(new MenuActionListener());
		viewClock.addActionListener(new MenuActionListener());
		viewSlider.addActionListener(new MenuActionListener());
		viewGraph.addActionListener(new MenuActionListener());
		view2.addActionListener(new MenuActionListener());
		viewCarPark.addActionListener(new MenuActionListener());
		defaultSettings.addActionListener(new MenuActionListener());
		
		menubar.setVisible(true);
		
		scherm.add(menubar);
		scherm.setJMenuBar(menubar);
	}
}
