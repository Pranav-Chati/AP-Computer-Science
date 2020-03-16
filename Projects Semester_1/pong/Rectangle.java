package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Drawable {
	protected Point location;
	protected Dimension size;
	
	public Rectangle(Point location, Dimension size, Color color) {
		this.location = new Point(location);
		this.size = new Dimension(size);
		this.color = color;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.drawRect((int) location.getX(), (int) location.getY(), (int) size.getWidth() + 5, (int) size.getHeight() + 10);
		g.setColor(oldColor);
	}

	public void fill(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillRect((int) location.getX(), (int) location.getY(), (int) size.getWidth() + 5, (int) size.getHeight() + 10);
		g.setColor(oldColor);
	}

	public void move(Point vector) {
		location.setLocation(location.getX() + vector.getX(), location.getY() + vector.getY());
	}
	
	public Point getLocation() {
		return location;
	}
	
	public Dimension getSize() {
		return size;
	}
}
