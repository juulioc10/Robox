package Robox;

import robocode.*;

public class Robox extends Robot {

	public void run() {
		while(true) {
			ahead(100);
			turnLeft(90);
			turnGunRight(360);
			back(100);
			turnRight(90);
			turnGunRight(360);
			ahead(100);
			turnLeft(90);
			turnGunRight(360);
			back(100);
			turnRight(90);
			turnGunRight(360);
			back(100);
			ahead(100);
			turnLeft(90);
			turnGunRight(360);
		}
	}

	//tank robô inimigo detectedo
	public void onScannedRobot(ScannedRobotEvent e) {
		double distancia = e.getDistance();
		System.out.println(e.getName() + " distância " + distancia);
	    if (distancia < 135) {
			fire(3);
		}else {
			fire(1);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		evadeBullet();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		evadeWall();
	}

	private void moveRandom() {
		ahead(Math.random() * 200);
		turnRight(Math.random() * 360);
	}
		private void evadeBullet() {
		turnLeft(90);
		ahead(100);
	}	
    private void evadeWall() {
	    back(50);
	    turnRight(90);
    }		
}