package com.car;

import java.util.Random;

import com.lib.ColorList;

import java.awt.*;

public class InvalideCar extends Car {
    public InvalideCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    // Return the given color
    public Color getColor(){
    	return ColorList.INVALIDE_CAR;
    }
}
