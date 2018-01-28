package com.mvc.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.car.Car;
import com.lib.ColorList;
import com.lib.Methods;
import com.location.LocationMap;
import com.mechanic.Type;
import com.mvc.model.Model;

@SuppressWarnings("serial")
public class ViewCarPark extends AbstractView{
	
	public static int x;
	public static int y;
	public static int width;
	public static int height;
	public static Type type;
	private int spaceX = 0;
	
	private JLabel ingang1 	= new JLabel("Ingang");
	private JLabel ingang2 	= new JLabel("<html>Ingang<br>Abonnement</html>");
	private JLabel bg		= new JLabel("<html><center>Naar<br>0</center></html>");
	private JLabel eerstea	= new JLabel("<html><center>Naar<br>+1</center></html>");
	private JLabel eersteb	= new JLabel("<html><center>Naar<br>+1</center></html>");
	private JLabel tweede	= new JLabel("<html><center>Naar<br>+2</center></html>");
	
	private int nextPosJ = 0;
	private int nextPosI = 0;

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

	public ViewCarPark(Model model) {
		super(model);
		this.setSize(850, 400);
		this.setLayout(null);
		
		Methods.voegLabelToe(ingang1, 3, 355, 100, 20, true, this, SwingConstants.LEFT);
		Methods.voegLabelToe(ingang2, 3, 0, 200, 40, true, this, SwingConstants.LEFT);
		
		Methods.voegLabelToe(bg, 492, 80, 50, 40, true, this, SwingConstants.CENTER);
		Methods.voegLabelToe(eerstea, 255, 80, 50, 40, true, this, SwingConstants.CENTER);
		Methods.voegLabelToe(eersteb, 492, 255, 50, 40, true, this, SwingConstants.CENTER);
		Methods.voegLabelToe(tweede, 732, 255, 50, 40, true, this, SwingConstants.CENTER);
		
		repaint();
	}
	
	boolean added = false;
	public void paintComponent(Graphics g) {
		// Teken achtergrond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Teken belijning
		g.setColor(Color.black);
		g.drawRect(0, 0, 0+this.getWidth()-1, 0+this.getHeight()-1);
		
		// Doorgang voor naar boven of naar beneden
		g.drawRect(250, 80, 60, 40);
		g.drawRect(488, 80, 60, 40);
		g.drawRect(488, 255, 60, 40);
		g.drawRect(726, 255, 60, 40);
		
		// Kader om elke verdieping
		g.setColor(Color.black);
		g.drawRect(75, 5, 239, 368);
		g.drawRect(314, 5, 239, 368);
		g.drawRect(553, 5, 239, 368);

		if (added == false) {
		spaceX = 0;
		for (int i=0; i<18; i++) {
			if (i == 2 || i == 4 || i == 8 || i == 10 || i == 14 || i == 16) {spaceX = spaceX + 16;}
			if (i == 6 || i == 12) {spaceX = spaceX + 75;}
			for (int j=0; j<30; j++) {
				if (map[j][i] == 0) {
					LocationMap location = new LocationMap(80+(i*22)+spaceX, 10+(j*12), Type.ADHOC, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
				}
				if (map[j][i] == 1) {
					LocationMap location = new LocationMap(80+(i*22)+spaceX, 10+(j*12), Type.ABONNEMENT, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				if (map[j][i] == 2) {
					LocationMap location = new LocationMap(80+(i*22)+spaceX, 10+(j*12), Type.ELEKTRISCH, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				if (map[j][i] == 3) {
					LocationMap location = new LocationMap(80+(i*22)+spaceX, 10+(j*12), Type.INVALIDE, null);
					tiles[i][j] = location;
					if (location.getCar() == null || location.getCar().getType() != location.getType()) {
						location.drawLocation(g, ColorList.LEGE_VAKKEN, location.getX()+1, location.getY()+1);
						}
					}
				if (map[j][i] == 4) {
					LocationMap location = new LocationMap(80+(i*22)+spaceX, 10+(j*12), Type.MOTOR, null);
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
				if (Model.dag > 4) {
					if (tiles[i][j].getType() == Type.ABONNEMENT) {
						tiles[i][j].setType(Type.ADHOC);
					}
				}
				
					if (tiles[i][j].getCar() == null) {
							tiles[i][j].drawLocation(g, ColorList.LEGE_VAKKEN, tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					else if (tiles[i][j].getCar().getType() == tiles[i][j].getType()) {
						tiles[i][j].drawLocation(g, tiles[i][j].getType().getColor(), tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					else if (tiles[i][j].getType() == Type.ADHOC && tiles[i][j].getCar().getType() == Type.ABONNEMENT) {
						tiles[i][j].drawLocation(g, tiles[i][j].getCar().getColor(), tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					else if (tiles[i][j].getCar().getType() == Type.DUBBELE_PARKEERDER) {
						tiles[i][j].drawLocation(g, tiles[i][j].getCar().getColor(), tiles[i][j].getX()+1, tiles[i][j].getY()+1);
					}
					
					drawLocationType(g, tiles, i, j);
			}
		}
	}
	
	public void drawLocationType(Graphics g, LocationMap[][] tiles, int i, int j) {
		if (tiles[i][j].getType() == Type.ADHOC) {
			g.setColor(Type.ADHOC.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == Type.ABONNEMENT) {
			g.setColor(Type.ABONNEMENT.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == Type.ELEKTRISCH) {
			g.setColor(Type.ELEKTRISCH.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == Type.INVALIDE) {
			g.setColor(Type.INVALIDE.getColor());
			g.drawRect(tiles[i][j].getX()-1, tiles[i][j].getY()-1, 21, 11);
		}
		if (tiles[i][j].getType() == Type.MOTOR) {
			g.setColor(Type.MOTOR.getColor());
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
    	if (car != null) {
    		car.setLocation(null);
    	}
    }
    
    public LocationMap getFreePosition(Car car) {
		for (int i=0; i<18; i++) {
			for (int j=0; j<30; j++) {
				if (tiles[i][j].getCar() == null && tiles[i][j].getType() == car.getType()) {
					return tiles[i][j];
				}
				if (tiles[i][j].getCar() == null && car.getType() == Type.DUBBELE_PARKEERDER && tiles[i][j+1].getCar() == null) {
					nextPosI = i;
					nextPosJ = j+1;
					return tiles[i][j];
				}
			}
		}
		return null;
    }
    
    public LocationMap getNextPosition() {
		return tiles[nextPosI][nextPosJ];
    }
}
