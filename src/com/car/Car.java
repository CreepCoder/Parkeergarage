package com.car;

import java.awt.Color;

import com.location.Location;
import com.location.LocationMap;
import com.location.LocationType;

public class Car {

    private Location location;
    private int minutesLeft;
    private boolean isPaying;
    private boolean hasToPay;
    private LocationType type;
	private LocationMap locationmap;

    /**
     * Constructor for objects of class Car
     */
    public Car(LocationType type) {
    	this.setType(type);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMinutesLeft() {
        return minutesLeft;
    }

    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    
    public boolean getIsPaying() {
        return isPaying;
    }

    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    public boolean getHasToPay() {
        return hasToPay;
    }

    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }

    public void tick() {
        minutesLeft--;
    }
    
    public Color getColor() {
		return type.getColor();
    }

	public LocationType getType() {
		return type;
	}

	public void setType(LocationType type) {
		this.type = type;
	}

	public LocationMap getLocationmap() {
		return locationmap;
	}

	public void setLocationmap(LocationMap locationmap) {
		this.locationmap = locationmap;
	}
}