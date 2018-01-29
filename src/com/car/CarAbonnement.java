package com.car;

import java.awt.Color;
import java.util.Random;

import com.lib.ColorList;
import com.mechanic.Type;

/**
 * @author Groep C: Sander, Marc, Lorenzo, Iris, Danielle
 * @version 1.5
 */


public class CarAbonnement extends Car {	
	
    /**
     * Constructor voor de klasse CarAbonnement die verlengd is vanuit de klasse Car.
     * @param Type type = Het type auto wordt hier ingevoerd. type wordt uit de superklasse gehaald.
     * @param Type.ABONNEMENT = Zet het type vast voor de Abonnement autos.
     * @param stayminutes = Het vastzetten van het aantal resterende minuten.
     * @param false = Dit type auto hoeft niet te betalen bij de betaalautomaat.
     */
	
    public CarAbonnement(Type type) {
    	super(type);
    	this.setType(Type.ABONNEMENT);
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    /**
     * @return ColorList.CAR_PARKING_PASS = De gekoppelde kleur aan CAR_PARKING_PASS wordt teruggegeven.
     */
    public Color getColor(){
    	return ColorList.CAR_PARKING_PASS;
    }
}
