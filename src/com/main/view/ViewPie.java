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
		
		g.setColor(Color.RED);
		g.fillArc(10, 10, 180, 180, 0, (int) (Simulator.aantalCarAdHoc*0.6666666667));
		
		g.setColor(Color.GREEN);
		g.fillArc(10, 10, 180, 180, (int) (Simulator.aantalCarAdHoc*0.6666666667), (int) (Simulator.aantalCarPass*0.6666666667));
		
		if (Simulator.aantalCarInvalide*0.6666666667 < 1 && Simulator.aantalCarInvalide*0.6666666667 > 0.5) {Simulator.aantalCarInvalide++;}
		//else if (Simulator.aantalCarInvalide < 0.5) {Simulator.aantalCarInvalide--;}
		
		g.setColor(Color.BLUE);
		g.fillArc(10, 10, 180, 180, (int) ((Simulator.aantalCarPass*0.6666666667)+(Simulator.aantalCarAdHoc*0.6666666667)), 
				(int) (Simulator.aantalCarInvalide*0.6666666667));
	}
}