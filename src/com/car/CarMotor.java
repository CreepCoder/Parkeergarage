package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.location.LocationType;

public class CarMotor extends Car {
    public CarMotor(LocationType type) {
    	super(type);
    	this.setType(LocationType.MOTOR);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    // Return the given color
    public Color getColor(){
    	return ColorList.MOTOR;
    }
}
