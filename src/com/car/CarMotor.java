package com.car;

import java.util.Random;

import com.lib.ColorList;

import java.awt.*;

public class CarMotor extends Car {
    public CarMotor(CarType type) {
    	super(type);
    	this.setType(CarType.MOTOR);
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
