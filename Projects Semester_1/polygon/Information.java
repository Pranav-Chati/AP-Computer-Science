package polygon;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Information extends JPanel{
	static int selection;
	static int counter;
	static int j = 0;
	JLabel[] lblPoints;
	JLabel[] lblSlope;
	JLabel[] lblDistance;
	DefaultListModel<ArrayList<String>> listModel = new DefaultListModel();

	JList lstp = new JList(listModel);
	JLabel lblKind = new JLabel("Polygon Type: ");
	JLabel lblPerimeter = new JLabel("Perimeter: ");
	JLabel lblArea = new JLabel("Area:");

	Information(){
		
	}
	
	public int AmountSelection() {
		if(counter == 0) {
		selection = Integer.parseInt(JOptionPane.showInputDialog("How many lines would you like to draw?"));
		counter++;
		}		
	
		return selection;
	}
	
	//displays the polygon info
	public void displayPolygon(Polygon p, double area) {
		//outputs polygon type
			lblKind.setText("Polygon Type: " + p.kindofPolygon());
			lblKind.setSize(40, 40);
			this.add(lblKind);
			lblKind.setVisible(true);
		
		//outputs perimeter
			lblPerimeter.setText("Perimeter: " + Double.toString(p.periPolygon()));
			lblPerimeter.setSize(40, 40);
			this.add(lblPerimeter);
			lblPerimeter.setVisible(true);
		
		//outputs area
			lblArea.setText("Area: " + Double.toString(area));
			lblArea.setSize(40, 40);
			this.add(lblArea);
			lblArea.setVisible(true);
	}
	
	//initializes certain arrays so they arent created over and over again
	public void intialize(ArrayList<Point> p) {
		lblPoints = new JLabel[selection];
		
		for(int i =0; i < selection; i++) {
			lblPoints[i] = new JLabel("Point "); 
		}	
		
		lblSlope = new JLabel[selection];
		lblDistance = new JLabel[selection];

		for(int i =0; i <selection; i++) {
			lblSlope[i] = new JLabel("Slope "); 
			lblDistance[i] = new JLabel("Distance ");
		}		
	}
	
	
		//this displays all the points
	public void displayPoints(ArrayList<Point> p) {
		for(int i =0; i < p.size()-1; i++) {
			lblPoints[i].setText("Point "+ Integer.toString(1+i) + ": ( " + p.get(i).myx + " , " + p.get(i).myy +" )");
			lblPoints[i].setSize(40, 40);
			this.add(lblPoints[i]);
			lblPoints[i].setVisible(true);
		}
	}
	
	//displays the distances and slopes of the point
	public void displayLineInfo(LineSeg[] l) {
		for(int i = 0; i < selection; i ++) {
			lblDistance[i].setText("Distance of Line " + Integer.toString(1+i) +": " + Double.toString(l[i].distanceP()));
			lblDistance[i].setSize(40, 40);
			lblDistance[i].setVisible(true);
			
			lblSlope[i].setText("Slope of Line " + Integer.toString(1+i) +": " + Double.toString(l[i].slopeP()));
			lblSlope[i].setSize(40, 40);
			lblSlope[i].setVisible(true);
			this.add(lblDistance[i]);
			this.add(lblSlope[i]);
		}
	}

}
