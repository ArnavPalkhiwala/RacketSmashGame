package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class TennisGameObject {
	
	 int x;
     int y;
     int width;
     int height;
     
     Rectangle collisionBox;
     
     
     public TennisGameObject(int x, int y, int width, int height) {
    	 
 		super();

    	 
    	 this.x = x;
    	 this.y = y;
    	 this.width = width;
    	 this.height = height;
    	 
    	 collisionBox = new Rectangle(x, y, width, height);
    	 
    	 
     }
     
     void update() {
    	 
    	 collisionBox.setBounds(x + 5, y, width, height);

    	 
     }
     
     void draw(Graphics g) {
    	  
     }
     
 
 		

}
