package com.location;

import java.awt.Color;
import java.awt.Graphics;

import com.mvc.model.Model;
import com.mvc.view.AbstractView;

@SuppressWarnings("serial")
public class Map extends AbstractView{
	
	public static int x;
	public static int y;
	public static int width;
	public static int height;
	public static LocationType type;

    double[][] map = {
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 4, 4},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3},
			{0, 0, 	 1, 1, 	 3, 3}			
	};

	public Map(Model model) {
		super(model);
		this.setSize(200, 540);
		this.setLayout(null);

		repaint();
	}
	
	//public static void drawTile(Graphics g, LocationType type, int x, int y) {
	//	g.setColor(type.getColor());
	//	g.fillRect(x, y, x+20, y+30);
	//}
	
	public void setCoords(int x, int y, LocationType type) {
		Map.x = x;
		Map.y = y;
		Map.width = x+20;
		Map.height = y+10;
		Map.type = type;
	}
	
	public void paintComponent(Graphics g) {

		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 540);
		
		g.setColor(Color.black);
		g.drawLine(0, 0, 0, 400);
		g.drawLine(0, 0, 199, 0);
		g.drawLine(0, 400, 199, 400);
		g.drawLine(199, 0, 199, 400);
		
		int spaceX = 0;
		for (int i=0; i<6; i++) {
			if (i == 2 || i == 4) {spaceX = spaceX + 8;}
			for (int j=0; j<30; j++) {
				if (map[j][i] == 0) {
			        g.setColor(LocationType.AD_HOC.getColor());
					g.fillRect(26+(i*22)+spaceX, 20+(j*12), 20, 10);
				}
				if (map[j][i] == 1) {
					g.setColor(LocationType.PARKING_PASS.getColor());
					g.fillRect(26+(i*22)+spaceX, 20+(j*12), 20, 10);
					}
				if (map[j][i] == 2) {
					g.setColor(LocationType.ELEKTRISCH.getColor());
					g.fillRect(26+(i*22)+spaceX, 20+(j*12), 20, 10);
					}
				if (map[j][i] == 3) {
					g.setColor(LocationType.INVALIDE.getColor());
					g.fillRect(26+(i*22)+spaceX, 20+(j*12), 20, 10);
					}
				if (map[j][i] == 4) {
					g.setColor(LocationType.MOTOR.getColor());
					g.fillRect(26+(i*22)+spaceX, 20+(j*12), 20, 10);
					}
			}
			//spaceX = 0;
		}
        //g.setColor(Map.type.getColor());
		//g.fillRect(Map.x, Map.y, Map.x+20, Map.y+30);
	}
}
