/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: November, 2015														  *
*******************************************************************************/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;

class TransferBO extends JPanel implements ActionListener
{
	private JButton TransferButton;
	private JTextField BalanceField;
    private JComboBox CheckingOrSavingsBox,CheckingOrSavingsBox1 ;
    private String FromAccountType,TOAccountAccountType,Balance,UsrName,CustoName,FAccountNumber,TAccountnumber;

	public TransferBO(String UName, String CustomerName)
	{
        UsrName = UName;
        CustoName = CustomerName;

		CheckingOrSavingsBox = new JComboBox();
        CheckingOrSavingsBox.addItem("Select Acc.");
		CheckingOrSavingsBox.addItem("Checking");
		CheckingOrSavingsBox.addItem("Savings");

		CheckingOrSavingsBox1 = new JComboBox();
		CheckingOrSavingsBox1.addItem("Select Acc.");
		CheckingOrSavingsBox1.addItem("Checking");
		CheckingOrSavingsBox1.addItem("Savings");


        JLabel UsernameLabel = new JLabel("Username:");
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameField = new JLabel(UsrName);
		JLabel NameField = new JLabel(CustoName);
        JLabel AccountTypeLabel = new JLabel("From Account:");
        JLabel AccountTypeLabel1 = new JLabel("To Account:");
        JLabel BalanceLabel = new JLabel("Transfer Amount:");
        BalanceField = new JTextField(8);
        TransferButton = new JButton("Transfer");

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

		// FromAccountTypeLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountTypeLabel, gbc, 0, 2, 1, 1);

        // FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(CheckingOrSavingsBox, gbc, 1, 2, 1, 1);


        // ToAccountTypeLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(AccountTypeLabel1, gbc, 0, 3, 1, 1);

		// ToAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(CheckingOrSavingsBox1, gbc, 1, 3, 1, 1);


		// TransferBalanceLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(BalanceLabel, gbc, 0, 4, 1, 1);

		// TransferBalanceTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(BalanceField, gbc, 1, 4, 1, 1);

		// TransferBalanceButton
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(TransferButton, gbc, 1, 5, 1, 1);

		TransferButton.addActionListener(this);
        BalanceField.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
    {
	   String arg = evt.getActionCommand();
	   if (arg.equals("Transfer") || arg.equals(BalanceField.getText())) {
		   FromAccountType = (String)CheckingOrSavingsBox.getSelectedItem();
		   TOAccountAccountType = (String)CheckingOrSavingsBox1.getSelectedItem();
		   Balance = BalanceField.getText();

		   CheckingAccount ca = new CheckingAccount();
		   String ChekAccNum = ca.getCheckingAccountNum(UsrName);
		   Double InitChkBalance = ca.getBalance(ChekAccNum);
		   SavingAccount sa = new SavingAccount();
		   String SavAccNum = sa.getSavingsAccountNum(UsrName);
           Double InitSavBalance = sa.getBalance(SavAccNum);

		   if (FromAccountType.equals("Select Acc.") || TOAccountAccountType.equals("Select Acc.")  )
		     {  JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);  }

		   else if (FromAccountType.equals("Checking") && TOAccountAccountType.equals("Checking")  )
		     {  JOptionPane.showMessageDialog(null, "Please Choose Different Account Types!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);  }


		   else if (FromAccountType.equals("Savings") && TOAccountAccountType.equals("Savings")  )
		     {  JOptionPane.showMessageDialog(null, "Please Choose Different Account Types!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);  }

		   else if (Balance.equals(""))
		     {  JOptionPane.showMessageDialog(null, "Please Enter Amount!!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);  }

		   else if (Double.parseDouble(Balance) <= 0)
		   		     {  JOptionPane.showMessageDialog(null, "Please Enter The Positive Amount!!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);  }

		   else if(FromAccountType.equals("Checking") && TOAccountAccountType.equals("Savings")	 ){
			    	TransferControl tc = new TransferControl(FromAccountType,ChekAccNum,TOAccountAccountType,SavAccNum,Balance,CustoName,UsrName);
		   }

		   else if(FromAccountType.equals("Savings") && TOAccountAccountType.equals("Checking")  ){
		      		TransferControl ts = new TransferControl(FromAccountType,SavAccNum,TOAccountAccountType,ChekAccNum,Balance,CustoName,UsrName);
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