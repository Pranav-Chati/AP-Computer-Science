package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Drawable {
	public enum DrawMethod {
		DRAW, FILL
	};

	protected DrawMethod preferredDrawMethod = DrawMethod.DRAW;

	protected Color color;

	public void draw(Graphics g) {
		return;
	}

	public void fill(Graphics g) {
		return;
	}

	public void move(Point vector) {
		return;
	}

	@Override
	public String toString() {
		return "";
	}

	public void mousePressed(Point click_coord) {
		return;
	}
	
	public void mouseMoved(MouseEvent e) {
		return;
	}
	
	public void keyPressed(KeyEvent e) {
		return;
	}
	
	public void keyReleased(KeyEvent e) {
		return;
	}

	public void preferredDrawMethod(Graphics g) {
		if (preferredDrawMethod == DrawMethod.DRAW) {
			this.draw(g);
		} else if (preferredDrawMethod == DrawMethod.FILL) {
			this.fill(g);
		}
	}

	public void setPreferredDrawMethod(DrawMethod preferredDrawMethod) {
		this.preferredDrawMethod = preferredDrawMethod;
	}

	public DrawMethod getPreferredDrawMethod() {
		return this.preferredDrawMethod;
	}
}
