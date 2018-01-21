//C CreepCoder
package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.mvc.model.Model;

public class ViewPie extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	
	private JLabel aantalCarAdHoc 	 = new JLabel(""+model.aantalCarAdHoc);
	private JLabel aantalCarParkingPass 	 = new JLabel(""+model.aantalCarParkingPass);
	private JLabel aantalLegeVakken  = new JLabel(""+model.aantalLegeVakken);

	public ViewPie(Model model) {
		super(model);
		this.setSize(400, 200);
		this.setLayout(null);
		
		this.addNumberView(aantalLegeVakken, 230, 10, 250, 20, true);
		this.addNumberView(aantalCarAdHoc, 230, 40, 250, 20, true);
		this.addNumberView(aantalCarParkingPass, 230, 70, 250, 20, true);
	}
	
	public void updateNumbers() {
		aantalLegeVakken.setText("Lege Vakken                   "+model.aantalLegeVakken);
		aantalCarAdHoc.setText("AdHoc Parkeerders      "+model.aantalCarAdHoc);
		aantalCarParkingPass.setText("Abonnementhouders    "+model.aantalCarParkingPass);
	}
	
	public void addNumberView(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 200);
		
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 200);
		g.drawLine(0, 199, 399, 199);
		g.drawLine(399, 0, 399, 199);
		
		g.setColor(Color.lightGray);
		g.fillArc(10, 10, 180, 180, 360-(aantalBerekening(model.aantalCarAdHoc)+aantalBerekening(model.aantalCarParkingPass)), 360);
		
		g.setColor(Color.RED);
		g.fillArc(10, 10, 180, 180, 0, (int) (aantalBerekening(model.aantalCarAdHoc)));
		
		g.setColor(Color.BLUE);
		g.fillArc(10, 10, 180, 180, (int) (aantalBerekening(model.aantalCarAdHoc)), (int) (aantalBerekening(model.aantalCarParkingPass)));
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(aantalLegeVakken.getX()-15, aantalLegeVakken.getY()+6, 8, 8);
		
		g.setColor(Color.red);
		g.fillRect(aantalCarAdHoc.getX()-15, aantalCarAdHoc.getY()+6, 8, 8);
		
		g.setColor(Color.blue);
		g.fillRect(aantalCarParkingPass.getX()-15, aantalCarParkingPass.getY()+6, 8, 8);
		
		updateNumbers();
	}
	
	private int aantalBerekening(int aantal) {
		if (aantal > 0 && aantal <= 1) {return 1;}
		else {return (int) (Math.floor(aantal/1.5));}
	}	
}
