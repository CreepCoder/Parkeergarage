package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.lib.Methods;
import com.mvc.model.Model;

public class ViewMoney extends AbstractView {

	/**
	 * Deze klasse laat het inkomen zien en de lengte van de queues.
	 */
	private static final long serialVersionUID = 1L;
	
	private int parkeerkostenCarAdHoc;
	private int parkeerkostenCarElektrisch;
	private int parkeerkostenCarInvalide;
	private int parkeerkostenCarMotor;
	private int parkeerkostenCarParkingPass;
	
	private int entranceCarQueueLength;
	private int entrancePassQueueLength;
	private int paymentCarQueueLength;
	private int exitCarQueueLength;
//	private int totalCarQueue;
	
	private JLabel titel						= new JLabel("Overzicht van alle inkomens en CarQueues", SwingConstants.CENTER);

	private JLabel titelInkomenCarAdHoc 		= new JLabel();
	private JLabel titelInkomenCarParkingPass 	= new JLabel();
	private JLabel titelInkomenCarElektrisch  	= new JLabel();
	private JLabel titelInkomenCarInvalide  	= new JLabel();
	private JLabel titelInkomenCarMotor  		= new JLabel();
	private JLabel titelInkomenAllCars  		= new JLabel();
	
	private JLabel totaalInkomenCarAdHoc 		= new JLabel();
	private JLabel totaalInkomenCarParkingPass 	= new JLabel();
	private JLabel totaalInkomenCarElektrisch  	= new JLabel();
	private JLabel totaalInkomenCarInvalide  	= new JLabel();
	private JLabel totaalInkomenCarMotor  		= new JLabel();
	private JLabel totaalInkomenAllCars  		= new JLabel();
	
	
	private JLabel titelEntranceCarQueue 		= new JLabel();
	private JLabel titelEntrancePassQueue 		= new JLabel();
	private JLabel titelPaymentCarQueue 		= new JLabel();
	private JLabel titelExitCarQueue 			= new JLabel();
	
	private JLabel aantalEntranceCarQueue			= new JLabel(""+entranceCarQueueLength);
	private JLabel aantalEntrancePassQueue			= new JLabel(""+entrancePassQueueLength);
	private JLabel aantalPaymentCarQueue			= new JLabel(""+paymentCarQueueLength);
	private JLabel aantalExitCarQueue			= new JLabel(""+exitCarQueueLength);
//	private JLabel aantalTotalCarQueue			= new JLabel(""+totalCarQueue);
	
	public ViewMoney(Model model) {
		super(model);
		this.setLayout(null);
		
		this.parkeerkostenCarAdHoc = 4;
		this.parkeerkostenCarElektrisch = 8;
		this.parkeerkostenCarInvalide = 4;
		this.parkeerkostenCarMotor = 3;
		this.parkeerkostenCarParkingPass = 0;
		
		this.entranceCarQueueLength = 0;
		this.entrancePassQueueLength = 0;
		this.paymentCarQueueLength = 0;
		this.exitCarQueueLength = 0;
		
		Methods.voegLabelToe(titel, 10, 5, 250, 20, true, this, SwingConstants.LEFT);
		// Voeg inkomen toe
		Methods.voegLabelToe(titelInkomenCarAdHoc, 10, 35, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarParkingPass, 10, titelInkomenCarAdHoc.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarElektrisch, 10, titelInkomenCarParkingPass.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarInvalide, 10, titelInkomenCarElektrisch.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarMotor, 10, titelInkomenCarInvalide.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenAllCars, 10, titelInkomenCarMotor.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		
		Methods.voegLabelToe(totaalInkomenCarAdHoc, 10, 35, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarParkingPass, 10, totaalInkomenCarAdHoc.getY()+30, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarElektrisch, 10, totaalInkomenCarParkingPass.getY()+30, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarInvalide, 10, totaalInkomenCarElektrisch.getY()+30, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarMotor, 10, totaalInkomenCarInvalide.getY()+30, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenAllCars, 10, totaalInkomenCarMotor.getY()+30, 250, 20, true, this, SwingConstants.RIGHT);
		
		// Voeg queues toe
		Methods.voegLabelToe(titelEntranceCarQueue, 10, 220, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelEntrancePassQueue, 10, 250, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelPaymentCarQueue, 10, 280, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelExitCarQueue, 10, 310, 250, 20, true, this, SwingConstants.LEFT);
		
		Methods.voegLabelToe(aantalEntranceCarQueue, 10, 220, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalEntrancePassQueue, 10, 250, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalPaymentCarQueue, 10, 280, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalExitCarQueue, 10, 310, 250, 20, true, this, SwingConstants.RIGHT);
		
	}
	
	
	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-1);
		
		updateMoneyNumbers();
	}
	
	private void updateMoneyNumbers() {
		// bereken het inkomen
		int inkomenCarAdHoc = model.aantalBetaaldCarAdHoc * parkeerkostenCarAdHoc;
		int inkomenCarParkingPass = model.aantalBetaaldCarParkingPass * parkeerkostenCarParkingPass;
		int inkomenCarElektrisch = model.aantalBetaaldCarElektrisch * parkeerkostenCarElektrisch;
		int inkomenCarInvalide = model.aantalBetaaldCarInvalide * parkeerkostenCarInvalide;
		int inkomenCarMotor = model.aantalBetaaldCarMotor * parkeerkostenCarMotor;
		int inkomenAllCars = inkomenCarAdHoc + inkomenCarParkingPass + inkomenCarElektrisch + inkomenCarInvalide + inkomenCarMotor;
		
		titelInkomenCarAdHoc.setText("Inkomen AdHoc");
		titelInkomenCarParkingPass.setText("Inkomen Abonees");
		titelInkomenCarElektrisch.setText("Inkomen Elektrisch");
		titelInkomenCarInvalide.setText("Inkomen Minder Valide");
		titelInkomenCarMotor.setText("Inkomen Motor");
		titelInkomenAllCars.setText("Totale inkomen");
		
		totaalInkomenCarAdHoc.setText(""+inkomenCarAdHoc);
		totaalInkomenCarParkingPass.setText(""+inkomenCarParkingPass);
		totaalInkomenCarElektrisch.setText(""+inkomenCarElektrisch);
		totaalInkomenCarInvalide.setText(""+inkomenCarInvalide);
		totaalInkomenCarMotor.setText(""+inkomenCarMotor);
		totaalInkomenAllCars.setText(""+ inkomenAllCars);
		
		
		titelEntranceCarQueue.setText("Entrance Car Queue: ");
		titelEntrancePassQueue.setText("Entrance Pass Queue: ");
		titelPaymentCarQueue.setText("Payment car Queue: ");
		titelExitCarQueue.setText("Exit Car Queue");
		
		entranceCarQueueLength = Model.entranceCarQueue.carsInQueue();
		entrancePassQueueLength = Model.entrancePassQueue.carsInQueue();
		paymentCarQueueLength = Model.paymentCarQueue.carsInQueue();
		exitCarQueueLength = Model.exitCarQueue.carsInQueue();
		aantalEntranceCarQueue.setText(""+entranceCarQueueLength);
		aantalEntrancePassQueue.setText(""+entrancePassQueueLength);
		aantalPaymentCarQueue.setText(""+paymentCarQueueLength);
		aantalExitCarQueue.setText(""+exitCarQueueLength);
		
		adjustCarQueueColors(aantalEntranceCarQueue, entranceCarQueueLength);
		adjustCarQueueColors(aantalEntrancePassQueue, entrancePassQueueLength);
		adjustCarQueueColors(aantalPaymentCarQueue, paymentCarQueueLength);
		adjustCarQueueColors(aantalExitCarQueue, exitCarQueueLength);
	}
	
	private void adjustCarQueueColors(JLabel label, int carQueueLength) {
		int r = 51;
		int g = 51;
		int b = 51;
		label.setForeground(new Color(r,g,b));
		// Verander de kleur bij verschillende queue lengtes
		if (carQueueLength > 0 && carQueueLength <= 10) {
			label.setForeground(Color.orange);
		}
		else if (carQueueLength > 10) {
			label.setForeground(Color.red);
			//label.setText(label.getText()+"!");
		}
	}
	
}
