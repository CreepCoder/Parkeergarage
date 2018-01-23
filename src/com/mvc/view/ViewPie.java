package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.lib.ColorList;
import com.location.Map;
import com.mvc.model.Model;

public class ViewPie extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	
	private JLabel aantalLegeVakken  		 = new JLabel(""+model.aantalLegeVakken);
	private JLabel aantalCarAdHoc 			 = new JLabel(""+model.aantalCarAdHoc);
	private JLabel aantalCarParkingPass 	 = new JLabel(""+model.aantalCarParkingPass);
	private JLabel aantalCarElektrisch  		 = new JLabel(""+model.aantalCarElektrisch);
	private JLabel aantalCarInvalide  		 	 = new JLabel(""+model.aantalCarInvalide);
	private JLabel aantalCarMotor  		 	 = new JLabel(""+model.aantalCarMotor);

	public ViewPie(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
		
		this.addNumberView(aantalLegeVakken, 220, 10, 250, 20, true);
		this.addNumberView(aantalCarAdHoc, 220, 40, 250, 20, true);
		this.addNumberView(aantalCarParkingPass, 220, 70, 250, 20, true);
		this.addNumberView(aantalCarElektrisch, 220, 100, 250, 20, true);
		this.addNumberView(aantalCarInvalide, 220, 130, 250, 20, true);
		this.addNumberView(aantalCarMotor, 220, 160, 250, 20, true);
	}
	
	// Methode om de nummers in de legenda te updaten
	public void updateNumbers() {
		aantalLegeVakken.setText("Lege Vakken                         "+model.aantalLegeVakken);
		aantalCarAdHoc.setText("AdHoc Parkeerders            "+model.aantalCarAdHoc);
		aantalCarParkingPass.setText("Abonnementhouders          "+model.aantalCarParkingPass);
		aantalCarElektrisch.setText("Elektrische Parkeerders   "+model.aantalCarElektrisch);
		aantalCarInvalide.setText("Invalide Parkeerders          "+model.aantalCarInvalide);
		aantalCarMotor.setText("Motoren                                  "+model.aantalCarMotor);
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
		createSlice(g, ColorList.LEGE_VAKKEN, 10, 10, 180, 180, 360-(aantalBerekening(model.aantalCarAdHoc)+aantalBerekening(model.aantalCarParkingPass)), 360);
		
		// Creëer pieview voor de AdHoc autos
		createSlice(g, ColorList.CAR_AD_HOC, 10, 10, 180, 180, 0, (int) (aantalBerekening(model.aantalCarAdHoc)));
		
		// Creëer pieview voor de autos met een ParkingPass
		createSlice(g, ColorList.CAR_PARKING_PASS, 10, 10, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc)), (int) (aantalBerekening(model.aantalCarParkingPass)));
		
		// Creëer pieview voor de elektrische autos
		createSlice(g, ColorList.ELEKTRISCHE_CAR, 10, 10, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc))+(int) (aantalBerekening(model.aantalCarParkingPass)), 
				(int) (aantalBerekening(model.aantalCarElektrisch)));
		
		// Creëer pieview voor de invalide parkeerders
		createSlice(g, ColorList.INVALIDE_CAR, 10, 10, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc))+(int) (aantalBerekening(model.aantalCarParkingPass))+(int) (aantalBerekening(model.aantalCarElektrisch)), 
				(int) (aantalBerekening(model.aantalCarInvalide)));
		
		// Creëer pieview voor de motoren
		createSlice(g, ColorList.MOTOR, 10, 10, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc))+(int) (aantalBerekening(model.aantalCarParkingPass))+(int) (aantalBerekening(model.aantalCarElektrisch))+(int) (aantalBerekening(model.aantalCarInvalide)), 
				(int) (aantalBerekening(model.aantalCarMotor)));
		
		// Creëer legenda voor de lege vakken
		createLegend(g, ColorList.LEGE_VAKKEN, aantalLegeVakken.getX()-15, aantalLegeVakken.getY()+6, 8, 8);
		
		// Creëer legenda voor de AdHoc cars
		createLegend(g, ColorList.CAR_AD_HOC, aantalCarAdHoc.getX()-15, aantalCarAdHoc.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.CAR_PARKING_PASS, aantalCarParkingPass.getX()-15, aantalCarParkingPass.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.ELEKTRISCHE_CAR, aantalCarElektrisch.getX()-15, aantalCarElektrisch.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.INVALIDE_CAR, aantalCarInvalide.getX()-15, aantalCarInvalide.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.MOTOR, aantalCarMotor.getX()-15, aantalCarMotor.getY()+6, 8, 8);
		
		// Update de getallen in de legenda (moet altijd gedaan worden als de getallen worden geüpdate)
		updateNumbers();
	}
	
	// Een methode om 540 plekken te berekenen in een 360 graden cirkel
	private int aantalBerekening(int aantal) {
		if (aantal > 0 && aantal <= 1) {return 1;}
		else {return (int) (Math.floor(aantal/1.5));}
	}	
	
	private void createSlice(Graphics g, Color color, int x, int y, int width, int height, int startAngle, int arcAngle) {
		g.setColor(color);
		g.fillArc(x, y, width, height, startAngle, arcAngle);
	}
	
	private void createLegend(Graphics g, Color color, int x, int y, int width, int height) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
