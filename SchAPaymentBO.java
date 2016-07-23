/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


class SchAPaymentBO extends JFrame implements ActionListener
{
	private JButton SchButton;
	private JTextField NameField, AmountField, DateField;
    private String UsrName,CustoName;
	private String PName, Amount, SchDate, AccType;
	private JComboBox CheckingOrSavingsBox;

	public SchAPaymentBO(String UName, String CustomerName)
	{
		UsrName = UName;
		CustoName = CustomerName;

		setTitle("Schedule Payment");
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
		JLabel AmountLabel = new JLabel("Amount:");
		JLabel PDateLabel = new JLabel("Payment Date: (YYYYMMDD)");
		JLabel AccountTypeLabel = new JLabel("From Account:");

		CheckingOrSavingsBox = new JComboBox();
		CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");


		NameField = new JTextField(25);
		AmountField = new JTextField(25);
		DateField = new JTextField(25);

        SchButton = new JButton("Schedule");

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
		add(AmountLabel, gbc, 0, 1, 1, 1);

		// CusromernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AmountField, gbc, 1, 1, 1, 1);

		// FromAccountTypeLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PDateLabel, gbc, 0, 2, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(DateField, gbc, 1, 2, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountTypeLabel, gbc, 0, 3, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(CheckingOrSavingsBox, gbc, 1, 3, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(SchButton, gbc, 1, 4, 1, 1);

		SchButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
	    {

		    String arg = evt.getActionCommand();
		    PName= NameField.getText();
		    Amount= AmountField.getText();
		    SchDate= DateField.getText();
			AccType= (String)CheckingOrSavingsBox.getSelectedItem();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");   //get currentdate
			Date date = new Date();
			String SchD = dateFormat.format(date);

		    if (arg.equals("Schedule") && !PName.equals("") && !Amount.equals("") && !SchDate.equals("") && SchDate.length()== 8 && !AccType.equals("Choose Account Type") && Integer.parseInt(SchDate) >= Integer.parseInt(SchD)){

			   PName= NameField.getText();
			   Amount= AmountField.getText();
			   SchDate= DateField.getText();
			   AccType= (String)CheckingOrSavingsBox.getSelectedItem();
			   dispose();
			   PaymentControl pyc = new PaymentControl(arg,PName,Amount,SchDate,AccType,UsrName);

		  }
		  else{
		  	   JOptionPane.showMessageDialog(null, "Hint: 1. Date must be in 'yyyymmdd' format\n2. Payment Date must be start from today onwards.", "Help", JOptionPane.INFORMATION_MESSAGE);
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


