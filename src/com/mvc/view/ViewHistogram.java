package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import com.lib.ColorList;
import com.mvc.model.Model;

public class ViewHistogram extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;

	public ViewHistogram(Model model) {
		super(model);
		this.setSize(400, 230);
		this.setLayout(null);
	}
	

	// Methode om gemakkelijk een legenda toe te voegen (tekst)
	

	public void paintComponent(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 229);

		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 200);
		g.drawLine(0, 199, 399, 199);
		g.drawLine(399, 0, 399, 199);
   
		int aantallege = 199-model.aantalLegeVakken/2;
		
		if (aantallege < 2) {
			aantallege = 1;
		}
		int aantaladhoc= 199-model.aantalCarAdHoc/2;
		
		if (aantaladhoc < 2) {
			aantaladhoc = 1;
		}

		createBar(g, ColorList.LEGE_VAKKEN, 3, aantallege, 60, 199);
		createBar(g, ColorList.CAR_AD_HOC, 66, aantaladhoc, 60, 199);
		createBar(g, ColorList.CAR_PARKING_PASS, 135, 199-model.aantalCarParkingPass/2 , 60, 199);
		createBar(g, ColorList.ELEKTRISCHE_CAR, 201, 1, 60, model.aantalCarElektrisch/2);
		createBar(g, ColorList.INVALIDE_CAR, 267, 1, 60, model.aantalCarInvalide/2);
		createBar(g, ColorList.MOTOR, 333, 1, 60, model.aantalCarMotor/2);
	}
	
	private void createBar(Graphics g, Color color, int x, int y, int width, int height) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		 	}

	
}
