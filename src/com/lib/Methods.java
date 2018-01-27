package com.lib;

import java.awt.Container;

import javax.swing.JLabel;

/*
 * Deze klasse bevat een aantal methodes die steeds weer terugkomen in het programma
 */
public class Methods {
	public static void voegLabelToe(JLabel label, int x, int y, int width, int height, 
			boolean visible, Container container, int alignment) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		label.setHorizontalAlignment(alignment);
		container.add(label);
	}
}
