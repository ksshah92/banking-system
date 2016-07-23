/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: November, 2015													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.shah.banking.*;

class OpenBankAccountBO extends JPanel implements ActionListener
{
    private JButton OpenButton;
    private JTextField AccountNumberField, BalanceField;
    private JComboBox CheckingOrSavingsBox;
    private String UName, AccountNumber, Balance, Name, AccountType;
    private JLabel UsernameField, NameField;

    public OpenBankAccountBO(String UName, String CustomerName)
    {
        OpenButton = new JButton("Open"); //initializing two button references


        CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("Choose Account Type");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

        UsernameField = new JLabel(UName);
        NameField = new JLabel(CustomerName);
        AccountNumberField = new JTextField(15);
        BalanceField = new JTextField(15);

        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel AccountTypeLabel = new JLabel("Account Type:");
        JLabel NumberLabel = new JLabel("Account Number:(Must be 10 Digit)");
        JLabel BalanceLabel = new JLabel("Opening Deposit Amount ($):");

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

		// CheckingOrSavingBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountTypeLabel, gbc, 0, 2, 1, 1);

		// CheckingOrSavingBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(CheckingOrSavingsBox, gbc, 1, 2, 1, 1);

		// AccountNumberLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(NumberLabel, gbc, 0, 3, 1, 1);

		// AccountNumberTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountNumberField, gbc, 1, 3, 1, 1);

		// BalanceLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(BalanceLabel, gbc, 0, 4, 1, 1);

		// BalanceTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(BalanceField, gbc, 1, 4, 1, 1);

		// ViewBalanceButton
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(OpenButton, gbc, 1, 5, 1, 1);


        OpenButton.addActionListener(this); //event listener registration
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Open")) { //determine which button is clicked
            UName = UsernameField.getText(); //take actions
            Name = NameField.getText();
            AccountNumber = AccountNumberField.getText();
            Balance = BalanceField.getText();
            AccountType = (String)CheckingOrSavingsBox.getSelectedItem();
            if (AccountType.equals("Choose Account Type"))
                JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else if (AccountNumber.length() != 10 )
                     JOptionPane.showMessageDialog(null, "Please Enter an Account Number with Exactly 10 Characters!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            else {
					 OpenBankAccountControl OBAcct_Ctrl = new OpenBankAccountControl(AccountType, AccountNumber, Name, UName, Balance);
				 }

            //Acct = new Account(UName, PsWord, PsWord1, Name);
            //if (Acct.signUp())
                //JOptionPane.showMessageDialog(null, "Account has been open!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            //else
                //JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		}
    }


	public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		add(c, gbc);
	}


/*
    public static void main(String [] args)
    { JFrame frame = new OpenBankAccountBO("kaushal1992","Kaushal Shah"); //initialize a JFrame object
      frame.show(); //display the frame
    }
*/
}

