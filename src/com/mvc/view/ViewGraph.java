package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import com.lib.ColorList;
import com.mvc.model.Model;


public class ViewGraph extends AbstractView {
	
	/**
	 * Deze klasse weergeeft een lijngrafiek
	 */
	private static final long serialVersionUID = 1L;
	//public ArrayList lines;
	//public ArrayList values = new ArrayList<lines>();
	
	public ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> lines2 = new ArrayList<ArrayList<Integer>>();
	//public ArrayList<Integer> linesList = new ArrayList<Integer>();
	public ArrayList<Integer> linesList;
	public ArrayList<Integer> linesList2;
	
	public int x1 = 0;
	public int y1 = 0;
	public int x2 = 0;
	public int y2 = 0;
	
	public int x3 = 0;
	public int y3 = 0;
	public int x4 = 0;
	public int y4 = 0;
	
	private JLabel label00 = new JLabel("0");
	private JLabel label11 = new JLabel("3");
	private JLabel label22 = new JLabel("6");
	private JLabel label33 = new JLabel("9");
	private JLabel label44 = new JLabel("12");
	private JLabel label55 = new JLabel("15");
	private JLabel label66 = new JLabel("18");
	private JLabel label77 = new JLabel("21");
	private JLabel label88 = new JLabel("24");
	private JLabel label99 = new JLabel(">  Dag in uren ");
	
	public ViewGraph(Model model) {
		super(model);
		this.setSize(400, 230);
		this.setLayout(null);
		
		this.asLabels(label00, 0, 205, 15, 10, true);
		this.asLabels(label11, 47, 205, 15, 10, true);
		this.asLabels(label22, 97, 205, 15, 10, true);
		this.asLabels(label33, 147, 205, 15, 10, true);
		this.asLabels(label44, 197, 205, 15, 10, true);
		this.asLabels(label55, 247, 205, 15, 10, true);
		this.asLabels(label66, 297, 205, 15, 10, true);
		this.asLabels(label77, 347, 205, 15, 10, true);
		this.asLabels(label88, 387, 205, 15, 10, true);
		this.asLabels(label99, 303, 216, 100, 15, true);
		
	}
	
	public void asLabels(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
	}

	

	
	public void paintComponent(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 230);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 200);
		g.drawLine(0, 199, 399, 199);
		g.drawLine(399, 0, 399, 199);
		
		g.drawLine(70, 223, 303, 223);
		
		g.setColor(Color.lightGray);
		g.drawLine(0, 100, 399, 100);
		g.drawLine(0, 50, 399, 50);
		g.drawLine(0, 150, 399, 150);
		g.drawLine(50, 199, 50, 0);
		g.drawLine(100, 199, 100, 0);
		g.drawLine(150, 199, 150, 0);
		g.drawLine(200, 199, 200, 0);
		g.drawLine(250, 199, 250, 0);
		g.drawLine(300, 199, 300, 0);
		g.drawLine(350, 199, 350, 0);
		
		
		double xas = (Model.minute + 60 * Model.hour) / 3.6*1;
		int x2 = (int) xas;
		
		// creeër lijn voor totaal aantal ... autos
		x1 = x2;
		y1 = y2;
		// aantal minuten in een dag = 1440 minuten / x-as lengte = 400 -->
		y2 = 199 - model.aantalCarAdHoc;
	
		int x4 = (int) xas;
		
		// creeër lijn voor totaal aantal ... abonnees
				x3 = x4;
				y3 = y4;
				// aantal minuten in een dag = 1440 minuten / x-as lengte = 400 -->
				y4 = 199 - model.aantalCarParkingPass;
		
		ArrayList<Integer> linesList = new ArrayList<Integer>();
		ArrayList<Integer> linesList2 = new ArrayList<Integer>();
		
		linesList.add(x1);
		linesList.add(y1);
		linesList.add(x2);
		linesList.add(y2);
		lines.add(linesList);
		
		linesList2.add(x3);
		linesList2.add(y3);
		linesList2.add(x4);
		linesList2.add(y4);
		lines2.add(linesList2);
		
		for (ArrayList<Integer> i : lines) {
			if (Model.hour == 0 && Model.minute == 0) {
				lines = new ArrayList<ArrayList<Integer>>();
			}
			CreateLine(g, ColorList.CAR_AD_HOC, i.get(0), i.get(1), i.get(2), i.get(3));
		}
		
		for (ArrayList<Integer> i : lines2) {
			if (Model.hour == 0 && Model.minute == 0) {
				lines2 = new ArrayList<ArrayList<Integer>>();
			}
			CreateLine(g, ColorList.CAR_PARKING_PASS, i.get(0), i.get(1), i.get(2), i.get(3));
		}
		
	}
	
	public void CreateLine(Graphics g, Color color, int x1, int y1, int x2, int y2) {
		// teken lijn
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
		
		
	}
	
}
