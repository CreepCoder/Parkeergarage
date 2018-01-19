package com.main.view;

import java.awt.*;

import com.mvc.Model;
import com.mvc.View;

@SuppressWarnings("serial")
public class ViewPie extends View {

	public ViewPie(Model model) {
		super(model);
	}

	public void paintComponent(Graphics g) {
		int aantal=getModel().getAantal();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.RED);
	
		g.fillArc(10, 10, 180, 180, 0, aantal);
	}	
}