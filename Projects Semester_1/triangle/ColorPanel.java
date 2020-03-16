/*By:Pranav Chati
 * Grade: 
 * Date: 
 */

package triangle;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ColorPanel extends JPanel {
	
	Information info = new Information();


	static int area;
	static int perimeter;
	static String kind;
	static double distance1, distance2, distance3;
	static double slope1,slope2,slope3;
	static double angle1, angle2, angle3;
	
	static int x;
	static int y;
	
	//this is for the counter
	static int x1;
	static int x2;
	static int x3;
	
	static int y1;
	static int y2;
	static int y3;
	
	 static int ox;
	 static int oy;
	 static int ox2 ;
	 static int oy2;
	
	//static int check = 0;
	
	static int counter = 0;
	
	
	public ColorPanel(Color backColor, Information info) {
		setBackground(backColor);
		addMouseListener(new PanelListener());
		setInfo(info);
		
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
		  
		  //g.drawString("(0,0)", ox/2+5, oy+15);
		  //g.drawOval(ox/2-3,oy-2, 5,5); the center of the line
		  
		  
		  
		 //draws the ovals
		  	g.drawOval(this.x1, this.y1, 5, 5); //creates the oval for the first point
			g.drawOval(this.x2, this.y2, 5, 5); //creates the oval for the second point 
			g.drawOval(this.x3, this.y3, 5, 5); //creates the oval for the third point
		
		//connected the points
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x2, y2, x3, y3);
			g.drawLine(x1, y1, x3, y3);

	}

	
	public class PanelListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(counter%3 == 0) {
				x1 = e.getX();
				y1 = e.getY();
			}
			else if (counter %3 == 1) {
				x2 = e.getX();
				y2 = e.getY();
			}
			else if (counter %3 == 2) {
				x3 =e.getX();
				y3 = e.getY();
			}
			counter ++;
			
			//add a counter for the mouseclick
			Point first = new Point((x1-300),y1-340);
			Point second = new Point(x2-300,y2-340);
			Point third = new Point(x3-300,y3-340);
			//System.out.println(first.toString());
			
			//creates line seg class
			LineSeg line1 = new LineSeg(first, second);
			line1.distanceP();
			line1.slopeP();
			
			//second line
			LineSeg line2 = new LineSeg(second, third);
			line2.distanceP();
			line2.slopeP();
			
			//third line
			LineSeg line3 = new LineSeg(first, third);
			line3.distanceP();
			line3.slopeP();
			
			
			//triangle
			Triangle tri1 = new Triangle(line1, line2, line3);
			tri1.areaTri();
			tri1.perimeterTri();
			tri1.isTriangle();
			tri1.kindofTri();
			tri1.findAngle1();
			tri1.findAngle2();
			tri1.findAngle3();
			
			
			
			//output in console
//				System.out.println(first.toString());
//				System.out.println(second.toString());
//				System.out.println(third.toString());
//				System.out.println(line1.toString());
//				System.out.println(line2.toString());
//				System.out.println(line3.toString());
//				System.out.println(tri1.toString());
			
			//output it to the swing
				//area
				area = (int)tri1.area;
				info.displayAreaInfo(area);
				
				//perimeter
				perimeter = (int)tri1.P;
				info.displayPerimeter(perimeter);
				
				kind = tri1.kindofTri();
				info.displayKindofTri(kind);
				
				info.displayPoints((x1-300),(x2-300), (x3-300), (y1-340), (y2-340), (y3-340));
				
				distance1 =line1.distance;
				distance2 = line2.distance;
				distance3 = line3.distance;
				info.displayDistance(distance1,distance2,distance3);
				
				//sends the data for the displayment onto the GUI for slope of the lines
				slope1 = line1.slope;
				slope2 = line2.slope;
				slope3 = line3.slope;
				info.displaySlope(slope1,slope2,slope3);
	
				angle1 = tri1.angle1;
				angle2 = tri1.angle2;
				angle3 = tri1.angle3;
				info.displayAngles(angle1, angle2, angle3);
				
				repaint();
		}
	}
	
	
	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}


}
