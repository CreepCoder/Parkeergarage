package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.mechanic.Type;

public class CarDubbeleParkeerder extends Car {
    public CarDubbeleParkeerder(Type type) {
    	super(type);
    	this.setType(Type.DUBBELE_PARKEERDER);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    // Return the given color
    public Color getColor(){
    	return ColorList.DUBBELE_PARKEERDER;
    }
}
