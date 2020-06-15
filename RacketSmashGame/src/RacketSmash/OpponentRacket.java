package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class OpponentRacket extends TennisGameObject {

	public OpponentRacket(int x, int y, int width, int height) {
		super(x, y, width, height);
		
   	 collisionBox = new Rectangle(x, y, width -5, height -5);


	}
	
	int ySpeed = 0;
	double xSpeed = 3.4309328;
	


	void update() {
		
	
		
		if (x >= RacketSmash.width - 3) {
			
			xSpeed = xSpeed*-1;
			
		}
		
		
		
			
			if (x < 0) {
				
				xSpeed = xSpeed*-1;
				
			}

			
		
		
				
		y += ySpeed;
		x += xSpeed;
		
   	 	collisionBox.setBounds(x + 5, y, width -5, height - 5);
	}

	void draw(Graphics g) {

		g.setColor(Color.RED);
		g.drawImage(TennisGamePanel.racketImg, x, y, width, height, null);
		Graphics2D g2 = (Graphics2D) g;
//		g2.draw(collisionBox);

	}

	private void fillrect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub

	}

}
