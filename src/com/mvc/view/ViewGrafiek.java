package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.lib.Methods;
import com.main.Parkeergarage;
import com.mechanic.Type;
import com.mvc.model.Model;


public class ViewGrafiek extends AbstractView {
	/**
	 * Deze klasse geeft een lijngrafiek weer
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelX0 = new JLabel("0");
	private JLabel labelX1 = new JLabel("3");
	private JLabel labelX2 = new JLabel("6");
	private JLabel labelX3 = new JLabel("9");
	private JLabel labelX4 = new JLabel("12");
	private JLabel labelX5 = new JLabel("15");
	private JLabel labelX6 = new JLabel("18");
	private JLabel labelX7 = new JLabel("21");
	private JLabel labelX8 = new JLabel("24");
	private JLabel labelX9 = new JLabel(">  Dag in uren ");

	private static ArrayList<Integer> carAdHocY = new ArrayList<Integer>();
	private static ArrayList<Integer> carParkingPassY = new ArrayList<Integer>();
	private static ArrayList<Integer> carElektrischY = new ArrayList<Integer>();
	private static ArrayList<Integer> carInvalideY = new ArrayList<Integer>();
	private static ArrayList<Integer> carMotorY = new ArrayList<Integer>();
	
	public ViewGrafiek(Model model) {
		super(model);
		this.setSize(400, 230);
		this.setLayout(null);
		
		Methods.voegLabelToe(labelX0, 0, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX1, 47, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX2, 97, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX3, 147, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX4, 197, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX5, 247, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX6, 297, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX7, 347, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX8, 387, 205, 15, 10, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(labelX9, 303, 216, 100, 15, true, this, SwingConstants.LEFT);
	}

	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-30);
		
		// Voor de pijl
		g.drawLine(70, 223, 303, 223);
		
		// Voor de grid
		g.setColor(Color.lightGray);
		g.drawLine(1, 100, 398, 100);
		g.drawLine(1, 50, 398, 50);
		g.drawLine(1, 150, 398, 150);
		g.drawLine(50, 199, 50, 1);
		g.drawLine(100, 199, 100, 1);
		g.drawLine(150, 199, 150, 1);
		g.drawLine(200, 199, 200, 1);
		g.drawLine(250, 199, 250, 1);
		g.drawLine(300, 199, 300, 1);
		g.drawLine(350, 199, 350, 1);
		
		int x = 0;
		for(int coordy : carAdHocY) {
			g.setColor(Type.ADHOC.getColor());
			coordy = (int) (coordy * 0.55);
			g.drawLine((int) (x*0.27), 199-coordy, (int) ((x*0.27)+0.1), (int) ((199-coordy)-1));
			x++;
		}
		
		x = 0;
		for(int coordy : carParkingPassY) {
			g.setColor(Type.ABONNEMENT.getColor());
			coordy = (int) (coordy * 0.55);
			g.drawLine((int) (x*0.27), 199-coordy, (int) ((x*0.27)+0.1), (int) ((199-coordy)-1));
			x++;
		}
		
		x = 0;
		for(int coordy : carElektrischY) {
			g.setColor(Type.ELEKTRISCH.getColor());
			coordy = (int) (coordy * 0.55);
			g.drawLine((int) (x*0.27), 199-coordy, (int) ((x*0.27)+0.1), (int) ((199-coordy)-1));
			x++;
		}
		
		x = 0;
		for(int coordy : carMotorY) {
			g.setColor(Type.MOTOR.getColor());
			coordy = (int) (coordy * 0.55);
			g.drawLine((int) (x*0.27), 199-coordy, (int) ((x*0.27)+0.1), (int) ((199-coordy)-1));
			x++;
		}
		
		x = 0;
		for(int coordy : carInvalideY) {
			g.setColor(Type.INVALIDE.getColor());
			coordy = (int) (coordy * 0.55);
			g.drawLine((int) (x*0.27), 199-coordy, (int) ((x*0.27)+0.1), (int) ((199-coordy)-1));
			x++;
		}
		
	}
	
	public static void updateGraph() {
		carAdHocY.add(Parkeergarage.model.aantalCarAdHoc);
		carParkingPassY.add(Parkeergarage.model.aantalCarAbonnement);
		carElektrischY.add(Parkeergarage.model.aantalCarElektrisch);
		carInvalideY.add(Parkeergarage.model.aantalCarInvalide);
		carMotorY.add(Parkeergarage.model.aantalCarMotor);
	}
	
	public static void clearGraph() {
		if (Model.uur == 0 && Model.minuut == 0) {
		carAdHocY.clear();
		carParkingPassY.clear();
		carElektrischY.clear();
		carInvalideY.clear();
		carMotorY.clear();
		}
	
	}
	
	 
}
