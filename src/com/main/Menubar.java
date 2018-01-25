package com.main;

import java.awt.Toolkit;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Menubar extends JMenuBar{
	// Maak een menubar aan.
	public static JMenuBar menubar = new JMenuBar();
	
	// Voeg menus toe aan de menubar.
	public static JMenu file = new JMenu("Bestand");
	public static JMenu view = new JMenu("Beeld");
	public static JMenu settings = new JMenu("Instellingen");
	
	// Voeg menu items toe aan de menus van de menubar.
	public static JMenuItem newFile = new JMenuItem("Nieuwe Instantie");
	public static JMenuItem exitFile = new JMenuItem("Afsluiten");
	
	// Voeg checkbox menu items aan het beeld-menu.
	public static JCheckBoxMenuItem viewPie = new JCheckBoxMenuItem("Taart Weergave", false);
	public static JCheckBoxMenuItem viewGraph = new JCheckBoxMenuItem("Grafiek Weergave", false);
	public static JCheckBoxMenuItem viewHistogram = new JCheckBoxMenuItem("Histogram Weergave", false);
	public static JCheckBoxMenuItem viewClock = new JCheckBoxMenuItem("Klok", true);
	public static JCheckBoxMenuItem viewSlider = new JCheckBoxMenuItem("Snelheid Slider", true);
	
	public static JMenuItem defaultSettings = new JMenuItem("Standaard Instellingen Herstellen");
	
	public Menubar(JFrame scherm) {
		super();
		
		// Voeg de menus inclusief de menu items toe aan de menubar.
		menubar.add(file);
		menubar.add(view);
		menubar.add(settings);
		
		file.setMnemonic('F');
		view.setMnemonic('V');
		settings.setMnemonic('S');
		
		file.add(newFile);
		file.add(exitFile);
		
		view.add(viewPie);
		view.add(viewGraph);
		view.add(viewHistogram);
		view.add(viewClock);
		view.add(viewSlider);
		
		settings.add(defaultSettings);
		
		viewPie.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		viewGraph.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		viewHistogram.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		
		// Voeg de addActionListener toe aan de menu items.
		newFile.addActionListener(new MenuActionListener());
		exitFile.addActionListener(new MenuActionListener());
		viewPie.addActionListener(new MenuActionListener());
		viewGraph.addActionListener(new MenuActionListener());
		viewHistogram.addActionListener(new MenuActionListener());
		viewClock.addActionListener(new MenuActionListener());
		viewSlider.addActionListener(new MenuActionListener());
		defaultSettings.addActionListener(new MenuActionListener());
		
		// Maak de menubar zichtbaar
		menubar.setVisible(true);
		
		scherm.add(menubar);
		scherm.setJMenuBar(menubar);
	}
}
