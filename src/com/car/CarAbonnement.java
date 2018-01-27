package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.mechanic.Type;

public class CarAbonnement extends Car {	
    public CarAbonnement(Type type) {
    	super(type);
    	this.setType(Type.ABONNEMENT);
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
