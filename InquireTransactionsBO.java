/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: November, 2015														  *
*******************************************************************************/

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.shah.banking.*;

class InquireTransactionsBO extends JPanel implements ActionListener
{
	private JButton InquireButton;
	private JTextField UsernameField, NameField, StartDateField, EndDateField;
	private String UserName, Name;

	public InquireTransactionsBO(String UName, String CustomerName)
	{
		UserName = UName;
	    Name = CustomerName;

		InquireButton = new JButton("Inquire");

		StartDateField = new JTextField(15);
		EndDateField = new JTextField(15);


		JLabel UsernameLabel = new JLabel("Username:");
		JLabel UsernameField = new JLabel(UserName);
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel NameField = new JLabel(Name);
        JLabel DateLabel = new JLabel("Start Date:(YYYYMMDD)");
        JLabel DateLabel1 = new JLabel("End Date:(YYYYMMDD)");

        // gridbaglayout
   		GridBagLayout Gridbg = new GridBagLayout();
   		setLayout(Gridbg);
   		GridBagConstraints gbc = new GridBagConstraints();

   		// UsernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(UsernameLabel, gbc, 0, 0, 1, 1);

		// UsernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(UsernameField, gbc, 1, 0, 1, 1);

		 // CusromernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(NameLabel, gbc, 0, 1, 1, 1);

		// CusromernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(NameField, gbc, 1, 1, 1, 1);

		// StartDateLabel
        gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(DateLabel, gbc, 0, 2, 1, 1);

		// StartdatetextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(StartDateField, gbc, 1, 2, 1, 1);

        // StartDateLabel
        gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(DateLabel1, gbc, 0, 3, 1, 1);

		// StartdatetextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(EndDateField, gbc, 1, 3, 1, 1);

		// TransferBalanceButton
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(InquireButton, gbc, 1, 4, 1, 1);

		InquireButton.addActionListener(this);   //event listener registration
	}

	public void actionPerformed(ActionEvent ae)  //event handling
	{
		String st_date = StartDateField.getText();
		String end_date = EndDateField.getText();

			InquireTransactionsControl itc = new InquireTransactionsControl(st_date,end_date,UserName,Name);
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
