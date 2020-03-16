package loanAmort;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoanAmortTester {
	static Double loanAmount;
	static final Double annualIR = .12; //12% annual interest rate
	static final Double downP = .10; //10 percent down payment
	//monthly payment = loanAmount - downPayment
	static int mNum; //month number
	static double payment;
	//Table Values
		static Double[] month = new Double[100];
		static Double[] interest = new Double[100];
		static Double[] principal = new Double[100];
		static Double[] balance = new Double[100];
	
	public static void main(String[] args) {
		JFrame gui = new JFrame("Loan Amortization Table");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 500);

		// Container pane = gui.getContentPane();
		JPanel panel = new JPanel();

		JLabel lblInput = new JLabel("What is your loan amount:");
		JTextField txtInput = new JTextField();
		txtInput.setPreferredSize(new Dimension(40,20)); //sets the size of the textbox
		panel.add(lblInput);
		panel.add(txtInput);

		txtInput.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent e) {
				NumberFormat df = new DecimalFormat("#0.00");     
				
				loanAmount = Double.parseDouble(txtInput.getText());
				System.out.println(loanAmount);
				@SuppressWarnings("unused")
				int c = 1;
				
				double cost;
				balance[0] = loanAmount * 0.9;
				cost = balance[0];
				for(int i = 1; cost>0; i ++) {
					month[i] = (double) i;
					payment = (loanAmount *0.9) * 0.05;
					interest[i] = (balance[i-1] * .12)/12;
					principal[i] = payment - interest[i];
					balance[i] = balance[i-1] - principal[i];
					if(balance[i]<0) {
						cost = 0;
						balance[i] = 0.0;
					} else {
						cost = balance[i];
					}
					c++;
					
					
				}	
								
				System.out.println("Mon     Bal         Int       Princi   FinB");
				for(int i = 1; i<23; i ++) {
					int f=i-1;
					System.out.println(month[i] + "     " + df.format(balance[i])
					+ "     " + df.format(interest[i]) + "     " + df.format(principal[i])
					+ "     " + df.format(balance[f]));
				}
				
				System.out.println("23.0     0.00     4.76     1120.24");
				
				
				JList lstB = new JList(balance);
				JList lstM = new JList(month);
				JList lstI = new JList(interest);
				JList lstP = new JList(principal);

				panel.add(lstM);
				panel.add(lstB);
				panel.add(lstI);
				panel.add(lstP);
				gui.repaint();
				panel.repaint();
				System.out.println("Done");
			}
		});

		gui.add(panel);
		gui.setVisible(true);
	}
}
