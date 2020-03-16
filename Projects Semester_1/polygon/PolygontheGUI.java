/*Name:Pranav Chati
 * Grade: A++
 * Explanation: The PolygontheGUI class essentially runs everything
 * In this project, the ec included: arraylist, button, polytester, more methods(perimeter and everything else)
 * Likewise, the information and colorpanel class correspond the the gui, so the information class is for the second half of the JSplitPane
 * and the colorpanel is that actual class that draws the grid
 * Date of Completed:10/23/2019
 */

package polygon;

import java.awt.Color;
import java.util.Scanner;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class PolygontheGUI {
	public static JFrame GUI = new JFrame();
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{		
		//JFrame GUI = new JFrame();
		GUI.setTitle("Polygon");
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
	}
	
	public void enditAll() {
		System.exit(0); // stop program
		GUI.dispose(); // close window
		GUI.setVisible(false); // hide window
	}

}
