package com.location;

import com.mvc.view.AbstractView;

public class LocationView {
	private boolean occupied;
	private int x;
	private int y;
	private int width;
	private int height;
	private AbstractView view;
	
	LocationView(int x, int y, int width, int height, AbstractView view, boolean occupied) {
		this.setOccupied(occupied);
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.setView(view);
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AbstractView getView() {
		return view;
	}

	public void setView(AbstractView view) {
		this.view = view;
	}

	public static final LocationView links = new LocationView(10, 400, 400, 200, null, false);
	public static final LocationView rechts = new LocationView(420, 400, 400, 200, null, false);
}
