package matrix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MatrixGUI {
	static JFrame gui = new JFrame("Matrix"); // JFrame created
	static JPanel panel = new JPanel();// JPanel for GUI
	static GridBagConstraints c = new GridBagConstraints(); // for the orientation of the GUI
	static JTable m1, m2; // input values into JTable to fill array
	static int r1, c1, r2, c2; // rows and columns for the JTable
	static int count = 0, count1 = 0; // counter for the number of clicks
	static int[][] matrix1, matrix2; // the array of 2 matrices
	static Integer[][] result; // this is for the result of the matrix operation
	static String[] columns; // created array, defined below
	static Matrix m; // Matrix object
	static DefaultTableModel mdlResults = new DefaultTableModel(2, 2); // model for matrix 1
	static JTable tblResults;// = new JTable(mdlResults);
	static int D = 0; // determinant
static int counter = 0;
	
	public static void main(String[] args) {
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(400, 300);
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.white);
		FirstMatrix();
		SecondMatrix();

		JButton create = new JButton("Create Matrices"); // the button that creates the matrices
		create.setSize(75, 40);
		c.gridx = 4;
		c.gridy = 3;
		panel.add(create, c);

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (count) {
				case 0:
					/*String s = JOptionPane.showInputDialog("How would you like to input your file??");
					
					switch (s) {
					case "manually":
						
						break;
					case "file":
						
						break;
					case "randomly":
						break;
					}*/
					
					create.setText("Finish Up");
					DefaultTableModel model1 = new DefaultTableModel(r1, c1); // model for matrix 1
					m1 = new JTable(model1); // matrix 1

					DefaultTableModel model2 = new DefaultTableModel(r2, c2); // model for matrix 2
					m2 = new JTable(model2);

					// create array of matrices
					matrix1 = new int[r1][c1];
					matrix2 = new int[r2][c2];

					c.gridx = 0;
					c.gridy = 4;
					c.fill = GridBagConstraints.BOTH;
					panel.add(m1, c);

					c.gridx = 4;
					c.gridy = 4;
					c.fill = GridBagConstraints.BOTH;
					panel.add(m2, c);
					count++;
					panel.repaint();
					gui.repaint();
					break;

				
				case 1:
					m = new Matrix(r1, c1, r2, c2); // instantiating the class with the given rows and columns for each
													// matrix
					create.setText("Clear"); // sets the JButton to clear
					for (int i = 0; i < r1; i++) {
						for (int k = 0; k < c1; k++) {
							// creation of the 2 matrices
							// System.out.println(m1.getModel().getValueAt(i, k));
							matrix1[i][k] = Integer.parseInt((String) m1.getModel().getValueAt(i, k));
						}
					}

					for (int i = 0; i < r2; i++) {
						for (int k = 0; k < c2; k++) {
							// creation of the 2 matrices
							matrix2[i][k] = Integer.parseInt((String) m2.getModel().getValueAt(i, k));
						}
					}

					for (int i = 0; i < r1; i++) {
						for (int k = 0; k < c1; k++) {
							m1.isCellEditable(i, k);
						}
					}
					
					
					for (int i = 0; i < r2; i++) {
						for (int k = 0; k < c2; k++) {
							m2.isCellEditable(i, k);
						}
					}

					
					count++;
					break;

				case 2:
					create.setText("Create Matrices");
					panel.remove(m1);
					panel.remove(m2);
					panel.repaint();
					count = 0;
					break;
				}

			}
		});

		// need to add all results to JPanel
		create.addKeyListener(new MatrixKey() {
			@Override
			public void keyPressed(KeyEvent e) {
				D = 0;
				System.out.println("KEY PRESSED");
				switch (e.getKeyCode()) {
				case 65: // when the letter a is pressed - ADDITION
					System.out.println("KEY PRESSED ADD");

					if (m.checkAddSub()) {
						columns = new String[c1]; // the column length stays the same
						for (int i = 0; i < c1; i++) {
							columns[i] = " ";
						}

						result = m.addMatrix(matrix1, matrix2); // adds matrices
						
						tblResults = new JTable(result, columns);
						
//						for (int i = 0; i < r1; i++) {
//							for (int j = 0; j < c1; j++) {
//								tblResults.setValueAt(result[i][j], i, j);
//							}
//						}
					} else { // if the matrices can not be added
						JOptionPane.showMessageDialog(gui, "Cannot Perform Addition");
						counter = 1;
						count1 = 1;
					}
					break;

				case 83: // when the letter s is pressed - SUBTRACTION
					System.out.println("KEY PRESSED SUBtract");

					if (m.checkAddSub()) {
						columns = new String[c1];// the column length stays the same
						for (int i = 0; i < c1; i++) {
							columns[i] = " ";
						}

						result = m.subMatrix(matrix1, matrix2); // adds matrices

						for (int i = 0; i < r1; i++) {
							for (int j = 0; j < c1; j++) {
								tblResults.setValueAt(result[i][j], i, j);
							}
						}

					} else { // if the matrices can not be added
						JOptionPane.showMessageDialog(gui, "Cannot Perform Subtraction");
					}
					break;

				case 77: // when the letter "m" is pressed - MULTIPLICATION
					columns = new String[c2];
					for (int i = 0; i < c2; i++) {
						columns[i] = " ";
					}
					if (m.checkMultiplication()) {

						result = m.multMatrix(matrix1, matrix2);
						
						if(counter == 1) {
							tblResults = new JTable(result, columns);
							count1 = 0;
						}
						else
						{
							for (int i = 0; i < r1; i++) {
							for (int j = 0; j < c2; j++) {
								tblResults.setValueAt(result[i][j], i, j);
								}
							}
						}
						
					} else
						JOptionPane.showMessageDialog(gui, "Cannot Perform Multiplication");
					break;

				case 84: // when the letter "t" is pressed - TRANSPOSE
					int z = Integer.parseInt(
							JOptionPane.showInputDialog("On which matrix would you like to perform this operation?"));
					switch (z) {
					case 1:// first matrix picked
							// columns change
						columns = new String[r1];
						for (int i = 0; i < r1; i++) {
							columns[i] = " ";
						}
						result = m.transposeMatrix(matrix1, r1, c1);

						for (int i = 0; i < c1; i++) {
							for (int j = 0; j < r1; j++) {
								tblResults.setValueAt(result[i][j], i, j);
							}
						}
						break;
					case 2: // second matrix picked
						// columns change
						columns = new String[r2];
						for (int i = 0; i < r2; i++) {
							columns[i] = " ";
						}
						result = m.transposeMatrix(matrix2, r2, c2);

						for (int i = 0; i < c2; i++) {
							for (int j = 0; j < r2; j++) {
								tblResults.setValueAt(result[i][j], i, j);
							}
						}
						break;
					}

					break;

				case 67: // when the letter "c" is pressed - SCALAR
					String s = JOptionPane.showInputDialog("What type of Scalar Operation would you like to perform?");
					int n = Integer.parseInt(
							JOptionPane.showInputDialog("On which matrix would you like to perform this operation?"));
					int num = Integer.parseInt(JOptionPane.showInputDialog("What is the scalar number?"));

					switch (n) {
					case 1: // matrix 1
						columns = new String[c1];
						for (int i = 0; i < c1; i++) {
							columns[i] = " ";
						}

						switch (s) {
						case "a": // scalar addition
							result = m.scalarAdd(matrix1, num, r1, c1);
							break;

						case "s": // scalar subtraction
							result = m.scalarSub(matrix1, num, r1, c1);
							break;

						case "m": // scalar multiplication
							result = m.scalarMult(matrix1, num, r1, c1);
							break;
						}
						for (int i = 0; i < r1; i++) {
							for (int j = 0; j < c1; j++) {
								tblResults.setValueAt(result[i][j], i, j);
							}
						}
						break;

					case 2: // matrix 2
						columns = new String[c2];
						for (int i = 0; i < c2; i++) {
							columns[i] = " ";
						}

						switch (s) {
						case "a": // scalar addition
							result = m.scalarAdd(matrix2, num, r2, c2);
							break;

						case "s": // scalar subtraction
							result = m.scalarSub(matrix2, num, r2, c2);
							break;

						case "m": // scalar multiplication
							result = m.scalarMult(matrix2, num, r2, c2);
							break;
						}
						for (int i = 0; i < r2; i++) {
							for (int j = 0; j < c2; j++) {
								tblResults.setValueAt(result[i][j], i, j);
							}
						}
						break;
					}
					break;

				case 68: // when the letter "d" is pressed - DETERMINANT
					int j = Integer.parseInt(
							JOptionPane.showInputDialog("On which matrix would you like to perform this operation?"));
					switch (j) {
					case 1:
						D = m.determinantMatrix(matrix1);
						break;

					case 2:
						D = m.determinantMatrix(matrix2);
						break;
					}

					JOptionPane.showMessageDialog(gui, "Determinant for Matrix " + j + ": " + D);
					break;

				case 73: // when the letter "i" is pressed - INVERSE or DIVISION

					break;
				} // end of bigass switch

				if (count1 == 0) {
					c.gridx = 2;
					c.gridy = 6;
					panel.add(tblResults, c);
					count1++;
				}

				tblResults.repaint();
				panel.repaint();
				gui.repaint();

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		gui.add(panel);
		gui.setVisible(true);
		gui.setResizable(true);
	}

	public static void FirstMatrix() {
		// JLABEL for First Entry of Matrix
		JLabel lblHeader = new JLabel("FIRST MATRIX"); // header for the first matrix
		JLabel lblRow = new JLabel("Rows:"); // row label box for the first matrix
		JLabel lblCol = new JLabel("Columns:");
		JTextField txtRow = new JTextField("");
		JTextField txtCol = new JTextField("");
		lblRow.setPreferredSize(new Dimension(50, 20));
		lblCol.setPreferredSize(new Dimension(60, 20));
		txtRow.setPreferredSize(new Dimension(50, 20));
		txtCol.setPreferredSize(new Dimension(50, 20));

		// adding the first matrix to the JPanel\
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblHeader, c);

		c.gridy = 1;
		panel.add(lblRow, c);

		c.gridx = 1;
		panel.add(txtRow, c);

		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblCol, c);

		c.gridx = 1;
		panel.add(txtCol, c);

		// Adding a TextField Listener
		txtRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1 = Integer.parseInt(txtRow.getText());
				System.out.println(r1);
			}
		});

		txtCol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1 = Integer.parseInt(txtCol.getText());
				System.out.println(c1);
			}
		});
	}

	public static void SecondMatrix() {
		// JLABEL for Second Entry of Matrix
		JLabel lblHeader = new JLabel("SECOND MATRIX"); // header for the first matrix
		JLabel lblRow = new JLabel("Rows:"); // row label box for the first matrix
		JLabel lblCol = new JLabel("Columns:");
		JTextField txtRow = new JTextField("");
		JTextField txtCol = new JTextField("");
		lblRow.setPreferredSize(new Dimension(50, 20));
		lblCol.setPreferredSize(new Dimension(60, 20));
		txtRow.setPreferredSize(new Dimension(50, 20));
		txtCol.setPreferredSize(new Dimension(50, 20));

		// adding the first matrix to the JPanel
		c.weightx = 0.2;

		c.gridx = 3;
		c.gridy = 0;
		panel.add(lblHeader, c);

		c.gridx = 3;
		c.gridy = 1;
		panel.add(lblRow, c);

		c.gridx = 4;
		panel.add(txtRow, c);

		c.gridx = 3;
		c.gridy = 2;
		panel.add(lblCol, c);

		c.gridx = 4;
		panel.add(txtCol, c);

		// Actipon Listener
		txtRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r2 = Integer.parseInt(txtRow.getText());
				System.out.println(r2);

			}
		});

		txtCol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c2 = Integer.parseInt(txtCol.getText());
				System.out.println(c2);
			}
		});
	}
}