package com.car;

public class CarType {
	private String name;
	private int id;

	CarType(String name, int id) {
		this.setName(name);
		this.setId(id);
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
	
	public static CarType AD_HOC = new CarType("AdHoc", 1);
	public static CarType PARKING_PASS = new CarType("Parking Pass", 2);
	public static CarType ELEKTRISCH = new CarType("Elektrisch", 3);
	public static CarType INVALIDE = new CarType("Invalide", 4);
	public static CarType MOTOR = new CarType("Motor", 5);
	}
