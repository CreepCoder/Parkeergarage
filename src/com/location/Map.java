package com.location;

import java.awt.Color;
import java.awt.Graphics;

import com.car.Car;
import com.lib.ColorList;
import com.mvc.model.Model;
import com.mvc.view.AbstractView;

@SuppressWarnings("serial")
public class Map extends AbstractView{
	
	public static int x;
	public static int y;
	public static int width;
	public static int height;
	public static LocationType type;
	private int spaceX = 0;

	/* Hier wordt een grid aangemaakt voor de nieuwe opzet voor de parkeergarage.
	 * Alle verschillende vakjes worden hier aangegeven met een id.
	 * Uiteindelijk is het de bedoeling dat alleen de auto's waarvoor het vakje bedoeld is hier parkeren.
	 */
    
    LocationMap[][] tiles = new LocationMap[18][30];
    double[][] map = {
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 2, 2,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 4, 4,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0},
			{0, 0, 	 1, 1, 	 3, 3,      0, 0,   0, 0,   1, 1,      0, 0,   0, 0,   0, 0}
	};

	public Map(Model model) {
		super(model);
		this.setSize(400, 800);
		this.setLayout(null);

		repaint();
	}
	
	public void setCoords(int x, int y, LocationType type) {
		Map.x = x;
		Map.y = y;
		Map.width = x+20;
		Map.height = y+10;
		Map.type = type;
	}
	boolean added = false;
	public void paintComponent(Graphics g) {
		// Creëer achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Creëer omlijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 809, 379);

		if (added == false) {
		spaceX = 0;
		for (int i=0; i<18; i++) {
			if (i == 2 || i == 4 || i == 8 || i == 10 || i == 14 || i == 16) {spaceX = spaceX + 16;}
			if (i == 6 || i == 12) {spaceX = spaceX + 100;}
			for (int j=0; j<30; j++) {
				if (map[j][i] == 0) {
					LocationMap location = new LocationMap(15+(i*22)+spaceX, 10+(j*12), LocationType.AD_HOC, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
				}
				if (map[j][i] == 1) {
					LocationMap location = new LocationMap(15+(i*22)+spaceX, 10+(j*12), LocationType.PARKING_PASS, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				if (map[j][i] == 2) {
					LocationMap location = new LocationMap(15+(i*22)+spaceX, 10+(j*12), LocationType.ELEKTRISCH, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				if (map[j][i] == 3) {
					LocationMap location = new LocationMap(15+(i*22)+spaceX, 10+(j*12), LocationType.INVALIDE, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				if (map[j][i] == 4) {
					LocationMap location = new LocationMap(15+(i*22)+spaceX, 10+(j*12), LocationType.MOTOR, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				}
			}
		}
		added = true;
		
		// Teken de locaties met de auto die gekoppeld is aan de locatie, als de locatie leeg is, wordt er een leeg vak getekend.
		spaceX = 0;
		for (int i=0; i<18; i++) {
			for (int j=0; j<30; j++) {
				if (Model.day > 4) {
					if (tiles[i][j].getType() == LocationType.PARKING_PASS) {
						tiles[i][j].setType(LocationType.AD_HOC);
					}
				}
				
					if (tiles[i][j].getCar() == null) {
							tiles[i][j].drawLocation(g, ColorList.LEGE_VAKKEN, tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					else if (tiles[i][j].getCar().getType() == tiles[i][j].getType()) {
						tiles[i][j].drawLocation(g, tiles[i][j].getType().getColor(), tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					else if (tiles[i][j].getType() == LocationType.AD_HOC && tiles[i][j].getCar().getType() == LocationType.PARKING_PASS) {
						tiles[i][j].drawLocation(g, tiles[i][j].getCar().getColor(), tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					drawLocationType(g, tiles, i, j);
			}
		}
	}
	
	public void drawLocationType(Graphics g, LocationMap[][] tiles, int i, int j) {
		if (tiles[i][j].getType() == LocationType.AD_HOC) {
			g.setColor(LocationType.AD_HOC.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == LocationType.PARKING_PASS) {
			g.setColor(LocationType.PARKING_PASS.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == LocationType.ELEKTRISCH) {
			g.setColor(LocationType.ELEKTRISCH.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == LocationType.INVALIDE) {
			g.setColor(LocationType.INVALIDE.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == LocationType.MOTOR) {
			g.setColor(LocationType.MOTOR.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
	}
	
    public Car getCarAt(LocationMap location) {
    	for (int i=0; i<18; i++) {
			for (int j=0; j<30; j++) {
				if (map[j][i] == 0 || map[j][i] == 1 || map[j][i] == 2 || map[j][i] == 3 || map[j][i] == 4 ) {
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						return null;
					}
					else {
						return location.getCar();
					}
				}
			}
		}
		return null;
    }
    
    public void setCarAt(LocationMap location, Car car) {
    	if (location != null && car != null) {
    		car.setLocationmap(location);
    		location.setCar(new Car(car.getType()));
    		}    
    	}

    public void removeCarAt(LocationMap location) {
        Car car = location.getCar();
        location.setCar(null);
        if (car == null) {
        }
        else {
        	car.setLocation(null);
        }
    }
    
    public LocationMap getFreePosition(Car car) {
		for (int i=0; i<18; i++) {
			for (int j=0; j<30; j++) {
					if (tiles[i][j].getCar() == null && tiles[i][j].getType() == car.getType()) {
						return tiles[i][j];
					}
			}
		}
		return null;
    }
}
