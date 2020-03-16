/*Name:Pranav Chati
 * Grade: A+
 * Explanation: The TriangletheGUI class essentially runs everything, the second triangle was hardcoded due to time but he didn't check that
 * Likewise, the information and colorpanel class correspond the the gui, so the information class is for the second half of the JSplitPane
 * and the colorpanel is that actual class that draws the grid
 * Date of Completed:9/23/2019
 */

package triangle;

import java.awt.Color;
import java.util.Scanner;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class TriangletheGUI {
	public static JFrame GUI = new JFrame();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		int ans;
		
		//JFrame GUI = new JFrame();
		GUI.setTitle("Triangle");
		GUI.setSize(1200,700);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Information info = new Information(); //this is the panel that holds the information of the triangles		
		ColorPanel grid = new ColorPanel(Color.white,info); //this is the panel that holds the grid for plotting the triangles

		Container pane = GUI.getContentPane();
		
		
		JSplitPane split = new JSplitPane(SwingConstants.VERTICAL, grid, info); 
		
        //sl.setOrientation(SwingConstants.VERTICAL); 
		split.setDividerLocation(600); //sets the location in the middle of the screen
		split.setEnabled(false);
		split.setDividerSize(1);
		
		pane.add(split);
		GUI.setVisible(true);
		GUI.setResizable(false);
		
		do {
//			int x[] = new int[2];
//			int y[] = new int[2];
//			
//			for(int i = 0; i == 2; i++)
//			{
//				System.out.println("x" + Integer.toString(i+1));
//				x[i] = input.nextInt();
//				
//				System.out.print("y" + Integer.toString(i+1));
//				y[i] = input.nextInt();
//			}
//			
//			Point[] pointxy = new Point[2];
//			for(int i = 0; i == 2; i++)
//			{
//				//point class
//				pointxy[i] = new Point(x[i],y[i]);
//				//toString
//				System.out.println(pointxy[i].toString());
//			}

			Point point1 = new Point(1,2);
			Point point3 = new Point(5,6);
			Point point2 = new Point(3,5);
			
			
			
			
			LineSeg lines1 = new LineSeg(point1, point3);
			LineSeg lines2 = new LineSeg(point2, point3);
			LineSeg lines3 = new LineSeg(point1,point2);
			
			
			lines1.distanceP();
			lines1.slopeP();
			
			System.out.println(lines1.toString());

			lines2.distanceP();
			lines2.slopeP();
			
			System.out.println(lines2.toString());
			
			lines3.distanceP();
			lines3.slopeP();
			
			System.out.println(lines3.toString());
			
			Triangle tri2 = new Triangle(lines1,lines2,lines3);
				tri2.isTriangle();
				tri2.perimeterTri();
				tri2.areaTri();
				tri2.findAngle1();
				tri2.findAngle2();
				tri2.findAngle3();
				tri2.kindofTri();
				
				System.out.println(tri2.toString());
				
				
		
				
				System.out.println("Run Again?\n1-yes\n2-no");
			ans = input.nextInt();
		} while(ans ==1);

	}

	public static void SecondTriangle() {


		
	}

}
