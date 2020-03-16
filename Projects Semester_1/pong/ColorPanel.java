package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ColorPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;

	protected Point Mouse;
	protected ArrayList<Drawable> drawList;
	protected boolean verbose = true;
	protected Image background;

	public ColorPanel(Color background_color) {
		Mouse = new Point();

		drawList = new ArrayList<Drawable>();

		// Set Background Color
		setBackground(background_color);

		// Add a Mouse Listener to move the Mouse Point
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (background != null)
			g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
		
		// Draw Objects and Print Object Data to Terminal
		if (verbose)
			System.out.print("\n\n");
		for (int i = 0; i < drawList.size(); i++) {
			drawList.get(i).preferredDrawMethod(g);
			if (verbose)
				System.out.println(drawList.get(i).toString());
		}
	}

	public void add(Drawable e) {
		drawList.add(e);
	}

	
	public Repainter getRepainter() {
		return (new Repainter());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < drawList.size(); i++)
			drawList.get(i).mousePressed(new Point(e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (int i = 0; i < drawList.size(); i++)
			drawList.get(i).mouseMoved(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < drawList.size(); i++)
			drawList.get(i).keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < drawList.size(); i++)
			drawList.get(i).keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
//	public void KeyPressed(KeyEvent e) {
//		for (int i = 0; i < drawList.size(); i++)
//			drawList.get(i).keyPressed(e);
//	}

	public class Repainter {
		public void repaintNow() {
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
