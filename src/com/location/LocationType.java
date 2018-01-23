package com.location;

import java.awt.Color;

import com.lib.ColorList;

public class LocationType {
	private String name;
	private int id;
	private Color color;

	LocationType(String name, int id, Color color) {
		this.setName(name);
		this.setId(id);
		this.setColor(color);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static LocationType AD_HOC = new LocationType("AdHoc", 1, ColorList.CAR_AD_HOC);
	public static LocationType PARKING_PASS = new LocationType("Parking Pass", 2, ColorList.CAR_PARKING_PASS);
	public static LocationType ELEKTRISCH = new LocationType("Elektrisch", 3, ColorList.ELEKTRISCHE_CAR);
	public static LocationType INVALIDE = new LocationType("Invalide", 4, ColorList.INVALIDE_CAR);
	public static LocationType MOTOR = new LocationType("Motor", 5, ColorList.MOTOR);
}
