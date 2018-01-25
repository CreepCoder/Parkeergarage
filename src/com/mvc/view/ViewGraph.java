package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

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
	
	
	public ViewGraph(Model model) {
		super(model);
		
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
		
		// creeër lijn voor totaal aantal ... autos
		x1 = x2;
		y1 = y2;
		// aantal minuten in een dag = 1440 minuten / x-as lengte = 400 -->
		x2 = (Model.minute + 60 * Model.hour) / 4*1;
		y2 = 199 - model.aantalCarAdHoc;
		
		// creeër lijn voor totaal aantal ... abonnees
				x3 = x4;
				y3 = y4;
				// aantal minuten in een dag = 1440 minuten / x-as lengte = 400 -->
				x4 = (Model.minute + 60 * Model.hour) / 4*1;
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
