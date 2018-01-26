package com.main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

import com.lib.CoreVariables;
import com.location.LocationView;
import com.location.Map;
import com.mvc.controller.Controller;
import com.mvc.model.Model;
import com.mvc.view.AbstractView;
import com.mvc.view.ViewCarPark;
import com.mvc.view.ViewGraph;
import com.mvc.view.ViewHistogram;
import com.mvc.view.ViewKlok;
import com.mvc.view.ViewMoney;
import com.mvc.view.ViewPie;
import com.mvc.view.ViewSlide;

public class Parkeergarage {
	
	/*
	 * Hier wordt het hele programma gemaakt.
	 * Het model wordt aangemaakt en daar worden alle views aan toegevoegd.
	 * Ook alle informatie van het venster staat hier.
	 * Deze klasse dient verder gebruikt te worden om nieuwe elementen en functies toe te voegen.
	 * Let op dat de volgorde van het aanmaken van alles in de constructor erg belangrijk is.
	 * Zo kan er geen attribuut worden aangepast van een object als deze nog niet bestaat.
	 * Dit doen we dus eerst bovenaan.
	 * Een controller kan niet aangemaakt worden zonder model, dus die moet sowieso NA het aanmaken van het model
	 * etc. etc. etc.
	 * Zo voorkom je NullPointerExceptions.
	 */
	
	public static Model model;
	public static JFrame scherm;
	public static AbstractView viewpie;
	public static AbstractView viewKlok;
	public static AbstractView viewSlide;
	public static AbstractView viewGraph;
	public static ViewHistogram viewhistogram;
	public static ViewMoney viewMoney;
	public static ViewCarPark viewcarpark;
	private Controller controller;
	public static Map map;
	
	public Parkeergarage() {
		// Maak alle objecten aan
		model = new Model();
		viewcarpark = new ViewCarPark(model, 3, 6, 30);
		viewpie = new ViewPie(model);
		viewKlok = new ViewKlok(model);
		viewSlide = new ViewSlide(model);
		viewGraph = new ViewGraph(model);
		controller = new Controller(model);
		viewhistogram = new ViewHistogram(model);
		viewMoney = new ViewMoney(model);
		map = new Map(model);
		
		
		// Informatie over het scherm
		scherm = new JFrame(CoreVariables.SIMULATOR_NAAM);
		scherm.setSize(CoreVariables.schermBreedte, CoreVariables.schermHoogte);
		scherm.setResizable(false);
		scherm.setLocationRelativeTo(null);
		scherm.setLayout(null);	
		scherm.setBackground(Color.white);
		scherm.getContentPane().setBackground(Color.white);
		new Menubar(scherm);
		
		// Voeg alle elementen toe
		voegElementToe(scherm, viewcarpark, 0, 0, 850, 400);		
		voegElementToe(scherm, controller, 830, 80, 170, 50);
		voegElementToe(scherm, viewKlok, 830, 10, 100, 60);
		voegElementToe(scherm, viewSlide, 950, 8, 250, 70);
		voegElementToe(scherm, viewMoney, 830, 140, 300, 460);
		voegElementToe(scherm, map, 10, 10, 810, 380);
		
		// Zorgt ervoor dat de grafiek altijd wordt ge�pdate

		
		// Zet de normale CarParkView uit, deze moet wel blijven, omdat het achterliggende systeem nog gebruikt wordt
		viewcarpark.setVisible(false);
		
		// Overige scherm informatie
		scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scherm.setVisible(true);
		
		updateView();
	}
	
	// Update de ViewCarPark met de nieuwe informatie van het scherm
    public static void updateView() {
    	viewcarpark.updateView();
    }
    
    // Deze methodes heb ik gemaakt zodat er gemakkelijk elementen toegevoegd kunnen worden aan het scherm. Ook scheelt het lijnen code om het overzicht te behouden
    public static void voegElementToe(JFrame frame, Component element, int x, int y, int width, int height) {
    	frame.getContentPane().add(element);
    	element.setBounds(x, y, width, height);
    }
    
    public static void voegViewToe(JFrame frame, Component element, LocationView view) {
    	if (view.isOccupied() == false) {
    		frame.getContentPane().add(element);
    		element.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
    		view.setOccupied(true);
    		frame.repaint();
    	}
    }
    
    // Haalt een element van het scherm
    public static void haalElementWeg(JFrame frame, Component element) {
    	if (element.getX() == LocationView.links.getX()) {
    		LocationView.links.setOccupied(false);
    		frame.getContentPane().remove(element);
    		frame.repaint();
    	}
    	else if (element.getX() == LocationView.rechts.getX()) {
    		LocationView.rechts.setOccupied(false);
    		frame.getContentPane().remove(element);
    		frame.repaint();
    	}
    	frame.getContentPane().remove(element);
    }
	
	public static void main(String[] args) {
		new Parkeergarage();
	}
}
