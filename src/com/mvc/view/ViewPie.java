package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.lib.ColorList;
import com.mvc.model.Model;

public class ViewPie extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	
	private JLabel aantalCarAdHoc 	 = new JLabel(""+model.aantalCarAdHoc);
	private JLabel aantalCarParkingPass 	 = new JLabel(""+model.aantalCarParkingPass);
	private JLabel aantalLegeVakken  = new JLabel(""+model.aantalLegeVakken);

	public ViewPie(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
		
		this.addNumberView(aantalLegeVakken, 230, 10, 250, 20, true);
		this.addNumberView(aantalCarAdHoc, 230, 40, 250, 20, true);
		this.addNumberView(aantalCarParkingPass, 230, 70, 250, 20, true);
	}
	
	// Methode om de nummers in de legenda te updaten
	public void updateNumbers() {
		aantalLegeVakken.setText("Lege Vakken                   "+model.aantalLegeVakken);
		aantalCarAdHoc.setText("AdHoc Parkeerders      "+model.aantalCarAdHoc);
		aantalCarParkingPass.setText("Abonnementhouders    "+model.aantalCarParkingPass);
	}
	

	// Methode om gemakkelijk een legenda toe te voegen (tekst)
	public void addNumberView(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
	}

	public void paintComponent(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 200);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 200);
		g.drawLine(0, 199, 399, 199);
		g.drawLine(399, 0, 399, 199);
		
		// Creëer pieview voor de lege vakken
		g.setColor(ColorList.LEGE_VAKKEN);
		g.fillArc(10, 10, 180, 180, 360-(aantalBerekening(model.aantalCarAdHoc)+aantalBerekening(model.aantalCarParkingPass)), 360);
		
		// Creëer pieview voor de AdHoc autos
		g.setColor(ColorList.CAR_AD_HOC);
		g.fillArc(10, 10, 180, 180, 0, (int) (aantalBerekening(model.aantalCarAdHoc)));
		
		// Creëer pieview voor de autos met een ParkingPass
		g.setColor(ColorList.CAR_PARKING_PASS);
		g.fillArc(10, 10, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc)), (int) (aantalBerekening(model.aantalCarParkingPass)));
		
		// Creëer legenda voor de lege vakken
		g.setColor(ColorList.LEGE_VAKKEN);
		g.fillRect(aantalLegeVakken.getX()-15, aantalLegeVakken.getY()+6, 8, 8);
		
		// Creëer legenda voor de AdHoc cars
		g.setColor(ColorList.CAR_AD_HOC);
		g.fillRect(aantalCarAdHoc.getX()-15, aantalCarAdHoc.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		g.setColor(ColorList.CAR_PARKING_PASS);
		g.fillRect(aantalCarParkingPass.getX()-15, aantalCarParkingPass.getY()+6, 8, 8);
		
		// Update de getallen in de legenda (moet altijd gedaan worden als de getallen worden geüpdate)
		updateNumbers();
	}
	
	// Een methode om 540 plekken te berekenen in een 360 graden cirkel
	private int aantalBerekening(int aantal) {
		if (aantal > 0 && aantal <= 1) {return 1;}
		else {return (int) (Math.floor(aantal/1.5));}
	}	
}
