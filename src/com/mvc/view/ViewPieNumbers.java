package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.main.Simulator;
import com.main.lib.ColorList;
import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewPieNumbers extends AbstractView {	
	private static JLabel aantalCarAdHoc 	 = new JLabel(""+Simulator.aantalCarAdHoc);
	private static JLabel aantalCarPass 	 = new JLabel(""+Simulator.aantalCarPass);
	private static JLabel aantalCarInvalide  = new JLabel(""+Simulator.aantalCarInvalide);
	private static JLabel aantalLegeVakken  = new JLabel(""+Simulator.aantalLegeVakken);
	
	public ViewPieNumbers(Model model) {
		super(model);
		this.setBackground(Color.WHITE);
		
		this.addNumberView(aantalLegeVakken, 50, 10, 250, 20, true);
		this.addNumberView(aantalCarAdHoc, 50, 40, 250, 20, true);
		this.addNumberView(aantalCarPass, 50, 70, 250, 20, true);
		this.addNumberView(aantalCarInvalide, 50, 100, 250, 20, true);
	}
	
	public static void updateNumbers() {
		aantalLegeVakken.setText("Lege Vakken                   "+Simulator.aantalLegeVakken);
		aantalCarAdHoc.setText("AdHoc Parkeerders      "+Simulator.aantalCarAdHoc);
		aantalCarPass.setText("Abonnementhouders    "+Simulator.aantalCarPass);
		aantalCarInvalide.setText("Invalide Parkeerders    "+Simulator.aantalCarInvalide);
	}
	
	public void addNumberView(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(aantalLegeVakken.getX()-15, aantalLegeVakken.getY()+6, 8, 8);
		
		g.setColor(ColorList.NORMAL_CAR);
		g.fillRect(aantalCarAdHoc.getX()-15, aantalCarAdHoc.getY()+6, 8, 8);
		
		g.setColor(ColorList.PARKING_PASS_CAR);
		g.fillRect(aantalCarPass.getX()-15, aantalCarPass.getY()+6, 8, 8);
		
		g.setColor(ColorList.INVALIDE_CAR);
		g.fillRect(aantalCarInvalide.getX()-15, aantalCarInvalide.getY()+6, 8, 8);
		
		g.setColor(Color.black);
		g.drawLine(0, 1, 229, 1);
		g.drawLine(0, 199, 229, 199);
		g.drawLine(229, 1, 229, 199);
	}
	
}
