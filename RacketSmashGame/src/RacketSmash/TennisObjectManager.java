package RacketSmash;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class TennisObjectManager {

	ArrayList<TennisBalls> tennisBallsList = new ArrayList<TennisBalls>();

	PlayerTennisRacket ptr;

	TennisBalls tennisBalls;

	OpponentRacket or;
	
	TennisGamePanel tgp;

	long ballSpawnTime = 1250;

	long tennisTimer = 0;
	
	long collision = 0;

	private int totalScore;

	public int gettotalScore() {

		return totalScore;
	}

	public void setTotalScore(int totalScore) {

		this.totalScore = totalScore;
	}

	public TennisObjectManager(PlayerTennisRacket ptr, TennisBalls tennisBalls, OpponentRacket or, TennisGamePanel tgp) {

		this.ptr = ptr;
		this.tennisBalls = tennisBalls;
		this.or = or;
		this.tgp = tgp;

	}

	void addTheTennisBalls(TennisBalls tb) {

		tennisBallsList.add(tb);
		System.out.println("add " + tb);
	}

	void draw(Graphics g) {
		
		or.draw(g);
		
		for (TennisBalls tb : tennisBallsList) {

			tb.draw(g);

		}

	}
	
	

	void update() {
		for (TennisBalls tb : tennisBallsList) {

			tb.update();
		}
		
		or.update();

	}

	public void manageTennisBalls() {

		if (System.currentTimeMillis() - tennisTimer >= ballSpawnTime) {
			System.out.println(System.currentTimeMillis() + " on " + this);
			addTheTennisBalls(new TennisBalls(new Random().nextInt(RacketSmash.width), 0, 50, 50));

			tennisTimer = System.currentTimeMillis();
		}


	}

	void checkCollision() {

//		ArrayList<TennisBalls> TennisBalls2 = (ArrayList<TennisBalls>) tennisBallsList.clone();

		for (TennisBalls tennisBalls : tennisBallsList) {

			if (tennisBalls.collisionBox.intersects(ptr.collisionBox)) {
			
					totalScore = totalScore + 1;
					System.out.println("Collision");
					tennisBalls.ySpeed *= -1;
					tennisBalls.ySpeed = tennisBalls.ySpeed;
					System.out.println(tennisBalls);
					tennisBalls.y -= 20;
					tennisBalls.ifIntersected = true;
					
			}
					
					if (tennisBalls.collisionBox.intersects(or.collisionBox ) && tennisBalls.ifIntersected) {
						
						tgp.gameOver();
					}
					
//					public static synchronized void playSound(final String url) {
//						  new Thread(new Runnable() {
//						  // The wrapper thread is unnecessary, unless it blocks on the
//						  // Clip finishing; see comments.
//						    public void run() {
//						      try {
//						        Clip clip = AudioSystem.getClip();
//						        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
//						          Main.class.getResourceAsStream("/path/to/sounds/" + url));
//						        clip.open(inputStream);
//						        clip.start(); 
//						      } catch (Exception e) {
//						        System.err.println(e.getMessage());
//						      }
//						    }
//						  }).start();
//						}
					

				}

			}

		

		// tennisBallsList = TennisBalls2;

	

	boolean checkIfLose() {

		for (TennisBalls tennisBalls : tennisBallsList) {

			if (tennisBalls.y > RacketSmash.height) {
				/*tennisBallsList.remove(tennisBalls);
				tennisBallsList.clear();
				tennisBallsList = new ArrayList<TennisBalls>();
				TennisGamePanel.setCurrentState(TennisGamePanel.ENDSTATE);*/
				System.out.println("Before");
				System.out.println(tennisBalls);
				return true;

			}
			
			
				
			}

		

		

		return false;
	}

}

//
// int x = tennisBalls.x;
// int y = ptr.x;
// Random r = new Random();
// r.nextInt(RacketSmash.width);
// int rangeX = RacketSmash.width - ptr.x;
// int rangeY = ptr.y - 10;
// int z = (RacketSmash.width - tennisBalls.width) - tennisBalls.x;
// int a = z / ((RacketSmash.height - tennisBalls.y) / tennisBalls.ySpeed);
// tennisBalls.xSpeed = (((RacketSmash.width - tennisBalls.width) -
// tennisBalls.x)
// / ((RacketSmash.height - tennisBalls.y) / tennisBalls.ySpeed));
//
// if (tennisBalls.ySpeed > 0) {
//
// tennisBalls.ySpeed *= -1;
// tennisBalls.ySpeed = tennisBalls.ySpeed;
//
//
//
// }
