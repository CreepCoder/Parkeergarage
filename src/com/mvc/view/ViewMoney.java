package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.lib.ColorList;
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
	
	private JLabel titel						= new JLabel("Overzicht van alle inkomens in euro's", SwingConstants.CENTER);

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
	
	private JLabel titelMisgelopenCars 			= new JLabel("Misgelopen auto's");
	private JLabel aantalMisgelopenCars 		= new JLabel();
	
	private JLabel titelCarQueues				= new JLabel("Overzicht van aantal auto's in de rij", SwingConstants.CENTER);

	private JLabel titelEntranceCarQueue 		= new JLabel();
	private JLabel titelEntrancePassQueue 		= new JLabel();
	private JLabel titelPaymentCarQueue 		= new JLabel();
	private JLabel titelExitCarQueue 			= new JLabel();
	
	private JLabel aantalEntranceCarQueue		= new JLabel(""+entranceCarQueueLength);
	private JLabel aantalEntrancePassQueue		= new JLabel(""+entrancePassQueueLength);
	private JLabel aantalPaymentCarQueue		= new JLabel(""+paymentCarQueueLength);
	private JLabel aantalExitCarQueue			= new JLabel(""+exitCarQueueLength);
//	private JLabel aantalTotalCarQueue			= new JLabel(""+totalCarQueue);
	
	private JLabel titelLegend					= new JLabel("Legenda van de parkeerauto kleuren", SwingConstants.CENTER);
	private JLabel titelLegeVakken  		 = new JLabel("Lege Vakken");
	private JLabel titelCarAdHoc 			 = new JLabel("AdHoc Vakken");
	private JLabel titelCarParkingPass 	 	 = new JLabel("Abonnementhouders");
	private JLabel titelCarElektrisch  	 	 = new JLabel("Elektrische Vakken");
	private JLabel titelCarInvalide  		 = new JLabel("Minder Valide Vakken");
	private JLabel titelCarMotor  		 	 = new JLabel("Vakken voor Motoren");

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
		
		Methods.voegLabelToe(titel, 0, 5, 355, 20, true, this, SwingConstants.CENTER);
		// Voeg inkomen toe
		Methods.voegLabelToe(titelInkomenCarAdHoc, 10, titel.getY()+25, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarParkingPass, 10, titelInkomenCarAdHoc.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarElektrisch, 10, titelInkomenCarParkingPass.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarInvalide, 10, titelInkomenCarElektrisch.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenCarMotor, 10, titelInkomenCarInvalide.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelInkomenAllCars, 10, titelInkomenCarMotor.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		
		Methods.voegLabelToe(totaalInkomenCarAdHoc, 16, 30, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarParkingPass, 16, totaalInkomenCarAdHoc.getY()+20, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarElektrisch, 16, totaalInkomenCarParkingPass.getY()+20, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarInvalide, 16, totaalInkomenCarElektrisch.getY()+20, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenCarMotor, 16, totaalInkomenCarInvalide.getY()+20, 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(totaalInkomenAllCars, 16, totaalInkomenCarMotor.getY()+20, 250, 20, true, this, SwingConstants.RIGHT);
		
		Methods.voegLabelToe(titelCarQueues, 0, titelInkomenAllCars.getY()+40, 355, 20, true, this, SwingConstants.CENTER);
		// Voeg queues toe
		Methods.voegLabelToe(titelEntranceCarQueue, 10, titelCarQueues.getY()+25, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelEntrancePassQueue, 10, titelEntranceCarQueue.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelPaymentCarQueue, 10, titelEntrancePassQueue.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelExitCarQueue, 10, titelPaymentCarQueue.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelMisgelopenCars, 10, titelExitCarQueue.getY()+20, 250, 20, true, this, SwingConstants.LEFT);

		Methods.voegLabelToe(aantalEntranceCarQueue, 10, titelEntranceCarQueue.getY(), 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalEntrancePassQueue, 10, titelEntrancePassQueue.getY(), 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalPaymentCarQueue, 10, titelPaymentCarQueue.getY(), 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalExitCarQueue, 10, titelExitCarQueue.getY(), 250, 20, true, this, SwingConstants.RIGHT);
		Methods.voegLabelToe(aantalMisgelopenCars, 10, titelMisgelopenCars.getY(), 250, 20, true, this, SwingConstants.RIGHT);

		Methods.voegLabelToe(titelLegend, 0, titelMisgelopenCars.getY()+40, 355, 20, true, this, SwingConstants.CENTER);
		// Voeg legenda toe
		Methods.voegLabelToe(titelLegeVakken, 25, titelLegend.getY()+25, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarAdHoc, 25, titelLegeVakken.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarParkingPass, 25, titelCarAdHoc.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarElektrisch, 25, titelCarParkingPass.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarInvalide, 25, titelCarElektrisch.getY()+20, 250, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(titelCarMotor, 25, titelCarInvalide.getY()+20, 250, 20, true, this, SwingConstants.LEFT);

//		Methods.voegLabelToe(aantalLegeVakken, titelLegeVakken.getX()+140, 35, 250, 20, true, this, SwingConstants.LEFT);
//		Methods.voegLabelToe(aantalCarAdHoc, titelCarAdHoc.getX()+140, aantalLegeVakken.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
//		Methods.voegLabelToe(aantalCarParkingPass, titelCarParkingPass.getX()+140, aantalCarAdHoc.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
//		Methods.voegLabelToe(aantalCarElektrisch, titelCarElektrisch.getX()+140, aantalCarParkingPass.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
//		Methods.voegLabelToe(aantalCarInvalide, titelCarInvalide.getX()+140, aantalCarElektrisch.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
//		Methods.voegLabelToe(aantalCarMotor, titelCarMotor.getX()+140, aantalCarInvalide.getY()+30, 250, 20, true, this, SwingConstants.LEFT);
		
	}
	
	
	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-1);
		g.drawLine(10, titelInkomenAllCars.getY(), 266, titelInkomenAllCars.getY());
		g.drawLine(0, titelInkomenAllCars.getY()+35, this.getWidth(), titelInkomenAllCars.getY()+35);
		g.drawLine(0, titelMisgelopenCars.getY()+35, this.getWidth(), titelMisgelopenCars.getY()+35);
		
		
		// Creëer legenda voor de lege vakken
		createLegend(g, ColorList.LEGE_VAKKEN, 10, titelLegeVakken.getY()+6, 8, 8);
		
		// Creëer legenda voor de AdHoc cars
		createLegend(g, ColorList.CAR_AD_HOC, 10, titelCarAdHoc.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.CAR_PARKING_PASS, 10, titelCarParkingPass.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.ELEKTRISCHE_CAR, 10, titelCarElektrisch.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.INVALIDE_CAR, 10, titelCarInvalide.getY()+6, 8, 8);
		
		// Creëer legenda voor de cars with a ParkingPass
		createLegend(g, ColorList.MOTOR, 10, titelCarMotor.getY()+6, 8, 8);
		
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
		
//		int misgelopenInkomenCarAdHoc = model.aantalNotEnteredCarAdHoc * parkeerkostenCarAdHoc;
//		int misgelopenInkomenCarParkingPass = model.aantalNotEnteredCarAbonnement * parkeerkostenCarParkingPass;
//		int misgelopenInkomenCarElektrisch = model.aantalNotEnteredCarElektrisch * parkeerkostenCarElektrisch;
//		int misgelopenInkomenCarInvalide = model.aantalNotEnteredCarInvalide * parkeerkostenCarInvalide;
//		int misgelopenInkomenCarMotor = model.aantalNotEnteredCarMotor * parkeerkostenCarMotor;
//		int misgelopenCars = misgelopenInkomenCarAdHoc + misgelopenInkomenCarParkingPass + misgelopenInkomenCarElektrisch + misgelopenInkomenCarInvalide + misgelopenInkomenCarMotor;

		int misgelopenCars = model.aantalNotEnteredCarAdHoc + model.aantalNotEnteredCarAbonnement + model.aantalNotEnteredCarElektrisch + model.aantalNotEnteredCarInvalide + model.aantalNotEnteredCarMotor;
		titelInkomenCarAdHoc.setText("Inkomsten AdHoc");
		titelInkomenCarParkingPass.setText("Inkomsten Abonnees");
		titelInkomenCarElektrisch.setText("Inkomsten Elektrisch");
		titelInkomenCarInvalide.setText("Inkomsten Minder Valide");
		titelInkomenCarMotor.setText("Inkomsten Motor");
		titelInkomenAllCars.setText("Totale inkomsten");
		
		totaalInkomenCarAdHoc.setText("€ "+inkomenCarAdHoc+",-");
		totaalInkomenCarParkingPass.setText("€ "+inkomenCarParkingPass+",-");
		totaalInkomenCarElektrisch.setText("€ "+inkomenCarElektrisch+",-");
		totaalInkomenCarInvalide.setText("€ "+inkomenCarInvalide+",-");
		totaalInkomenCarMotor.setText("€ "+inkomenCarMotor+",-");
		totaalInkomenAllCars.setText("€ "+ inkomenAllCars+",-");
		
		titelEntranceCarQueue.setText("Standaard Ingang");
		titelEntrancePassQueue.setText("Ingang voor Abonnees");
		titelPaymentCarQueue.setText("Betaalautomaat");
		titelExitCarQueue.setText("Uitgang");
		aantalMisgelopenCars.setText(""+misgelopenCars);
		
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
	
	private void createLegend(Graphics g, Color color, int x, int y, int width, int height) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	
}
