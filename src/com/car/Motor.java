package com.car;

import java.util.Random;

import com.lib.ColorList;

import java.awt.*;

public class Motor extends Car {
    public Motor() {
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
