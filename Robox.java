package Robox;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Robox - a robot by (your name here)
 */
public class Robox extends Robot
{
	/**
	 * run: Robox's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
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
		String robotank = e.getName();
		double distancia = e.getDistance();
		System.out.println(robotank + " distância " + distancia);
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
		// Replace the next line with any behavior you would like
	back(50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	    back(50);
		turnRight(90);
	}	
}
