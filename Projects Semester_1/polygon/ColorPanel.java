/*By:Pranav Chati
 * Grade: 
 * Date: 
 */

package polygon;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ColorPanel extends JPanel {
	
	static Information info = new Information();		
	//starting points
	static int ox;
	static int oy;
	static int ox2;
	static int oy2;
	
	
	//selection
	static int selection = info.AmountSelection();
	static ArrayList<Point> pts = new ArrayList<>();
	static LineSeg[] lines = new LineSeg[selection];
	ArrayList<String> points = new ArrayList<>();		
	static Polygon poly;
	
	static int j = 0;
	static boolean end = false;
	static boolean run = true;
	static int counter = 0;
	
	
	public ColorPanel(Color backColor, Information info) {
		setBackground(backColor);
		addMouseListener(new PanelListener());
		setInfo(info);
		for(int i  = 0; i < selection; i ++) {
			pts.add(new Point());
			
		}	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		  ox = getWidth();
		  oy = getHeight()/2;
		  ox2 = getWidth()/2;
		  oy2 = getHeight();
		   
		  g.setColor(Color.black);
		  
		  g.drawLine(0,oy,ox,oy);
		  g.drawLine(ox2, 0, ox2, oy2);
		  		
		  //drawPoints
			  for(int i =0; i< selection; i ++) {
				g.fillOval(pts.get(i).myx,pts.get(i).myy , 5,5);
			  }
		  
		  //drawLines
			  for(int i = 0; i < pts.size()-1; i++) {
				  g.drawLine(pts.get(i).myx, pts.get(i).myy, pts.get(i+1).myx ,pts.get(i+1).myy);
			  }
			  if(pts.size() != 0) {
				  g.drawLine(pts.get(0).myx, pts.get(0).myy, pts.get(pts.size()-1).myx, pts.get(pts.size()-1).myy);
			  }

		  repaint();
	}
	
	
	public class PanelListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {	

			counter = j;
			int iteration = counter % selection;
			while(iteration < selection){	
				pts.get(iteration).myx = e.getX();
				pts.get(iteration).myy = e.getY();
				j++;
				break;
			}
			
			for(int i = 0; i < selection; i++) {
				System.out.println("Selection # " + i + " " + pts.get(i).toString());
			}
			System.out.println("");
			
			
			 if((pts.get(pts.size()-1).myx != 0) && (pts.get(pts.size()-1).myy != 0)) {
				 //adding points to the line segment class
					 for(int i = 0; i < pts.size()-1; i++) {
						 lines[i] = new LineSeg(pts.get(i), pts.get(i+1));
					 }
					 lines[pts.size()-1] = new LineSeg(pts.get(0), pts.get(pts.size()-1));
						
				 //creating the polygon
					 poly = new Polygon(lines,selection);
					 if(poly.doIntersect(pts.get(0), pts.get(1), pts.get(2), pts.get(3))) {
						 //for the intersection
						 JOptionPane.showMessageDialog(null, "This is not a polygon", "Not a Polygon", JOptionPane.ERROR_MESSAGE);
						 
						 end = true;
					 } else {
						//SWING RELATED STUFF
						if(run) {
							 info.intialize(pts);
							 run = false;
						 }
						 info.displayPolygon(poly, findArea(pts));
						 info.displayLineInfo(lines);
						 info.displayPoints(pts); 
					 }//end of else
					 
					 if(end) {
						 PolygontheGUI g = new PolygontheGUI();
						 g.enditAll();
					 }
					 
					 repaint();
			 } //end of the if statement
		
		}
	}
	
	
	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}
	
	public double findArea(ArrayList<Point> p) {
		Double area = 0.0;
		for(int i = 0; i < p.size() - 1; i++) {
			//shoelace method
			area += Math.abs((p.get(i).myx * p.get(i+1).myx) - (p.get(i).myy * p.get(i+1).myx));
		}
		area += Math.abs((p.get(p.size()-1).myx * p.get(0).myx) - (p.get(p.size()-1).myy * p.get(0).myx));
		
		
		return area;
	}
}
