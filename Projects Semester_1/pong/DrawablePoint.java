package pong;

import java.awt.Graphics;
import java.awt.Point;

public class DrawablePoint extends Drawable {
	private double x;
	private double y;
	private Point p;

	public DrawablePoint() {
		x = 0;
		y = 0;
	}

	public DrawablePoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public DrawablePoint(DrawablePoint p) {
		x = p.x;
		y = p.y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void draw(Graphics g) {
		// Draws points and their coordinate labels on the panel.
		g.drawString(toString(), (int) x + 6, (int) y - 6);
		g.drawOval((int) x - 2, (int) y - 2, 4, 4);
	}

	@Override
	public String toString() {
		return "(" + String.valueOf(x) + ", " + String.valueOf(-y) + ")";
	}
}
