package com.main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;

import com.lib.CoreVariables;
import com.mvc.controller.Controller;
import com.mvc.model.Model;
import com.mvc.view.AbstractView;
import com.mvc.view.ViewCarPark;
import com.mvc.view.ViewKlok;
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
	
	private Model model;
	private JFrame scherm;
	public static AbstractView viewpie;
	public static AbstractView viewKlok;
	private AbstractView viewSlide;
	private Controller controller;
	public static ViewCarPark viewcarpark;
	private Menubar menubar;
	
	public Parkeergarage() {
		// Maak alle objecten aan
		model=new Model();
		viewcarpark = new ViewCarPark(model, 3, 6, 30);
		viewpie=new ViewPie(model);
		controller=new Controller(model);
		viewKlok=new ViewKlok(model);
		viewSlide= new ViewSlide(model);
		
		// Informatie over het scherm
		scherm=new JFrame(CoreVariables.SIMULATOR_NAAM);
		scherm.setSize(CoreVariables.schermBreedte, CoreVariables.schermHoogte);
		scherm.setResizable(false);
		scherm.setLocationRelativeTo(null);
		scherm.setLayout(null);	
		scherm.setBackground(Color.white);
		scherm.getContentPane().setBackground(Color.white);
		menubar=new Menubar(scherm);
		
		// Voeg alle elementen toe
		voegElementToe(scherm, viewcarpark, 0, 0, 850, 400);
		voegElementToe(scherm, viewpie, 30, 400, 400, 200);
		voegElementToe(scherm, controller, 10, 600, 450, 50);
		voegElementToe(scherm, viewKlok, 900, 30, 200, 100);
		voegElementToe(scherm, viewSlide, 450, 590, 220 ,80);
		
		// Overige scherm informatie
		scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scherm.setVisible(true);
		
		updateView();
	}
	
	// Update alle views met de nieuwe informatie van het scherm
    public static void updateView() {
    	viewcarpark.updateView();
    }
    
    // Deze methode heb ik gemaakt zodat er gemakkelijk elementen toegevoegd kunnen worden aan het scherm. Ook scheelt het lijnen code om het overzicht te behouden
    public void voegElementToe(JFrame frame, Component element, int x, int y, int width, int height) {
    	frame.getContentPane().add(element);
    	element.setBounds(x, y, width, height);
    }
	
	public static void main(String[] args) {
		new Parkeergarage();
	}
}
