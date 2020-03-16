package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Drawable {
	protected int radius;
	protected Point center;

	public Circle(Point center, int radius, Color color) {
		this.center = new Point(center);
		this.radius = radius;
		this.color = color;
	}

	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		// Translates circle's center to rectangle's origin for drawing.
		g.drawOval((int) center.getX() - radius, (int) center.getY() - radius, radius * 2, radius * 2);
		g.setColor(oldColor);
	}

	public void fill(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		// Translates circle's center to rectangle's origin for drawing.
		g.fillOval((int) center.getX() - radius, (int) center.getY() - radius, radius * 2, radius * 2);
		g.setColor(oldColor);
	}

	public boolean containsPoint(Point p) {
		int xSquared = (int) ((p.getX() - (int) center.getX()) * (p.getX() - (int) center.getX()));
		int ySquared = (int) ((p.getY() - (int) center.getY()) * (p.getY() - (int) center.getY()));
		int radiusSquared = radius * radius;
		return xSquared + ySquared - radiusSquared <= 0;
	}

	public void move(Point vector) {
		center.setLocation(center.getX() + vector.getX(), center.getY() + vector.getY());
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
}