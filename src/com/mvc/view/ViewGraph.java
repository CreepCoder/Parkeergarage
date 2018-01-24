package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import com.mvc.model.Model;

public class ViewGraph extends AbstractView {
	
	/**
	 * Deze klasse weergeeft een lijngrafiek
	 */
	private static final long serialVersionUID = 1L;
	//public ArrayList lines;
	//public ArrayList values = new ArrayList<lines>();
	
	public ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
	//public ArrayList<Integer> linesList = new ArrayList<Integer>();
	public ArrayList<Integer> linesList;
	
	public int x1 = 0;
	public int y1 = 0;
	public int x2 = 0;
	public int y2 = 0;
	
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
		
		ArrayList<Integer> linesList = new ArrayList<Integer>();
		
		linesList.add(x1);
		linesList.add(y1);
		linesList.add(x2);
		linesList.add(y2);
		lines.add(linesList);
		
		for (ArrayList<Integer> i : lines) {
			if (Model.hour == 0 && Model.minute == 0) {
				lines = new ArrayList<ArrayList<Integer>>();
			}
			CreateLine(g, Color.red, i.get(0), i.get(1), i.get(2), i.get(3));
		}
		
	}
	
	public void CreateLine(Graphics g, Color color, int x1, int y1, int x2, int y2) {
		// teken lijn
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
		
	}
	
}
