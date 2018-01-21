package com.main;

import java.awt.Color;

import javax.swing.JFrame;

import com.mvc.controller.Controller;
import com.mvc.model.Model;
import com.mvc.view.AbstractView;
import com.mvc.view.ViewCarPark;
import com.mvc.view.ViewPie;

public class Parkeergarage {
	private Model model;
	private JFrame screen;
	//private AbstractView countview;
	private AbstractView pieview;
	private Controller controller;
	public static ViewCarPark viewCarPark;
	
	public Parkeergarage() {
		model=new Model();
		controller=new Controller(model);
		//countview=new ViewCount(model);
		pieview=new ViewPie(model);
		viewCarPark = new ViewCarPark(model, 3, 6, 30);
		
		screen=new JFrame("Parkeergarage Simulator Project C");
		screen.setSize(1200, 800);
		screen.setResizable(false);
		screen.setLocationRelativeTo(null);
		screen.setLayout(null);	
		screen.setBackground(Color.white);
		
		screen.getContentPane().setBackground(Color.white);
		
		//screen.getContentPane().add(countview);
		screen.getContentPane().add(pieview);
		screen.getContentPane().add(controller);
		screen.getContentPane().add(viewCarPark);	
		
		//countview.setBounds(500, 500, 200, 200);
		pieview.setBounds(30, 500, 400, 200);
		controller.setBounds(10, 710, 450, 50);
		viewCarPark.setBounds(0, 0, 1000, 450);
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		
		updateView();
	}
	
    public static void updateView() {
    	viewCarPark.updateView();
    	
    }
	
	public static void main(String[] args) {
		new Parkeergarage();
	}
}
