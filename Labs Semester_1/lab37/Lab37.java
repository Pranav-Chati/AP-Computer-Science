/*By:Pranav Chati
 * Purpose:lab 3.7- draw a x-axis and y-axis
 * 	Grade: 14/10
 */
package lab37;

import javax.swing.*;

import lab37.ColorPanel;

import java.awt.*;


public class Lab37 {
	public static void main(String[] args)
	{
		JFrame GUI = new JFrame();
		GUI.setTitle("3.7 Lab");
		GUI.setSize(200,200);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel panel = new ColorPanel(Color.white);
		
		Container pane = GUI.getContentPane();
		pane.add(panel);
		GUI.setVisible(true);
		GUI.setResizable(true);
	}
}
	