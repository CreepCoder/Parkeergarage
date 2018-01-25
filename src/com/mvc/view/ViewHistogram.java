package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import com.lib.ColorList;
import com.mvc.model.Model;

public class ViewHistogram extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	
	private JLabel aantalLegeVakken  		 = new JLabel(""+model.aantalLegeVakken);
	private JLabel aantalCarAdHoc 			 = new JLabel(""+model.aantalCarAdHoc);
	private JLabel aantalCarParkingPass 	 = new JLabel(""+model.aantalCarParkingPass);
	private JLabel aantalCarElektrisch  		 = new JLabel(""+model.aantalCarElektrisch);
	private JLabel aantalCarInvalide  		 	 = new JLabel(""+model.aantalCarInvalide);
	private JLabel aantalCarMotor  		 	 = new JLabel(""+model.aantalCarMotor);

	public ViewHistogram(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
	}
	

	// Methode om gemakkelijk een legenda toe te voegen (tekst)
	

	public void paintComponent(Graphics g) {
		// Cre�er achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 200);
		
		// Cre�er belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 200);
		g.drawLine(0, 199, 399, 199);
		g.drawLine(399, 0, 399, 199);
     
		createBar(g, ColorList.LEGE_VAKKEN, 3, 199, 60, model.aantalLegeVakken/2);
		createBar(g, ColorList.CAR_AD_HOC, 66, -199, 60, model.aantalCarAdHoc/2);
		createBar(g, ColorList.CAR_PARKING_PASS, 135, 1, 60, model.aantalCarParkingPass/2);
		createBar(g, ColorList.ELEKTRISCHE_CAR, 201, 1, 60, model.aantalCarElektrisch/2);
		createBar(g, ColorList.INVALIDE_CAR, 267, 1, 60, model.aantalCarInvalide/2);
		createBar(g, ColorList.MOTOR, 333, 1, 60, model.aantalCarMotor/2);
		System.out.println(model.aantalLegeVakken);
	}
	
	private void createBar(Graphics g, Color color, int x, int y, int width, int height) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		 	}
}