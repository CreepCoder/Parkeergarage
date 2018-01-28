package com.mechanic;

import java.awt.Color;

import com.lib.ColorList;

public class Type {
	private int id;
	private Color color;

	Type(int id, Color color) {
		this.setId(id);
		this.setColor(color);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public static Type ADHOC 		= new Type(1, ColorList.CAR_AD_HOC);
	public static Type ABONNEMENT 	= new Type(2, ColorList.CAR_PARKING_PASS);
	public static Type ELEKTRISCH 	= new Type(3, ColorList.ELEKTRISCHE_CAR);
	public static Type INVALIDE 	= new Type(4, ColorList.INVALIDE_CAR);
	public static Type MOTOR 		= new Type(5, ColorList.MOTOR);
	public static Type DUBBELE_PARKEERDER 		= new Type(6, ColorList.DUBBELE_PARKEERDER);
}
