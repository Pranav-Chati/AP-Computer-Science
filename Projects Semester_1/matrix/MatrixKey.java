package matrix;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MatrixKey implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KEY PRESSED");
		switch (e.getKeyCode()) {
		case 97:
			System.out.println("Hello");
			/*
			 * if(m.CheckAddSubt()) { columns = new String[c1]; for(int i = 0; i <c1; i ++)
			 * { columns[i] = " "; }
			 * 
			 * result = m.AddMatrix(matrix1,matrix2); //adds matrices JTable tblResult = new
			 * JTable(result,columns);
			 * 
			 * } else { //if the matrices can not be added
			 * JOptionPane.showMessageDialog(gui, "Cannot Perform Addition"); } break;
			 */
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}
}
