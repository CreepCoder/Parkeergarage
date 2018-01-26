package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.location.LocationType;
import com.mvc.model.Model;


public class ViewGraph extends AbstractView {
	
	/**
	 * Deze klasse geeft een lijngrafiek weer
	 */
	private static final long serialVersionUID = 1L;
	//public ArrayList lines;
	//public ArrayList values = new ArrayList<lines>();
	
	public ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> lines2 = new ArrayList<ArrayList<Integer>>();

	//public ArrayList<Integer> linesList = new ArrayList<Integer>();
	public ArrayList<Integer> linesList;
	public ArrayList<Integer> linesList2;
	public ArrayList<Integer> i;
	
	// Voor CarAdHoc
	public int x1 = 0;
	public int y1 = 0;
	public int x2 = 0;
	public int y2 = 0;
	
	// Voor CarParkingPass
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

	private static ArrayList<Integer> carAdHocY = new ArrayList<Integer>();
	
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
		
		// Voor de pijl
		g.drawLine(70, 223, 303, 223);
		
		// Voor de grid
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
		
		int x = 0;
		for(int coordy : carAdHocY) {
			CreateLine(g, LocationType.AD_HOC.getColor(), (int) (x*0.27), 199-coordy, (int) ((x*0.27)+0.1), (int) ((199-coordy)-1));
			x++;
		}
	}
	
	public void CreateLine(Graphics g, Color color, int x1, int y1, int x2, int y2) {
		// teken lijn
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
			
	}
	
	public static void updateGraph(int y) {
		carAdHocY.add(y);
	}
	
}
