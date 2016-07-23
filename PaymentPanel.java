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

class PaymentPanel extends JPanel implements ActionListener
{
	private JButton SchButton, VEDButton, DelButton;
	private String UsrName,CustoName;
	private String PName, PAddress, PPhoneNumber;
	private Vector vect = new Vector();

	public PaymentPanel(String UName, String CustomerName)
	{
		UsrName = UName;
		CustoName = CustomerName;

		SchButton = new JButton("Schedule Payment");
		VEDButton = new JButton("View/Edit/Delete Scheduled Payment");
		DelButton = new JButton("Deliver Scheduled Payment");

		GridBagLayout Gridbg = new GridBagLayout();
		setLayout(Gridbg);
		GridBagConstraints gbc = new GridBagConstraints();

		// UsernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(SchButton, gbc, 0, 0, 1, 1);

		// UsernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(VEDButton, gbc, 0, 1, 1, 1);

		// CusromernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(DelButton, gbc, 0, 2, 1, 1);

		SchButton.addActionListener(this);
		VEDButton.addActionListener(this);
		DelButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
		    {
				String arg = evt.getActionCommand();
				if (arg.equals("Schedule Payment")) {
					SchAPaymentBO sp = new SchAPaymentBO(UsrName, CustoName);
					sp.show();
			  	}



				else if(arg.equals("View/Edit/Delete Scheduled Payment")){


					VEDPaymentBO dp = new VEDPaymentBO(UsrName, CustoName);
					dp.show();
	  			}

	  			else if(arg.equals("Deliver Scheduled Payment")){
					Payment py = new Payment(UsrName);
					if(py.delSchPay()){

						JOptionPane.showMessageDialog(null, "Payment Delivered Successfully!.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "There is no payment Scheduled today.", "Info", JOptionPane.INFORMATION_MESSAGE);
					}

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



