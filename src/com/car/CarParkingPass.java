package com.car;

import java.util.Random;
import java.awt.*;

public class CarParkingPass extends Car {
	private static final Color COLOR=Color.blue;
	
    public CarParkingPass() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
