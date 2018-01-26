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
	
	private int geldCarAdHoc;
	private int geldCarElektrisch;
	private int geldCarInvalide;
	private int geldCarMotor;
	private int geldCarParkingPass;
	
	public ViewMoney(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
		
		this.geldCarAdHoc = 0;
		this.geldCarElektrisch = 0;
		this.geldCarInvalide = 0;
		this.geldCarMotor = 0;
		this.geldCarParkingPass = 0;
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
	}
	
	
	public void CalculateNumbers(String car) {
		
		ArrayList<Integer> loc = new ArrayList<Integer>();
		Map m = new Map(model);
		
		
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
	
	
}
