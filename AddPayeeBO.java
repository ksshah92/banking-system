/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;

class AddPayeeBO extends JFrame implements ActionListener
{
	private JButton AddButton;
	private JTextField NameField, AddressField, PhoneNumberField;
    private String UsrName,CustoName;
	String PName, PAddress, PPhoneNumber;

	public AddPayeeBO(String UName, String CustomerName)
	{
		UsrName = UName;
		CustoName = CustomerName;

		setTitle("Add Payee");
		setSize(600, 300);

		 //get screen size and set the location of the frame
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setLocation( screenWidth / 3, screenHeight / 4);

		addWindowListener (new WindowAdapter()  //handle window event
		{
			public void windowClosing (WindowEvent e){
				//System.exit(0);
		    }
        });

		JLabel PNameLabel = new JLabel("Payee Name:");
		JLabel PAddressLabel = new JLabel("Payee Address:");
		JLabel PPhoneNumberLabel = new JLabel("Payee Phone Number: (XXX-XXX-XXXX)");

		NameField = new JTextField(25);
		AddressField = new JTextField(25);
		PhoneNumberField = new JTextField(25);

        AddButton = new JButton("Add");

        GridBagLayout Gridbg = new GridBagLayout();
		setLayout(Gridbg);
		GridBagConstraints gbc = new GridBagConstraints();

		// UsernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PNameLabel, gbc, 0, 0, 1, 1);

		// UsernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(NameField, gbc, 1, 0, 1, 1);

		// CusromernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PAddressLabel, gbc, 0, 1, 1, 1);

		// CusromernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AddressField, gbc, 1, 1, 1, 1);

		// FromAccountTypeLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PPhoneNumberLabel, gbc, 0, 2, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PhoneNumberField, gbc, 1, 2, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AddButton, gbc, 1, 3, 1, 1);

		AddButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
	    {

		    String arg = evt.getActionCommand();
		    PName= NameField.getText();
		   	PAddress= AddressField.getText();
			PPhoneNumber= PhoneNumberField.getText();


		    if (arg.equals("Add") && !PName.equals("") && !PAddress.equals("") && !PPhoneNumber.equals("") && (PPhoneNumber.length() == 12)) {

			   dispose();
			   PayeeControl pc = new PayeeControl(arg,PName,PAddress,PPhoneNumber,UsrName,CustoName);

		  }

		  else{
		  	JOptionPane.showMessageDialog(null, "1. Enter Payee Name.\n2. Enter Payee Address\n3.Enter Phone Number in 'XXX-XXX-XXXX' Format.", "Help", JOptionPane.INFORMATION_MESSAGE);
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


