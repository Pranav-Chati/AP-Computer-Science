package payroll;

import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PayInfo extends JPanel{
	int i =0;

	PayRollTester prt = new PayRollTester();
	JLabel lblName = new JLabel();
	JLabel lblID = new JLabel();
	JLabel lblHours = new JLabel();
	JLabel lblHW = new JLabel(); //hourly wage
	JLabel lblAge = new JLabel();
	JLabel lblND = new JLabel(); //number of dependents

	DefaultTableModel taxes; 
	JTable tblTax = new JTable(taxes);
	public void setName(String fname, String lname) {
		lblName.setText("Name: " + fname + " " + lname);
		this.add(lblName);
	}
	
	public void setID(int id) {
		lblID.setText("ID: " + Integer.toString(id));
		this.add(lblID);
	}
	
	public void setHoursWorked(int hw) {
		lblHours.setText("Hours Worked: " + Integer.toString(hw));
		this.add(lblHours);
	}
	
	public void setHourlyWage(double hw) {
		DecimalFormat df = new DecimalFormat("#.##");
		lblHW.setText("Hourly Wage: $" + df.format(hw));
		this.add(lblHW);
	}
	
	public void setAge(int age) {
		lblAge.setText("Age: " + Integer.toString(age));
		this.add(lblAge);
	}
	
	public void setDependents(int nd) {
		lblND.setText("Number of Dependents: " + Integer.toString(nd));
		this.add(lblND);
	}

	public void setTable(String[][] data, String[] columns) {
		
		taxes = new DefaultTableModel(data,columns);
		tblTax.setModel(taxes);
		if(i == 0) {
			this.add(tblTax);
			i++;
		} else {
			tblTax.repaint();
		}
	}
	
//	public void btnChecks() {
//		JButton btnCheck = new JButton("Check");
//		btnCheck.setSize(20, 20);
//		this.add(btnCheck);
//		
//		
//		btnCheck.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				System.out.println("Hello");
//			}
//		});
//	}
}
