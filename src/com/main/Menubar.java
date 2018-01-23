package com.main;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Menubar extends JMenuBar{

	// maak een menubar aan
	JMenuBar menubar = new JMenuBar();
	
	public Menubar(JFrame scherm)
	{
		super();
		// voeg menus toe aan de menubar
		JMenu file = new JMenu("File");
		JMenu view = new JMenu("View");
		JMenu settings = new JMenu("Settings");
		// voeg menu items toe aan de menus van de menubar
		JMenuItem openFile = new JMenuItem("Open file");
		JMenuItem exitFile = new JMenuItem("Exit");
		JMenuItem viewPie = new JMenuItem("Piechart");
		JMenuItem viewClock = new JMenuItem("Clock");
		JMenuItem defaultSettings = new JMenuItem("Default settings");
		
		// Voeg de menus inclusief de menu items toe aan de menubar
		menubar.add(file);
		menubar.add(view);
		menubar.add(settings);
		file.add(openFile);
		file.add(exitFile);
		view.add(viewPie);
		view.add(viewClock);
		settings.add(defaultSettings);
		
		// voeg de addActionListener toe aan de menu items
		openFile.addActionListener(new MenuActionListener());
		exitFile.addActionListener(new MenuActionListener());
		viewPie.addActionListener(new MenuActionListener());
		viewClock.addActionListener(new MenuActionListener());
		defaultSettings.addActionListener(new MenuActionListener());
		
		menubar.setVisible(true);
		
		scherm.add(menubar);
		scherm.setJMenuBar(menubar);
	}
}
