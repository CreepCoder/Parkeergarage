package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.car.Car;
import com.lib.ColorList;
import com.location.LocationMap;
import com.location.Map;
import com.mechanic.CarQueue;
import com.mvc.model.Model;

public class ViewMoney extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int geldCarAdHoc;
	private int geldCarParkingPass;
	private int geldCarElektrisch;
	private int geldCarInvalide;
	private int geldCarMotor;
	
	private int totaalGeldCarAdHoc;
	private int totaalGeldCarParkingPass;
	private int totaalGeldCarElektrisch;
	private int totaalGeldCarInvalide;
	private int totaalGeldCarMotor;
	
	private int gemiddeldGeldKaas;
	
	private int entranceCarQueue;
	private int entrancePassQueue;
	private int paymentCarQueue;
	private int exitCarQueue;
	private int totalCarQueue;
	
	private int carsNotEntered;
	
	// model.aantalCarAdHoc * geldCarElektrisch
	private JLabel aantalLegeVakken  		 			= new JLabel(""+model.aantalLegeVakken);
	
	private JLabel aantalGeldCarAdHoc 					= new JLabel(""+totaalGeldCarAdHoc);
	private JLabel aantalGeldCarParkingPass 			= new JLabel(""+totaalGeldCarParkingPass);
	private JLabel aantalGeldCarElektrisch  			= new JLabel(""+totaalGeldCarElektrisch);
	private JLabel aantalGeldCarInvalide  				= new JLabel(""+totaalGeldCarInvalide);
	private JLabel aantalGeldCarMotor  		 			= new JLabel(""+totaalGeldCarMotor);
	
	private JLabel gemiddeldAantalGeldCarAdHoc			= new JLabel(""+gemiddeldGeldKaas);
	
	private JLabel aantalEntranceCarQueue			= new JLabel(""+entranceCarQueue);
	private JLabel aantalEntrancePassQueue			= new JLabel(""+entrancePassQueue);
	private JLabel aantalPaymentCarQueue			= new JLabel(""+paymentCarQueue);
	private JLabel aantalExitCarQueue			= new JLabel(""+exitCarQueue);
	private JLabel aantalTotalCarQueue			= new JLabel(""+totalCarQueue);

	
	public ViewMoney(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
		
		this.geldCarAdHoc = 1;
		this.geldCarElektrisch = 2;
		this.geldCarInvalide = 3;
		this.geldCarMotor = 4;
		this.geldCarParkingPass = 5;
		
		this.totaalGeldCarAdHoc = 0;
		this.totaalGeldCarParkingPass = 0;
		this.totaalGeldCarElektrisch = 0;
		this.totaalGeldCarInvalide = 0;
		this.totaalGeldCarMotor = 0;
		
		this.gemiddeldGeldKaas = 0;
		
		this.entranceCarQueue = 0;
		this.entrancePassQueue = 0;
		this.paymentCarQueue = 0;
		this.exitCarQueue = 0;
		this.totalCarQueue = 0;

		this.carsNotEntered = 0;
		
		this.addNumberView(aantalLegeVakken, 10, 10, 250, 20, true);
		this.addNumberView(aantalGeldCarAdHoc, 10, 40, 250, 20, true);
		this.addNumberView(aantalGeldCarParkingPass, 10, 70, 250, 20, true);
		this.addNumberView(aantalGeldCarElektrisch, 10, 100, 250, 20, true);
		this.addNumberView(aantalGeldCarInvalide, 10, 130, 250, 20, true);
		this.addNumberView(aantalGeldCarMotor, 10, 160, 250, 20, true);
		
		this.addNumberView(gemiddeldAantalGeldCarAdHoc, 10, 190, 250, 20, true);
		
		this.addNumberView(aantalEntranceCarQueue, 10, 220, 250, 20, true);
		this.addNumberView(aantalEntrancePassQueue, 10, 250, 250, 20, true);
		this.addNumberView(aantalPaymentCarQueue, 10, 280, 250, 20, true);
		this.addNumberView(aantalExitCarQueue, 10, 310, 250, 20, true);
		this.addNumberView(aantalTotalCarQueue, 10, 340, 250, 20, true);


	}
	
	
	private void addNumberView(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
		
	}
	
	
	public void paintComponent(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 300, 460);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 459);
		g.drawLine(0, 459, 299, 459);
		g.drawLine(299, 0, 299, 459);
		
		updateNumbers();
	}
	
	
	private void updateNumbers() {
		// aantal geld
		totaalGeldCarAdHoc = model.aantalCarAdHoc * geldCarAdHoc;
		totaalGeldCarParkingPass = model.aantalCarParkingPass * geldCarParkingPass;
		totaalGeldCarElektrisch = model.aantalCarElektrisch * geldCarElektrisch;
		totaalGeldCarInvalide = model.aantalCarInvalide * geldCarInvalide;
		totaalGeldCarMotor = model.aantalCarMotor * geldCarMotor;
		
		
		aantalLegeVakken.setText("Aantal lege vakken: "+model.aantalLegeVakken);
		aantalGeldCarAdHoc.setText("aantalGeldCarAdHoc: "+totaalGeldCarAdHoc);
		aantalGeldCarParkingPass.setText("aantalGeldCarParkingPass: "+totaalGeldCarParkingPass);
		aantalGeldCarElektrisch.setText("aantalGeldCarElektrisch: "+totaalGeldCarElektrisch);
		aantalGeldCarInvalide.setText("aantalGeldCarInvalide: "+totaalGeldCarInvalide);
		aantalGeldCarMotor.setText("aantalGeldCarMotor: "+totaalGeldCarMotor);
		
		// bereken gemiddeld geld (van KAAS)
		gemiddeldGeldKaas = 0;
		gemiddeldAantalGeldCarAdHoc.setText("gemiddeldAantalGeldKaas: "+gemiddeldGeldKaas);
		//gemiddeldGeldCarAdHoc += Model.exitCarQueue.carsInQueue();
		entranceCarQueue = Model.entranceCarQueue.carsInQueue();
		entrancePassQueue = Model.entrancePassQueue.carsInQueue();
		paymentCarQueue = Model.paymentCarQueue.carsInQueue();
		exitCarQueue = Model.exitCarQueue.carsInQueue();
		aantalEntranceCarQueue.setText("aantalEntranceCarQueue: "+entranceCarQueue);
		aantalEntrancePassQueue.setText("aantalEntrancePassQueue: "+entrancePassQueue);
		aantalPaymentCarQueue.setText("aantalPaymentCarQueue: "+paymentCarQueue);
		aantalExitCarQueue.setText("aantalExitCarQueue: "+exitCarQueue);
		aantalTotalCarQueue.setText("aantalTotalCarQueue: "+totalCarQueue);
		
	}
	
}
