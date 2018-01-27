package com.mvc.view;

/*
 * Deze klasse zorgt ervoor dat de slider wordt toegevoegd aan de simulatie
 * 
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lib.CoreVariables;
import com.lib.Methods;
import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewSpeed extends AbstractView {
	private JLabel titel = new JLabel("Snelheid van de simulatie");
	private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
	
	public ViewSpeed(Model model) {
		super(model);
		this.setLayout(null);
		Methods.voegLabelToe(titel, 75, 1, 200, 15, true, this, SwingConstants.CENTER);

		slider.setLocation(75, 20);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSize(200,45);
		slider.setBackground(Color.white);
		slider.setVisible(true);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				CoreVariables.setSimulatorSpeed(source.getValue());
			}
		});
		slider.setLabelTable(slider.createStandardLabels(5));
		this.add(slider);
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
         
    