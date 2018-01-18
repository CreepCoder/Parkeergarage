package com.main.car;

import java.util.Random;

import com.main.lib.ColorList;

import java.awt.*;

public class CarParkingPass extends Car {
	
    public CarParkingPass() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    public Color getColor(){
    	return ColorList.PARKING_PASS_CAR;
    }
}
