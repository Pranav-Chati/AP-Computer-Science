package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

//import aight.pong.Sound;
//import aight.pong.render.Rectangle;

public class Paddle extends Rectangle {

	private enum DIRECTION {
		DOWN, UP, NONE
	};

	private enum PREFERRED_EVENT {
		MOUSE, KEY
	};

	private DIRECTION direction;
	private PREFERRED_EVENT preferredEvent;

	int KeyCodeUp;
	int KeyCodeDown;
	int speed;
	int nextY;

	public Paddle(Point location, int speed) {
		super(location, new Dimension(10, 100), Color.WHITE);
		preferredDrawMethod = DrawMethod.FILL;

		direction = DIRECTION.NONE;
		preferredEvent = PREFERRED_EVENT.MOUSE;

		this.speed = speed;
	}
	
	public Paddle(Point location, int KeyCodeUp, int KeyCodeDown, int speed) {
		super(location, new Dimension(10, 100), Color.WHITE);
		preferredDrawMethod = DrawMethod.FILL;

		direction = DIRECTION.NONE;
		preferredEvent = PREFERRED_EVENT.KEY;

		this.KeyCodeDown = KeyCodeDown;
		this.KeyCodeUp = KeyCodeUp;
		this.speed = speed;
	}

	public void keyPressed(KeyEvent e) {
		if (preferredEvent == PREFERRED_EVENT.KEY) {
			if (e.getKeyCode() == KeyCodeDown) {
				direction = DIRECTION.DOWN;
			}

			if (e.getKeyCode() == KeyCodeUp) {
				direction = DIRECTION.UP;
			}
		}
		return;
	}

	public void keyReleased(KeyEvent e) {
		if (preferredEvent == PREFERRED_EVENT.KEY) {
			if (e.getKeyCode() == KeyCodeDown && direction == DIRECTION.DOWN) {
				direction = DIRECTION.NONE;
			}

			if (e.getKeyCode() == KeyCodeUp && direction == DIRECTION.UP) {
				direction = DIRECTION.NONE;
			}
		}
		return;
	}
	
	public void mouseMoved(MouseEvent e) {
		if (preferredEvent == PREFERRED_EVENT.MOUSE) {
			nextY = e.getY() - this.size.height / 2;
		}
	}
	
	public int getTop() {
		return location.y;
	}

	public int getBottom() {
		return size.height + location.y;
	}

	public int getRight() {
		return location.x;
	}

	public int getLeft() {
		return size.width + location.x;
	}

	public void move() {
		if (preferredEvent == PREFERRED_EVENT.KEY) {
			switch (direction) {
			case UP:
				this.location.y -= speed;
				break;
			case NONE:
				break;
			case DOWN:
				this.location.y += speed;
				break;
			}
		} else if (preferredEvent == PREFERRED_EVENT.MOUSE) {
			this.location.y = nextY;
		}
	}

	public void calcCollision(Ball ball) {
		double distTop = 0;
		double distRight = 0;
		double distBottom = 0;
		double distLeft = 0;
		int numCollisions = 0;

		Random rand = new Random();

		for (int y = this.getTop(); y <= this.getBottom(); y++) {
			for (int x = this.getRight(); x <= this.getLeft(); x++) {
				if (ball.containsPoint(new Point(x, y))) {

					distTop += Math.abs(y - this.getTop());
					distRight += Math.abs(x - this.getRight());
					distBottom += Math.abs(this.getBottom() - y);
					distLeft += Math.abs(this.getLeft() - x);
					numCollisions++;

				}
			}
		}

		if (numCollisions > 0) {

			//Sound.play("src\\pingpongsound");

			distTop /= numCollisions;
			distRight /= numCollisions;
			distBottom /= numCollisions;
			distLeft /= numCollisions;

			if (distLeft < distRight) {
				if (distLeft < distTop && distLeft < distBottom) {
					ball.setDirection(ball.getReflectorAngle(90, rand.nextDouble() * 0.5));
					ball.move(new Point((int) (this.getLeft() - (ball.getCenter().getX() - ball.getRadius())), 0));
				} else {
					ball.setDirection(ball.getReflectorAngle(0, rand.nextDouble() * 0.5));
					if (distTop < distBottom) {
						ball.move(new Point(0, (int) (this.getTop() - (ball.getCenter().getY() + ball.getRadius()))));
					} else if (distBottom < distTop) {
						ball.move(
								new Point(0, (int) (this.getBottom() - (ball.getCenter().getY() - ball.getRadius()))));
					}
				}
			} else if (distRight < distLeft) {
				if (distRight < distTop && distRight < distBottom) {
					ball.setDirection(ball.getReflectorAngle(90, rand.nextDouble() * 0.5));
					ball.move(new Point((int) (this.getRight() - (ball.getCenter().getX() + ball.getRadius())), 0));
				} else {
					ball.setDirection(ball.getReflectorAngle(0, rand.nextDouble() * 0.5));
					if (distTop < distBottom) {
						ball.move(new Point(0, (int) (this.getTop() - (ball.getCenter().getY() + ball.getRadius()))));
					} else if (distBottom < distTop) {
						ball.move(
								new Point(0, (int) (this.getBottom() - (ball.getCenter().getY() - ball.getRadius()))));
					}
				}
			}
		}
	}
}
