package triangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Information extends JPanel{
	
	Information(){
		
	}
	
	//displays the area of the triangle
	JLabel lblArea = new JLabel("Area:");
	public void displayAreaInfo(int area) {
		lblArea.setText("Area: " + Integer.toString(area));
		lblArea.setSize(40, 40);
		this.add(lblArea);
		lblArea.setVisible(true);
	}
	
	//displays the perimeter of the triangle
	JLabel lblPerimeter = new JLabel("Area:");
	public void displayPerimeter(int perimeter) {
		lblPerimeter.setText("Perimeter: " + Integer.toString(perimeter));
		lblPerimeter.setSize(40, 40);
		this.add(lblPerimeter);
		lblPerimeter.setVisible(true);
	}
	
	//this displays the kind of triangle it is
	JLabel lblKindofTri = new JLabel("Kind of Triangle");
	public void displayKindofTri(String kind) {
		lblKindofTri.setText("Kind of Triangle: " + kind);
		lblKindofTri.setSize(40, 40);
		this.add(lblKindofTri);
		lblKindofTri.setVisible(true);
	}
	
	//displays the 3 individual points
	JLabel lblPoint1 = new JLabel("Point 1:");
	JLabel lblPoint2 = new JLabel("Point 2:");
	JLabel lblPoint3 = new JLabel("Point 3:");
	public void displayPoints(int x1, int x2, int x3, int y1, int y2, int y3) {
		lblPoint1.setText("Point 1: ( " + x1 + " , " + y1 +" )");
		lblPoint1.setSize(40, 40);
		this.add(lblPoint1);
		lblPoint1.setVisible(true);
		
		lblPoint2.setText("Point 2: ( " + x2 + " , " + y2 +" )");
		lblPoint2.setSize(40, 40);
		this.add(lblPoint2);
		lblPoint2.setVisible(true);
	
		lblPoint3.setText("Point 3: ( " + x3 + " , " + y3 +" )");
		lblPoint3.setSize(40, 40);
		this.add(lblPoint3);
		lblPoint3.setVisible(true);
	}
	
	//displays the distances of the point
	JLabel lblDistance1 = new JLabel("\nDistance of Line 1:");
	JLabel lblDistance2 = new JLabel("Distance of Line 2:");
	JLabel lblDistance3 = new JLabel("Distance of Line 3:");
	public void displayDistance(double distance1, double distance2, double distance3) {
		lblDistance1.setText("Distance of Line 1: " +Double.toString(distance1));
		lblDistance1.setSize(40, 40);
		this.add(lblDistance1);
		lblDistance1.setVisible(true);
		
		lblDistance2.setText("Distance of Line 2: " +Double.toString(distance2));
		lblDistance2.setSize(40, 40);
		this.add(lblDistance2);
		lblDistance2.setVisible(true);
	
		lblDistance3.setText("Distance of Line 3: " + Double.toString(distance3));
		lblDistance3.setSize(40, 40);
		this.add(lblDistance3);
		lblDistance3.setVisible(true);
	}
	
	//displays the slope of the lines
	JLabel lblSlope1 = new JLabel("Slope of Line 1:");
	JLabel lblSlope2 = new JLabel("Slope of Line 2:");
	JLabel lblSlope3 = new JLabel("Slope of Line 3:");
	public void displaySlope(double slope1, double slope2, double slope3) {
		lblSlope1.setText("Slope of Line 1: " + Double.toString(slope1));
		lblSlope1.setSize(40, 40);
		this.add(lblSlope1);
		lblSlope1.setVisible(true);
		
		lblSlope2.setText("Slope of Line 2: " + Double.toString(slope2));
		lblSlope2.setSize(40, 40);
		this.add(lblSlope2);
		lblSlope2.setVisible(true);
	
		lblSlope3.setText("Slope of Line 3: " + Double.toString(slope3));
		lblSlope3.setSize(40, 40);
		this.add(lblSlope3);
		lblSlope3.setVisible(true);
	}
	
	
	
	//displays the angles that are formed by the lines, uses the law of cosines to find this info
	JLabel lblAngle1 = new JLabel("Angle 1:");
	JLabel lblAngle2 = new JLabel("Angle 2:");
	JLabel lblAngle3 = new JLabel("Angle 3:");
	public void displayAngles(double angle1, double angle2, double angle3) {
		lblAngle1.setText("Angle 1: " + Double.toString(angle1));
		lblAngle1.setSize(40, 40);
		this.add(lblAngle1);
		lblAngle1.setVisible(true);
		
		lblAngle2.setText("Angle 2: " + Double.toString(angle2));
		lblAngle2.setSize(40, 40);
		this.add(lblAngle2);
		lblAngle2.setVisible(true);
	
		lblAngle3.setText("Angle 3: " + Double.toString(angle3));
		lblAngle3.setSize(40, 40);
		this.add(lblAngle3);
		lblAngle3.setVisible(true);
	}
	
	
}
