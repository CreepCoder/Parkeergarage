package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.car.Car;
import com.lib.ColorList;
import com.location.Map;
import com.mvc.model.Model;

public class ViewMoney extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel aantalLegeVakken  		 = new JLabel(""+model.aantalLegeVakken);
	private JLabel aantalCarAdHoc 			 = new JLabel(""+model.aantalCarAdHoc);
	private JLabel aantalCarParkingPass 	 = new JLabel(""+model.aantalCarParkingPass);
	private JLabel aantalCarElektrisch  		 = new JLabel(""+model.aantalCarElektrisch);
	private JLabel aantalCarInvalide  		 	 = new JLabel(""+model.aantalCarInvalide);
	private JLabel aantalCarMotor  		 	 = new JLabel(""+model.aantalCarMotor);
	
	public ViewMoney(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
		
	}
	
	
	public void getNumbers(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 200);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 200);
		g.drawLine(0, 199, 399, 199);
		g.drawLine(399, 0, 399, 199);
	}
	
	public void Calculate(String car) {
		//
		ArrayList<Integer> loc = new ArrayList<Integer>();
		Map m = new Map(model);
//		m.getCarAt(location);
//		
//    	if (location != null && car != null) {
//    		car.setLocationmap(location);
//    		location.setCar(new Car(car.getType()));
//    	}

		
		
		
		// bereken de hoeveelheid geld voor de juiste auto
//		if (int i == aantalCarAdHoc)) {
//			int waarde = 1;
//		}
//		if (int i == aantalCarElektrisch)) {
//			int waarde = 1;
//		}
//		if (int i == aantalCarInvalide)) {
//			int waarde = 1;
//		}
//		if (int i == aantalCarMotor)) {
//			int waarde = 1;
//		}
//		if (int i == aantalCarParkingPass)) {
//			int waarde = 1;
//		}
//		if (int i == aantalLegeVakken)) {
//			int waarde = 1;
//		}

		
		
	}
	
	public void updateNumbers() {
		//
	}
	
	
}
