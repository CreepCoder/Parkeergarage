package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewKlok extends AbstractView {

	private static JLabel dag = new JLabel("");
	private static JLabel uur = new JLabel(""+Model.uur);
	private static JLabel minuut = new JLabel(""+Model.minuut);
	private static JLabel dubbelePunt = new JLabel(":");

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
		
		updateTime();
	}

	public static void dagNaam(){
		int number= Model.dag;  
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
	
	public static void updateTime() {
		dag.setText(""+Model.dag);
		if (Model.uur < 10) {
			uur.setText("0"+Model.uur);
		}
		else {
			uur.setText(""+Model.uur);
		}
		
		if (Model.minuut < 10) {
			minuut.setText("0"+Model.minuut);
		}
		else {
			minuut.setText(""+Model.minuut);
		}
		dagNaam();
	}
	
	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-1);
	}

}

