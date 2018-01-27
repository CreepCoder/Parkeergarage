package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.lib.ColorList;
import com.lib.Methods;
import com.mvc.model.Model;

public class ViewPie extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	
	private JLabel titel					 = new JLabel("PieView van het aantal verschillende geparkeerde auto's", SwingConstants.CENTER);
	private JLabel titelLegeVakken  		 = new JLabel("Lege Vakken");
	private JLabel titelCarAdHoc 			 = new JLabel("AdHoc Vakken");
	private JLabel titelCarParkingPass 	 	 = new JLabel("Abonnementhouders");
	private JLabel titelCarElektrisch  	 	 = new JLabel("Elektrische Vakken");
	private JLabel titelCarInvalide  		 = new JLabel("Minder Valide Vakken");
	private JLabel titelCarMotor  		 	 = new JLabel("Vakken voor Motoren");
	
	private JLabel aantalLegeVakken  		 = new JLabel(""+model.aantalLegeVakken);
	private JLabel aantalCarAdHoc 			 = new JLabel(""+model.aantalCarAdHoc);
	private JLabel aantalCarParkingPass 	 = new JLabel(""+model.aantalCarAbonnement);
	private JLabel aantalCarElektrisch  	 = new JLabel(""+model.aantalCarElektrisch);
	private JLabel aantalCarInvalide  		 = new JLabel(""+model.aantalCarInvalide);
	private JLabel aantalCarMotor  		 	 = new JLabel(""+model.aantalCarMotor);

	public ViewPie(Model model) {
		super(model);
		this.setLayout(null);
		
		Methods.voegLabelToe(titel, 0, 5, 400, 20, true, this, SwingConstants.CENTER);
		Methods.voegLabelToe(titelLegeVakken,  215, 35, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarAdHoc, 215, titelLegeVakken.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarParkingPass, 215, titelCarAdHoc.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarElektrisch, 215, titelCarParkingPass.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarInvalide, 215, titelCarElektrisch.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarMotor, 215, titelCarInvalide.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		
		Methods.voegLabelToe(aantalLegeVakken, titelLegeVakken.getX()+140, 35, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(aantalCarAdHoc, titelCarAdHoc.getX()+140, aantalLegeVakken.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(aantalCarParkingPass, titelCarParkingPass.getX()+140, aantalCarAdHoc.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(aantalCarElektrisch, titelCarElektrisch.getX()+140, aantalCarParkingPass.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(aantalCarInvalide, titelCarInvalide.getX()+140, aantalCarElektrisch.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(aantalCarMotor, titelCarMotor.getX()+140, aantalCarInvalide.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
	}
	
	// Methode om de nummers in de legenda te updaten
	public void updatePieNumbers() {
		aantalLegeVakken.setText(""+model.aantalLegeVakken);
		aantalCarAdHoc.setText(""+model.aantalCarAdHoc);
		aantalCarParkingPass.setText(""+model.aantalCarAbonnement);
		aantalCarElektrisch.setText(""+model.aantalCarElektrisch);
		aantalCarInvalide.setText(""+model.aantalCarInvalide);
		aantalCarMotor.setText(""+model.aantalCarMotor);
	}

	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-1);
		
		// Creëer pieview voor de lege vakken
		createSlice(g, ColorList.LEGE_VAKKEN, 10, 35, 180, 180, 360-(aantalBerekening(model.aantalCarAdHoc)+aantalBerekening(model.aantalCarAbonnement)), 360);
		
		// Creëer pieview voor de AdHoc autos
		createSlice(g, ColorList.CAR_AD_HOC, 10, 35, 180, 180, 0, (int) (aantalBerekening(model.aantalCarAdHoc)));
		
		// Creëer pieview voor de autos met een ParkingPass
		createSlice(g, ColorList.CAR_PARKING_PASS, 10, 35, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc)), (int) (aantalBerekening(model.aantalCarAbonnement)));
		
		// Creëer pieview voor de elektrische autos
		createSlice(g, ColorList.ELEKTRISCHE_CAR, 10, 35, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc))+(int) (aantalBerekening(model.aantalCarAbonnement)), 
				(int) (aantalBerekening(model.aantalCarElektrisch)));
		
		// Creëer pieview voor de invalide parkeerders
		createSlice(g, ColorList.INVALIDE_CAR, 10, 35, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc))+(int) (aantalBerekening(model.aantalCarAbonnement))+(int) (aantalBerekening(model.aantalCarElektrisch)), 
				(int) (aantalBerekening(model.aantalCarInvalide)));
		
		// Creëer pieview voor de motoren
		createSlice(g, ColorList.MOTOR, 10, 35, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc))+(int) (aantalBerekening(model.aantalCarAbonnement))+(int) (aantalBerekening(model.aantalCarElektrisch))+(int) (aantalBerekening(model.aantalCarInvalide)), 
				(int) (aantalBerekening(model.aantalCarMotor)));
		
		// Creëer legenda voor de lege vakken
		createLegend(g, ColorList.LEGE_VAKKEN, 200, aantalLegeVakken.getY()+6, 8, 8);
		
		// Creëer legenda voor de AdHoc cars
		createLegend(g, ColorList.CAR_AD_HOC, 200, aantalCarAdHoc.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.CAR_PARKING_PASS, 200, aantalCarParkingPass.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.ELEKTRISCHE_CAR, 200, aantalCarElektrisch.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.INVALIDE_CAR, 200, aantalCarInvalide.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.MOTOR, 200, aantalCarMotor.getY()+6, 8, 8);
		
		// Update de getallen in de legenda (moet altijd gedaan worden als de getallen worden geüpdate)
		updatePieNumbers();
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
