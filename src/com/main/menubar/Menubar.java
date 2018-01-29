package com.main.menubar;

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
	public static JMenu programma = new JMenu("Programma");
	public static JMenu beeld = new JMenu("Beeld");
	//public static JMenu instellingen = new JMenu("Instellingen");
	public static JMenu simulatie = new JMenu("Simulatie");
	
	// Voeg menu items toe aan de menus van de menubar.
	public static JMenuItem over = new JMenuItem("Over");
	public static JMenuItem afsluiten = new JMenuItem("Afsluiten");
	
	// Voeg checkbox menu items aan het beeld-menu.
	public static JCheckBoxMenuItem viewPie = new JCheckBoxMenuItem("Taart Weergave", false);
	public static JCheckBoxMenuItem viewGraph = new JCheckBoxMenuItem("Grafiek Weergave", false);
	public static JCheckBoxMenuItem viewHistogram = new JCheckBoxMenuItem("Histogram Weergave", false);
	
	public static JMenuItem startSimulatie = new JMenuItem("Start Simulatie");
	public static JMenuItem stopSimulatie = new JMenuItem("Stop Simulatie");
	
	public Menubar(JFrame scherm) {
		super();
		
		// Voeg de menus inclusief de menu items toe aan de menubar.
		menubar.add(programma);
		menubar.add(beeld);
		menubar.add(simulatie);
		
		programma.setMnemonic('P');
		beeld.setMnemonic('B');
		simulatie.setMnemonic('S');
		
		programma.add(over);
		programma.add(afsluiten);
		
		beeld.add(viewPie);
		beeld.add(viewGraph);
		beeld.add(viewHistogram);
		
		simulatie.add(startSimulatie);
		simulatie.add(stopSimulatie);
		
		viewPie.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		viewGraph.setAccelerator(KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		viewHistogram.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		
		startSimulatie.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		stopSimulatie.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		
		// Voeg de addActionListener toe aan de menu items.
		over.addActionListener(new MenuActionListener());
		afsluiten.addActionListener(new MenuActionListener());
		viewPie.addActionListener(new MenuActionListener());
		viewGraph.addActionListener(new MenuActionListener());
		viewHistogram.addActionListener(new MenuActionListener());
		startSimulatie.addActionListener(new MenuActionListener());
		stopSimulatie.addActionListener(new MenuActionListener());
		
		// Maak de menubar zichtbaar
		menubar.setVisible(true);
		
		scherm.add(menubar);
		scherm.setJMenuBar(menubar);
	}
}
