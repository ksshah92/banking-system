/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: October, 2015
*******************************************************************************/

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import com.shah.banking.*;


class ViewBalanceBO extends JPanel implements ActionListener
{
	private JButton ViewButton;
    private JComboBox CheckingOrSavingsBox;
    private JTextField AccountNumberField, BalanceField;
    private String UserName, AccountNumber, Balance, Name, AccountType;
    private double balance;

	public ViewBalanceBO(String UName, String CustomerName)
	{
		UserName = UName;

		ViewButton = new JButton("View Balance");
		CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel UsernameField = new JLabel(UserName);
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel NameField = new JLabel(CustomerName);
        JLabel AccountTypeLabel = new JLabel("Account Type: ");
		JLabel NumberLabel = new JLabel("Account Number:");
		AccountNumberField = new JTextField(15);
        JLabel BalanceLabel = new JLabel("Balance:");
        BalanceField = new JTextField(15);


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

		// AccountTypeLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountTypeLabel, gbc, 0, 2, 1, 1);

        // AccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(CheckingOrSavingsBox, gbc, 1, 2, 1, 1);

		// AccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(NumberLabel, gbc, 0, 3, 1, 1);

		// AccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountNumberField, gbc, 1, 3, 1, 1);

		// AccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(BalanceLabel, gbc, 0, 4, 1, 1);

		// AccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(BalanceField, gbc, 1, 4, 1, 1);

		// AccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(ViewButton, gbc, 1, 5, 1, 1);

		ViewButton.addActionListener(this);
 	}

	public void actionPerformed(ActionEvent evt)
	{
		double checkingBalance = 0;
		double savingsBalance = 0;
		String ChekAccNum, SavAccNum;
		String arg = evt.getActionCommand();
		if (arg.equals("View Balance")) {
			AccountType = (String)CheckingOrSavingsBox.getSelectedItem();

			   if(AccountType.equals("Checking")){
		 		CheckingAccount ca = new CheckingAccount();
				ChekAccNum = ca.getCheckingAccountNum(UserName);
				AccountNumberField.setText(ChekAccNum);
				CheckingAccount Check = new CheckingAccount(ChekAccNum);
				checkingBalance = Check.getBalance();
				String str1 = Double.toString(checkingBalance);
	  				if(checkingBalance == -1)
					   JOptionPane.showMessageDialog(null, "Invalid Account Number", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					else
					   BalanceField.setText(str1);
		  	}

	     else if(AccountType.equals("Savings")){
            SavingAccount sa = new SavingAccount();
            SavAccNum = sa.getSavingsAccountNum(UserName);
            AccountNumberField.setText(SavAccNum);
			SavingAccount sav = new SavingAccount(SavAccNum);
			savingsBalance = sav.getBalance();
			String str2 = Double.toString(savingsBalance);
				if(savingsBalance == -1)
				   JOptionPane.showMessageDialog(null, "Invalid Account Number", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				else
				  BalanceField.setText(str2);
		  }

		else if(AccountType.equals("Choose Account Type"))
            JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		else if (AccountNumber.length() != 8 )
            JOptionPane.showMessageDialog(null, "Please Enter an Account Number with Exactly 10 Characters!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
     }


}

	public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		add(c, gbc);
	}



}
