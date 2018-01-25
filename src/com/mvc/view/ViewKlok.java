package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewKlok extends AbstractView {

	private JLabel dag = new JLabel("");
	private JLabel uur = new JLabel(""+Model.hour);
	private JLabel minuut = new JLabel(""+Model.minute);
	private JLabel dubbelePunt = new JLabel(":");

	public ViewKlok(Model model) {
		super(model);
		this.setSize(100, 60);
		this.setLayout(null);
		
		dag.setSize(90, 20);
		dag.setLocation(5, 10);
		dag.setHorizontalAlignment(SwingConstants.CENTER);
		dag.setVisible(true);
		this.add(dag);
		
		uur.setSize(30,20);
		uur.setLocation(32,30);
		uur.setVisible(true);
		this.add(uur);
		
		minuut.setSize(30,20);
		minuut.setLocation(55,30);
		minuut.setVisible(true);
		this.add(minuut);	
		
		dubbelePunt.setSize(30, 20);
		dubbelePunt.setLocation(35, 30);
		dubbelePunt.setHorizontalAlignment(SwingConstants.CENTER);
		dubbelePunt.setVisible(true);
		this.add(dubbelePunt);
	}

	public void dagNaam(){
		int number= Model.day;  
		switch(number){  
	case 0:
		dag.setText("Maandag");
		break;
	case 1:
		dag.setText("Dinsdag");
		break;
	case 2:
		dag.setText("Woensdag");
		break;
	case 3:
		dag.setText("Donderdag");
		break;
	case 4:
		dag.setText("Vrijdag");
		break;
	case 5:
		dag.setText("Zaterdag");
		break;
	case 6:
		dag.setText("Zondag");
		break;
		}
	 }
	
	public void updateNumbers() {
		dag.setText(""+Model.day);
		if (Model.hour < 10) {
			uur.setText("0"+Model.hour);
		}
		else {
			uur.setText(""+Model.hour);
		}
		
		if (Model.minute < 10) {
			minuut.setText("0"+Model.minute);
		}
		else {
			minuut.setText(""+Model.minute);
		}
		dagNaam();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 100);
		
		// Creëer belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 99, 59);

		updateNumbers();
	}

}

