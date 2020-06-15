package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;

public class TennisBalls extends TennisGameObject{
	
	int ySpeed = 4;
	int xSpeed = 0;
	boolean isAlive = true;
	boolean ifIntersected = false;
	
	public TennisBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		
		super.update();
		
		if (x <= 0) {
			xSpeed = 1;
			
		}
		
		if (x >= RacketSmash.width) {
			
			xSpeed = -1;
			
		}
		
		
		
		y += ySpeed;
		x += xSpeed;
	}
	
	void draw(Graphics g) {
		
		g.setColor(Color.YELLOW);
		g.drawImage( TennisGamePanel.tbImg, x, y, width, height, null);
		
	}
	


}
