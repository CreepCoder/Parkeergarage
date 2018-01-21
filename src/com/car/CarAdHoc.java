package com.car;

import java.util.Random;
import java.awt.*;

public class CarAdHoc extends Car {
	private static final Color COLOR=Color.red;
	
    public CarAdHoc() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}
