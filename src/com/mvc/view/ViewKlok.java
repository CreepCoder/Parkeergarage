package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.car.CarAdHoc;
import com.car.CarParkingPass;
import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewKlok extends AbstractView {

	private String weekDag = new String ();
	private JLabel dag = new JLabel(weekDag);
	private JLabel uur = new JLabel(""+Model.hour);
	private JLabel minuut = new JLabel(""+Model.minute);
	
	public ViewKlok(Model model) {
		super(model);
		this.setSize(200, 100);
		this.setLayout(null);
		
		dag.setSize(60, 20);
		dag.setLocation(10, 10);
		dag.setVisible(true);
		this.add(dag);
		
		uur.setSize(30,20);
		uur.setLocation(10,30);
		uur.setVisible(true);
		this.add(uur);
		
		minuut.setSize(30,20);
		minuut.setLocation(40,30);
		minuut.setVisible(true);
		this.add(minuut);		
		
	}

	public void dagNaam(){
		int weekDay = Model.day;
		weekDag = "default";
		if (weekDay == 0) {
		    weekDag = "Maandag";
		} else if (weekDay == 1) {
		    weekDag = ("Dinsdag");
		} else if (weekDay == 2) {
		    weekDag = ("Woensdag");
		} else if (weekDay == 3) {
		    weekDag = ("Donderdag");
		} else if (weekDay == 4) {
		    weekDag = ("Vrijdag");
		} else if (weekDay == 5) {
		    weekDag = ("Zaterdag");
		} else if (weekDay == 6) {
		    weekDag = ("Zondag");
		}
	        
	}
	
	public void updateNumbers() {
		dag.setText(weekDag);
		uur.setText(""+Model.hour);
		minuut.setText(":"+Model.minute);
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 100);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawLine(0, 0, 99, 0);
		g.drawLine(0, 0, 0, 59);
		g.drawLine(0, 59, 99, 59);
		g.drawLine(99, 0, 99, 59);
		
		
		updateNumbers();
	}
	
	
}

