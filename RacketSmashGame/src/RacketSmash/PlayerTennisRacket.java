package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;


public class PlayerTennisRacket  extends TennisGameObject {
	
	int speed;
	
	public PlayerTennisRacket (int x, int y, int height, int width) {
		super(x, y, width, height);

		speed = 13;

	}
	
	void update() {
		
		super.update();

	}

	void updatePositionR() {

		super.update(); 

		speed = 13;
		x += speed;

	}

	void updatePositionL() {

		super.update();

		speed = 13;
		x -= speed;

	}

	void updatePositionU() {

		super.update();
		
		speed = 13;
		y -= speed;

	}

	void updatePositionD() {

		super.update();

		speed = 13;
		y += speed;

	}

	void draw(Graphics g) {
		
		g.setColor(Color.BLUE);

		g.drawImage(TennisGamePanel.racketImg, x - 50 , y , 125, 125, null);
		

		
		
	}

	private void fillrect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}



}
