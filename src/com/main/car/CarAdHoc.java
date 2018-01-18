package com.main.car;

import java.util.Random;

import com.main.lib.ColorList;
import java.awt.*;

public class CarAdHoc extends Car {
	
    public CarAdHoc() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    public Color getColor(){
    	return ColorList.NORMAL_CAR;
    }
}
