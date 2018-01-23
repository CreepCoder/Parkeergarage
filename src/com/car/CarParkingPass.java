package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.location.LocationType;

public class CarParkingPass extends Car {	
    public CarParkingPass(LocationType type) {
    	super(type);
    	this.setType(LocationType.PARKING_PASS);
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
