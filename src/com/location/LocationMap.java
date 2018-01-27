package com.location;

import java.awt.Color;
import java.awt.Graphics;

import com.car.Car;
import com.mechanic.Type;

public class LocationMap {
	private int x;
	private int y;
	private Type type;
	private Car car;
	
	public LocationMap(int x, int y, Type type, Car car) {
		this.x = x;
		this.y = y;
		this.setCar(car);
		this.setType(type);
	}
	
	public void drawLocation(Graphics g, Color color, int x, int y) {
        g.setColor(color);
		g.fillRect(x, y, 18, 8);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}

