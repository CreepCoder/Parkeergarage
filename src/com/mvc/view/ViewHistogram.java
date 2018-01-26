package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.lib.ColorList;
import com.mvc.model.Model;

public class ViewHistogram extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	JLabel label549 = new JLabel("540");
	JLabel label410 = new JLabel("410");
	JLabel label286 = new JLabel("286");
	JLabel label162 = new JLabel("162");
	JLabel label0 = new JLabel("0");
	
	public ViewHistogram(Model model) {
		super(model);
		this.setSize(400, 230);
		this.setLayout(null);
		this.label(label0, 0, 219, 15, 10, true);
		this.label(label162, 0, 155, 25, 10, true);
		this.label(label286, 0, 105, 25, 10, true);
		this.label(label410, 0, 55, 25, 10, true);
		this.label(label549, 0, 5, 25, 10, true);
	}
	

	// Methode om gemakkelijk een legenda toe te voegen (tekst)
	

	public void paintComponent(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 229);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 230);
		g.drawLine(0, 229, 399, 229);
		g.drawLine(399, 0, 399, 229);
   
		
		g.setColor(Color.lightGray);
		g.drawLine(0, 100, 399, 100);
		g.drawLine(0, 50, 399, 50);
		g.drawLine(0, 150, 399, 150);
		g.drawLine(50, 229, 50, 0);
		g.drawLine(100, 229, 100, 0);
		g.drawLine(150, 229, 150, 0);
		g.drawLine(200, 229, 200, 0);
		g.drawLine(250, 229, 250, 0);
		g.drawLine(300, 229, 300, 0);
		g.drawLine(350, 229, 350, 0);
		
		int aantallege = 228-model.aantalLegeVakken/2;
		
		if (aantallege < 2) {
			aantallege = 1;
		}
		int aantaladhoc= 228-model.aantalCarAdHoc/2;
		
		if (aantaladhoc < 2) {
			aantaladhoc = 1;
		}

		createBar(g, ColorList.LEGE_VAKKEN, 33, aantallege, 50, 229);
		createBar(g, ColorList.CAR_AD_HOC, 96, aantaladhoc, 50, 229);
		createBar(g, ColorList.CAR_PARKING_PASS, 165, 228-model.aantalCarParkingPass/2 , 50, 229);
		createBar(g, ColorList.ELEKTRISCHE_CAR, 231,  228-model.aantalCarElektrisch/2, 50,229);
		createBar(g, ColorList.INVALIDE_CAR, 297,  228-model.aantalCarInvalide/2, 50, 229);
		createBar(g, ColorList.MOTOR, 363, 228-model.aantalCarMotor/2, 50, 229);
	}
	
	private void createBar(Graphics g, Color color, int x, int y, int width, int height) {
		g.setColor(color);
		g.fill3DRect(x, y, width, height, true);
		 	}

	public void label(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
	}

	
}
