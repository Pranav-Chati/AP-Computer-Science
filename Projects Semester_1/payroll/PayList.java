package payroll;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PayList extends JPanel{
	int selected = 0;
	JList<String> listEmps;
	
	public void getJList(String[] names) {
		listEmps = new JList<String>(names); //list of employee first names
		listEmps.setMaximumSize(new Dimension(400,500));
		listEmps.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //So that only one name can be selected
		listEmps.setSelectedIndex(0); //this selects James Smith(the first name)
		
		JScrollPane sP = new JScrollPane(listEmps); //creates the scroll bar
		listEmps.setLayoutOrientation(JList.VERTICAL);
	    sP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    this.add(sP);
	    }
	}
