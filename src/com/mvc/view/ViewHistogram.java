package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.lib.ColorList;
import com.mvc.model.Model;

public class ViewHistogram extends AbstractView {
	private static final long serialVersionUID = 5455934187803194147L;
	private JLabel label0 = new JLabel(""+ model.aantalLegeVakken);
	private JLabel label1 = new JLabel(""+ model.aantalCarAdHoc);
	private JLabel label2 = new JLabel(""+ model.aantalCarParkingPass);
	private JLabel label3 = new JLabel(""+ model.aantalCarElektrisch);
	private JLabel label4 = new JLabel(""+ model.aantalCarInvalide);
	private JLabel label5 = new JLabel(""+ model.aantalCarMotor);
	
	
	public ViewHistogram(Model model) {
		super(model);
		this.setSize(400, 230);
		this.setLayout(null);
		label(label0, 23, model.aantalLegeVakken, 30, 10, true);
		label(label1, 99, model.aantalLegeVakken, 30, 10, true);
		label(label2, 23, model.aantalLegeVakken, 30, 10, true);
		label(label3, 23, model.aantalLegeVakken, 30, 10, true);
		label(label4, 23, model.aantalLegeVakken, 30, 10, true);
		label(label5, 23, model.aantalLegeVakken, 30, 10, true);
		
	}
	

	// Methode om gemakkelijk een legenda toe te voegen (tekst)
	

	public void paintComponent(Graphics g) {
		// Cre�er achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 229);
		
		// Cre�er belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 399, 0);
		g.drawLine(0, 0, 0, 230);
		g.drawLine(0, 229, 399, 229);
		g.drawLine(399, 0, 399, 229);
   
		
		g.setColor(Color.lightGray);
		g.drawLine(0, 46, 399, 46);
		g.drawLine(0, 92, 399, 92);
		g.drawLine(0, 138, 399, 138);
		g.drawLine(0, 184, 399, 184);
		g.drawLine(66, 229, 66, 0);
		g.drawLine(133, 229, 133, 0);
		g.drawLine(199, 229, 199, 0);
		g.drawLine(265, 229, 265, 0);
		g.drawLine(331, 229, 331, 0);

	
		int aantaladhoc= 228-model.aantalCarAdHoc/2;

		int aantallege = 228-model.aantalLegeVakken/2;
		
		if (aantallege < 2) {
			aantallege = 1;
		}
		
		if (aantaladhoc < 2) {
			aantaladhoc = 1;
		}

		createBar(g, ColorList.LEGE_VAKKEN, 10 , aantallege, 46 , 229);
		createBar(g, ColorList.CAR_AD_HOC, 76, aantaladhoc, 46, 229);
		createBar(g, ColorList.CAR_PARKING_PASS, 142, 228-model.aantalCarParkingPass/2 , 46, 229);
		createBar(g, ColorList.ELEKTRISCHE_CAR, 208,  228-model.aantalCarElektrisch/2, 46,229);
		createBar(g, ColorList.INVALIDE_CAR, 274,  228-model.aantalCarInvalide/2, 46, 229);
		createBar(g, ColorList.MOTOR, 340, 228-model.aantalCarMotor/2, 46, 229);
		label0.setText(""+ model.aantalLegeVakken);
		label1.setText(""+ model.aantalCarAdHoc);
		label2.setText(""+ model.aantalCarParkingPass);
		label3.setText(""+ model.aantalCarElektrisch);
		label4.setText(""+ model.aantalCarElektrisch);
		label5.setText(""+ model.aantalCarMotor);
		labels();
	}
	
	private void createBar(Graphics g, Color color, int x, int y, int width, int height) {
		g.setColor(color);
		g.fill3DRect(x, y, width, height, true);
		 	}
	
	private void labels() {
		int aantallege = 218-model.aantalLegeVakken/2;
		if (aantallege < -1) {
			label0.setLocation(23, 208-model.aantalCarAdHoc/2);
		}else {
		label0.setLocation(23, aantallege);
		}
		label1.setLocation(99, 218-model.aantalCarAdHoc/2);
		label2.setLocation(165, 218-model.aantalCarParkingPass/2);
		label3.setLocation(231, 218-model.aantalCarElektrisch/2);
		label4.setLocation(297, 218-model.aantalCarInvalide/2);
		label5.setLocation(363, 218-model.aantalCarMotor/2);
	}

	public void label(JLabel label, int x, int y, int width, int height, boolean visible) {
		label.setLocation(x, y);
		label.setSize(width, height);
		label.setVisible(true);
		this.add(label);
	}

	
}
