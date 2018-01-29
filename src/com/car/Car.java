package com.car;

import java.awt.Color;

import com.location.Location;
import com.location.LocationMap;
import com.mechanic.Type;

/**
 * @author Groep C: Sander, Marc, Lorenzo, Iris, Daniëlle
 * @version 1.5
 */
public class Car {

    private Location location;
    private int minutesLeft;
    private boolean isPaying;
    private boolean hasToPay;
    private Type type;
	private LocationMap locationmap;

    /**
     * Constructor voor de klasse Car
     * @param Type type = het type auto wordt hier ingevoerd.
     */
    public Car(Type type) {
    	this.setType(type);
    }
    /**
     * @return location = de locatie van de auto wordt hier teruggegeven.
     */
    public Location getLocation() {
        return location;
    }
    /**
     * @param Location location = De locatie van de auto wordt hier ingevoerd.
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    /**
     * @return minutesLeft = het aantal overige minuten wordt teruggegeven.
     */
    public int getMinutesLeft() {
        return minutesLeft;
    }
    /**
     * @param int minutesLeft = Het aantal resterende minuten.
     */
    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    /**
     * @return hasToPay = Haalt op of de auto betaalt of niet.
     */    
    public boolean getIsPaying() {
        return isPaying;
    }
    /**
     * @param boolean isPaying = Zet vast of de auto betaalt of niet
     */
    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }
    /**
     * @return hasToPay = Haalt op of de auto moet betalen of niet.
     */
    public boolean getHasToPay() {
        return hasToPay;
    }
    /**
     * @return hasToPay = Zet vast of de auto moet betalen of niet.
     */
    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }

    public void tick() {
        minutesLeft--;
    }
    /**
     * @return type.getColor() = Haalt de kleur van de auto op.
     */    
    public Color getColor() {
		return type.getColor();
    }
    /**
     * @return type = Haalt het type op.
     */ 
	public Type getType() {
		return type;
	}
    /**
     * @param Type type = Zet het type vast.
     */
	public void setType(Type type) {
		this.type = type;
	}
    /**
     * @return locationmap = Haalt de locatie van de auto op de map op.
     */ 
	public LocationMap getLocationmap() {
		return locationmap;
	}
    /**
     * @param LocationMap locationmap = Zet de locatie van de auto op de map vast.
     */
	public void setLocationmap(LocationMap locationmap) {
		this.locationmap = locationmap;
	}
}