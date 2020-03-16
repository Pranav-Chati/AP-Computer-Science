package pong;

import java.awt.Color;
import java.awt.Point;


public class Ball extends Circle {
	private int direction;
	private double speed;

	public Ball(Point center, double speed) {
		super(center, 20, Color.green);
		preferredDrawMethod = DrawMethod.FILL;
		this.speed = speed;
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public void setDirection(int degrees) {
		direction = degrees % 360;
	}

	public void turn(int degrees) {
		direction = (direction + degrees) % 360;
	}

	public void move() {
		move(new Point((int) (speed * 1 * Math.cos(Math.toRadians(direction))),
				(int) (speed * Math.sin(Math.toRadians(direction)))));
	}

	public int getReflectorAngle(int angleOfSurface, double tilt) {

		int inital = direction - angleOfSurface;
		
		if (inital < 0 || inital > 180) {
			inital = (inital + 180) % 360;
			angleOfSurface = (angleOfSurface + 180) % 360;
		}
		
		double after = angleOfSurface - inital * (1 - tilt) ;

	    return (int)(after + 360) % 360;
	}
}
