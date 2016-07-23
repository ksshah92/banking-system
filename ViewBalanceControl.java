/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.shah.banking.*;


public class ViewBalanceControl{

	public ViewBalanceControl(String Un, String AccountType){

		double checkingBalance = 0;
		double savingsBalance = 0;
		String ChekAccNum, SavAccNum;
		if(AccountType.equals("Checking")){
		 	CheckingAccount ca = new CheckingAccount();
			ChekAccNum = ca.getCheckingAccounttNum(Un);
			AccountNumberField.setText(ChekAccNum);
			CheckingAccount Check = new CheckingAccount(ChekAccNum);
			checkingBalance = Check.getBalance();
			String str1 = Double.toString(checkingBalance);
	  		if(checkingBalance == -1){
				JOptionPane.showMessageDialog(null, "Invalid Account Number", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				BalanceField.setText(str1);
			}
		}


	     else if(AccountType.equals("Savings")){
            SavingAccount sa = new SavingAccount();
            SavAccNum = sa.getSavingsAccounttNum(UserName);
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
            JOptionPane.showMessageDialog(null, "Please Enter an Account Number with Exactly 8 Characters!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}
