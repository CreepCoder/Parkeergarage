package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.mechanic.Type;

public class CarInvalide extends Car {
    
	/**
     * Constructor voor de klasse CarAbonnement die verlengd is vanuit de klasse Car.
     * @param Type type = Het type auto wordt hier ingevoerd. type wordt uit de superklasse gehaald.
     * @param Type.INVALIDE = Zet het type vast voor de autos van invaliden.
     * @param stayminutes = Het vastzetten van het aantal resterende minuten.
     * @param true = Dit type auto moet wel betalen bij de betaalautomaat.
     */
	
    public CarInvalide(Type type) {
    	super(type);
    	this.setType(Type.INVALIDE);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    /**
     * @return ColorList.INVALIDE_CAR = De gekoppelde kleur wordt teruggegeven.
     */
    public Color getColor(){
    	return ColorList.INVALIDE_CAR;
    }
}
