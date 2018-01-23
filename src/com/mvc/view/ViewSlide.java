package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lib.CoreVariables;
import com.mvc.model.Model;

import javafx.scene.control.Slider;

public class ViewSlide extends AbstractView {

private int test;

public ViewSlide(Model model) {
	super(model);
    this.setLayout(null);
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, CoreVariables.simulatorSpeed);
    
    slider.setLocation(10, 10);
    slider.setMinorTickSpacing(2);
    slider.setMajorTickSpacing(10);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);
    slider.setVisible(true);
    slider.setSize(200,50);
    slider.setBackground(Color.WHITE);
    slider.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			CoreVariables.setSimulatorSpeed(source.getValue());
		}
	});
    
    // We'll just use the standard numeric labels for now...
    slider.setLabelTable(slider.createStandardLabels(5));
    
    this.add(slider);
  }

public void paintComponent(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(0, 0, 300, 100);
}
}           
         
    