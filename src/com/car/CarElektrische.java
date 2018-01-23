package com.car;

import java.util.Random;

import com.lib.ColorList;

import java.awt.*;

public class CarElektrische extends Car {
    public CarElektrische(CarType type) {
    	super(type);
    	this.setType(CarType.ELEKTRISCH);
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
