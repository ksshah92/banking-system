/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import com.shah.banking.*;

class PayeePanel extends JPanel implements ActionListener
{
	private JButton AddButton, EditButton, DelButton, ViewButton;
	private String UsrName,CustoName;
	private String PName, PAddress, PPhoneNumber;
	Vector vect = new Vector();

	public PayeePanel(String UName, String CustomerName)
	{
		UsrName = UName;
		CustoName = CustomerName;

		AddButton = new JButton("Add Payee");
		EditButton = new JButton("Edit Payee");
		DelButton = new JButton("Delete Payee");
		ViewButton = new JButton("View Payees");

		GridBagLayout Gridbg = new GridBagLayout();
		setLayout(Gridbg);
		GridBagConstraints gbc = new GridBagConstraints();

		// UsernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AddButton, gbc, 0, 0, 1, 1);

		// UsernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(EditButton, gbc, 1, 0, 1, 1);

		// CusromernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(DelButton, gbc, 0, 1, 1, 1);

		// CusromernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(ViewButton, gbc, 1, 1, 1, 1);

		AddButton.addActionListener(this);
		EditButton.addActionListener(this);
		DelButton.addActionListener(this);
		ViewButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
		    {
				String arg = evt.getActionCommand();
				if (arg.equals("Add Payee")) {
					AddPayeeBO ap = new AddPayeeBO(UsrName, CustoName);
					ap.show();
			  	}

			  	else if(arg.equals("Edit Payee")){

					EditPayeeBO ep = new EditPayeeBO(UsrName, CustoName);
					ep.show();
				  }

				else if(arg.equals("Delete Payee")){

					DeleteAPayeeBO dp = new DeleteAPayeeBO(UsrName, CustoName);
					dp.show();
	  			}

	  			else if(arg.equals("View Payees")){

					Payee py = new Payee(UsrName);
					vect = py.viewPayees(UsrName);

					Vector<String> v = new Vector<String>(3);
					v.add(0,"Payee Name");
					v.add(1,"Payee Address");
					v.add(2,"Payee Phone Number");


		   			PayeesList sit = new PayeesList(vect,v);

	  			}
			}

			public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
				       {
					    gbc.gridx = x;
					    gbc.gridy = y;
					    gbc.gridwidth = w;
					    gbc.gridheight = h;
					    add(c, gbc);
	    }

	}



