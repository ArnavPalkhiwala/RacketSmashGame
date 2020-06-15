package RacketSmash;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;



public class tennisObjectManagers {

	ArrayList<TennisBalls> tennisBallsList = new ArrayList<TennisBalls>();

	PlayerTennisRacket ptr;

	TennisBalls tennisBalls;

	OpponentRacket or;

	int ballSpawnTime = 2000;

	long tennisTimer = 0;

	private int totalScore;

	public int gettotalScore() {

		return totalScore;
	}

	public void setTotalScore() {

		this.totalScore = totalScore;
	}

	public tennisObjectManagers(PlayerTennisRacket ptr, TennisBalls tennisBalls, OpponentRacket or) {

		this.ptr = ptr;
		this.tennisBalls = tennisBalls;
		this.or = or;

	}

	void addTheTennisBalls(TennisBalls tb) {

		tennisBallsList.add(tb);
	}

	void draw(Graphics g) {
		for (TennisBalls tb : tennisBallsList) {

			tb.draw(g);

		}

	}

	void update() {
		for (TennisBalls tb : tennisBallsList) {

			tb.update();
		}

	}

	public void manageTennisBalls() {

		if (System.currentTimeMillis() - tennisTimer >= ballSpawnTime) {
			addTheTennisBalls(new TennisBalls(new Random().nextInt(RacketSmash.width), 0, 50, 50));

			tennisTimer = System.currentTimeMillis();
		}

	}

	void checkCollision() {

		ArrayList<TennisBalls> TennisBalls2 = (ArrayList<TennisBalls>) tennisBallsList.clone();

		for (TennisBalls tennisBalls : tennisBallsList) {

			if (tennisBalls.collisionBox.intersects(ptr.collisionBox)) {

				Random r = new Random();
				int rangeX = RacketSmash.width - ptr.x;
				int rangeY = ptr.y - 10;
				int z = (RacketSmash.width - tennisBalls.width) - tennisBalls.x;
				int a = z / ((RacketSmash.height - tennisBalls.y) / tennisBalls.ySpeed);
				tennisBalls.xSpeed = (((RacketSmash.width - tennisBalls.width) - tennisBalls.x)
						/ ((RacketSmash.height - tennisBalls.y) / tennisBalls.ySpeed));

				if (tennisBalls.ySpeed > 0) {

					tennisBalls.ySpeed *= -1;
					tennisBalls.ySpeed = tennisBalls.ySpeed;
					
					

				}

			}

			// if (tennisBalls.collisionBox.intersects(ptr.collisionBox) ) {
			//
			// if (tennisBalls.y <= 100) {
			//
			// tennisBallsList.remove(tennisBalls);
			//
			// System.out.println("It actually works");
			//
			// }
			//
			// }

			if (tennisBalls.collisionBox.intersects(or.collisionBox)) {

				System.out.println("It works");
				totalScore = totalScore + 1;

			}

		}

		tennisBallsList = TennisBalls2;

	}
	
	boolean checkIfLose() {
		
		for (int i = 0; i < tennisBallsList.size(); i++) {

			if (tennisBallsList.get(i).y > RacketSmash.height) {
				
				tennisBallsList.clear();
				return true;

			}

		}
		return false;
	}

	

}

