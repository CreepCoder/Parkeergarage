package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

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
		
		
		// 
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
		
		// creeër lijn voor totaal aantal adhoc autos
		//System.out.println(model.aantalCarAdHoc);
		
		//model.hour == 0 && model.minute == 0
		if (model.hour == 0 && model.minute == 0) {
			x1 = 0;
			y1 = 199;
			x2 = 0;
			y2 = 199;
		}
		else {
			x1 = x2;
			y1 = y2;
			x2 = model.minute * 6;
			y2 = 199 - model.aantalCarAdHoc;
		}

		
		/*
		if (model.hour == 0) {
			x1 = x2;
			y1 = y2;
			x2 = model.minute * 6;
			y2 = 199 - model.aantalCarAdHoc;
		}
		else {
			x2 = model.minute * 6;
			y2 = 199 - model.aantalCarAdHoc;
			x1 = 0;
			y1 = 199;
		}
		*/
		
		
		//ArrayList lines = new ArrayList<>();
		
		//ArrayList values = new ArrayList<ArrayList<lines>>();
		//lines.add(x1);
		
		ArrayList<Integer> linesList = new ArrayList<Integer>();
		
		if (model.minute >= 0) {
			linesList.add(x1);
			linesList.add(y1);
			linesList.add(x2);
			linesList.add(y2);
			lines.add(linesList);
		}
		
		
//		linesList.add(x1);
//		linesList.add(y1);
//		linesList.add(x2);
//		linesList.add(y2);
//		lines.add(linesList);

		
		//System.out.println(lines);
		//linesList.clear();
		
		for (ArrayList<Integer> i : lines) {
			if (model.hour == 0 && model.minute == 0) {
				//lines.clear();
				lines = new ArrayList<ArrayList<Integer>>();
			}
			
			CreateLine(g, Color.red, i.get(0), i.get(1), i.get(2), i.get(3));
			
			//for (int value : i) {
			//	CreateLine(g, Color.red, value[0], y1, x2, y2);
			//}
		}
		
		//CreateLine(g, Color.red, x1, y1, x2, y2);

		
//		values.add(x1);
//		values.add(y1);
//		values.add(x2);
//		values.add(y2);
		
		/*
		if (model.hour == 0) {
			CreateLine(g, Color.red,
					0, (199 - model.aantalCarAdHoc),
					model.hour * 10 , (100 - model.aantalCarAdHoc));
			lines.add("Hi");
		}
		else {
			lines.add("hallo");
		}
		CreateLine(g, Color.red,
				model.hour * 10 , (199 - model.aantalCarAdHoc),
				(model.hour++) * 10, (100 - model.aantalCarAdHoc));
		*/
	}
	
	public void CreateLine(Graphics g, Color color, int x1, int y1, int x2, int y2) {
		// teken lijn
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
		
		
	}
	
}
