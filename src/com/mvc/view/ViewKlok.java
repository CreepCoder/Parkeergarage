package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewKlok extends AbstractView {

	private static JLabel dag = new JLabel("");
	private JLabel uur = new JLabel(""+Model.hour);
	private JLabel minuut = new JLabel(""+Model.minute);
	
	
	public ViewKlok(Model model) {
		super(model);
		this.setSize(200, 100);
		this.setLayout(null);
		
		dag.setSize(90, 20);
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

	public static void dagNaam(){
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
		uur.setText(""+Model.hour);
		minuut.setText(":"+Model.minute);
		ViewKlok.dagNaam();
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

