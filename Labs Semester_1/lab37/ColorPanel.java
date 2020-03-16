/*By:Pranav Chati
 * Grade: 
 * Date: 
 */

package lab37;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ColorPanel extends JPanel {
	
	
	static int x;
	static int y;
	//this is for the counter
	static int x1;
	static int y1;
	 static int ox;
	 static int oy;
	 static int ox2 ;
	 static int oy2;	
	
	public ColorPanel(Color backColor) {
		setBackground(backColor);
		addMouseListener(new PanelListener());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawLine(25, 25, 250, 25);

		   ox = getWidth();
		   oy = getHeight()/2;
		   ox2 = getWidth()/2;
		   oy2 = getHeight();
		   
		  g.setColor(Color.black);
		  
		  g.drawLine(0,oy,ox,oy);
		  g.drawLine(ox2, 0, ox2, oy2);
		  
		  g.drawString("(0,0)", ox/2+5, oy+15);
		  g.drawOval(ox/2-3,oy-2, 5,5);
		  
		  
		  
		 //draws the ovals
		  	g.drawOval(this.x1, this.y1, 5, 5); //creates the oval for the first point

	}

	
	public class PanelListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();

				System.out.print(Integer.toString(e.getX())+ " , " + Integer.toString(e.getY()));
				repaint();
		}
	}
	

}
