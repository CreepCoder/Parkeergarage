package com.mvc.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.mvc.model.Model;

public class Controller extends AbstractController implements ActionListener {
	private static final long serialVersionUID = -7413164724294460746L;
	private JButton start;
	private JButton stop;
	
	public Controller(Model model) {
		super(model);
		this.setLayout(null);
		this.setSize(169, 50);
		
		start=new JButton("Start");
		start.addActionListener(this);
		stop=new JButton("Stop");
		stop.addActionListener(this);
		
		this.add(start);
		this.add(stop);
		
		start.setBounds(40, 15, 70, 30);
		stop.setBounds(130, 15, 70, 30);
		
		start.setToolTipText("Start de Simulatie");
		stop.setToolTipText("Stop de Simulatie");

		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-1);
	}

	public void actionPerformed(ActionEvent e) {		
		if (e.getSource()==start) {
			model.start();
		}
		
		if (e.getSource()==stop) {
			model.stop();
		}
	}
}
