/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: November, 2015														  *
*******************************************************************************/



import java.lang.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import com.shah.banking.*;

public class TransferControl
{
   public TransferControl(String FRAccountType, String  FRAccountNumber, String TOAccountType, String  TOAccountNumber,String  Balance ,String  Name, String  UName) //constructor with seven paramenters
    {
	    String cosn = FRAccountNumber;
	    String socn = TOAccountNumber;
	    double b2 = -1;


		if (FRAccountType.equals("Checking")) {
			    CheckingAccount CA = new CheckingAccount(FRAccountNumber, Name, UName, Balance);
			    double InitChkBalance = CA.getBalance(FRAccountNumber);
			    if(InitChkBalance < Double.parseDouble(Balance)){
					JOptionPane.showMessageDialog(null, "Please Chech Your Balance, You Don't Have Enough Balance To Make This Transfer !", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					}
                else{
				double balance = CA.widFromAcct(Balance,FRAccountNumber);
				String b1 = Double.toString(balance);

				SavingAccount SA = new SavingAccount(TOAccountNumber, Name, UName, Balance);
			    b2 = SA.depToAcct(Balance, TOAccountNumber);
				}
				if(b2!=-1)
	             {
	              	Transactions TC= new Transactions("Transfer",FRAccountNumber,TOAccountNumber,UName,Balance);
	            	TC.recordTransaction();
	            	JOptionPane.showMessageDialog(null, "Transfer Successfully From Your Cheking Account "+cosn + " to Savings Account " +socn+".", "Confirmation", JOptionPane.INFORMATION_MESSAGE);}

	            else
	               JOptionPane.showMessageDialog(null, "Transfer Failed", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		  }

		else if (FRAccountType.equals("Savings")) {
					SavingAccount SA = new SavingAccount(FRAccountNumber, Name, UName, Balance);
					Double InitSavBalance = SA.getBalance(FRAccountNumber);
					if(InitSavBalance < Double.parseDouble(Balance)){
						JOptionPane.showMessageDialog(null, "Please Chech Your Balance, You Don't Have Enough Balance To Make This Transfer !", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
					}
                	else{
			     	double balance = SA.widFromAcct(Balance,FRAccountNumber);
			     	String bs = Double.toString(balance);
					CheckingAccount CA = new CheckingAccount(TOAccountNumber, Name, UName, Balance);
					b2 = CA.depToAcct(Balance,TOAccountNumber);
					}
					if(b2!=-1)
		            {
						Transactions TS= new Transactions("Transfer",FRAccountNumber,TOAccountNumber,UName,Balance);
						TS.recordTransaction();
		                JOptionPane.showMessageDialog(null, "Transfer Successfully From Your Savings Account "+cosn + " to Cheking Account " +socn+".", "Confirmation", JOptionPane.INFORMATION_MESSAGE); }

		            else
		             JOptionPane.showMessageDialog(null, "Transfer Failed", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
          	}
     }
}