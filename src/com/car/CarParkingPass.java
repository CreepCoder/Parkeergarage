package com.car;

import java.util.Random;

import com.lib.ColorList;

import java.awt.*;

public class CarParkingPass extends Car {	
    public CarParkingPass(CarType type) {
    	super(type);
    	this.setType(CarType.PARKING_PASS);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    // Return the given color
    public Color getColor(){
    	return ColorList.CAR_PARKING_PASS;
    }
}
