package com.main.view;

import java.awt.Color;
import java.awt.Graphics;

import com.main.Simulator;
import com.mvc.Model;
import com.mvc.View;

@SuppressWarnings("serial")
public class ViewPie extends View {

	
	public ViewPie(Model model) {
		super(model);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		
		g.setColor(Color.lightGray);
		g.fillArc(10, 10, 180, 180, 360-(aantalBerekening(Simulator.aantalCarAdHoc)+aantalBerekening(Simulator.aantalCarPass)+aantalBerekening(Simulator.aantalCarInvalide)), 360);
		
		g.setColor(Color.RED);
		g.fillArc(10, 10, 180, 180, 0, (int) (Simulator.aantalCarAdHoc/1.5));
		
		g.setColor(Color.GREEN);
		g.fillArc(10, 10, 180, 180, (int) (Simulator.aantalCarAdHoc/1.5), (int) (Simulator.aantalCarPass/1.5));
		
		g.setColor(Color.BLUE);
		g.fillArc(10, 10, 180, 180, (int) (Math.floor((aantalBerekening(Simulator.aantalCarAdHoc)+aantalBerekening(Simulator.aantalCarPass)))), 
				aantalBerekening(Simulator.aantalCarInvalide));
	}
	
	private int aantalBerekening(int aantal) {
		if (aantal > 0 && aantal <= 1) {return 1;}
		else {return (int) (Math.floor(aantal/1.5));}
	}
}