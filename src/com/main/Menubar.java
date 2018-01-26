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
	public static JMenu bestand = new JMenu("Bestand");
	public static JMenu beeld = new JMenu("Beeld");
	public static JMenu instellingen = new JMenu("Instellingen");
	public static JMenu simulatie = new JMenu("Simulatie");
	
	// Voeg menu items toe aan de menus van de menubar.
	public static JMenuItem nieuweInstantie = new JMenuItem("Nieuwe Instantie");
	public static JMenuItem afsluiten = new JMenuItem("Afsluiten");
	
	// Voeg checkbox menu items aan het beeld-menu.
	public static JCheckBoxMenuItem viewPie = new JCheckBoxMenuItem("Taart Weergave", false);
	public static JCheckBoxMenuItem viewGraph = new JCheckBoxMenuItem("Grafiek Weergave", false);
	public static JCheckBoxMenuItem viewHistogram = new JCheckBoxMenuItem("Histogram Weergave", false);
	public static JCheckBoxMenuItem viewClock = new JCheckBoxMenuItem("Klok", true);
	public static JCheckBoxMenuItem viewSlider = new JCheckBoxMenuItem("Snelheid Slider", true);
	
	public static JMenuItem defaultSettings = new JMenuItem("Standaard Instellingen Herstellen");
	
	public static JMenuItem startSimulatie = new JMenuItem("Start Simulatie");
	public static JMenuItem stopSimulatie = new JMenuItem("Stop Simulatie");
	
	public Menubar(JFrame scherm) {
		super();
		
		// Voeg de menus inclusief de menu items toe aan de menubar.
		menubar.add(bestand);
		menubar.add(beeld);
		menubar.add(instellingen);
		menubar.add(simulatie);
		
		bestand.setMnemonic('B');
		beeld.setMnemonic('E');
		instellingen.setMnemonic('I');
		simulatie.setMnemonic('S');
		
		bestand.add(nieuweInstantie);
		bestand.add(afsluiten);
		
		beeld.add(viewPie);
		beeld.add(viewGraph);
		beeld.add(viewHistogram);
		beeld.add(viewClock);
		beeld.add(viewSlider);
		
		instellingen.add(defaultSettings);
		
		simulatie.add(startSimulatie);
		simulatie.add(stopSimulatie);
		
		viewPie.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		viewGraph.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		viewHistogram.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		
		startSimulatie.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		stopSimulatie.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		
		// Voeg de addActionListener toe aan de menu items.
		nieuweInstantie.addActionListener(new MenuActionListener());
		afsluiten.addActionListener(new MenuActionListener());
		viewPie.addActionListener(new MenuActionListener());
		viewGraph.addActionListener(new MenuActionListener());
		viewHistogram.addActionListener(new MenuActionListener());
		viewClock.addActionListener(new MenuActionListener());
		viewSlider.addActionListener(new MenuActionListener());
		defaultSettings.addActionListener(new MenuActionListener());
		startSimulatie.addActionListener(new MenuActionListener());
		stopSimulatie.addActionListener(new MenuActionListener());
		
		// Maak de menubar zichtbaar
		menubar.setVisible(true);
		
		scherm.add(menubar);
		scherm.setJMenuBar(menubar);
	}
}
