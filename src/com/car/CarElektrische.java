package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.location.LocationType;

public class CarElektrische extends Car {
    public CarElektrische(LocationType type) {
    	super(type);
    	this.setType(LocationType.ELEKTRISCH);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    // Return the given color
    public Color getColor(){
    	return ColorList.ELEKTRISCHE_CAR;
    }
}
