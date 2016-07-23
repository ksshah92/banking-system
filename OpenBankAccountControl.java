/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.shah.banking.*;

public class OpenBankAccountControl
{

    public OpenBankAccountControl(String AcountType, String  AccountNumber, String  Name, String  UName, String  Balance) {
		//Use CheckingAccount object to invoke method openAcct()
		if (AcountType.equals("Checking")) {
			CheckingAccount CA = new CheckingAccount(AccountNumber, Name, UName, Balance);
			if(CA.alhavact()){
				JOptionPane.showMessageDialog(null, "Already Have a Checking Account", "Permission Denied", JOptionPane.ERROR_MESSAGE);

			}
            else if (CA.openAcct()) {
            	System.out.println("successful!");
            	Transactions TrRec = new Transactions("Deposit","0",AccountNumber,UName,Balance);
            	TrRec.recordTransaction();
                JOptionPane.showMessageDialog(null, "Successfully Opened!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
				System.out.println("fail!");
				JOptionPane.showMessageDialog(null, "Cannot Open Checking Account. Change Account Number and Try Again!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if (AcountType.equals("Savings")) {
			SavingAccount SA = new SavingAccount(AccountNumber, Name, UName, Balance);

			if(SA.alhavact()){
				JOptionPane.showMessageDialog(null, "Already Have a Saving Account", "Permission Denied", JOptionPane.ERROR_MESSAGE);

			}


			else if (SA.openAcct()){
				System.out.println("successful!");
				Transactions TrRec1 = new Transactions("Deposit","0",AccountNumber,UName,Balance);
            	TrRec1.recordTransaction();
				JOptionPane.showMessageDialog(null, "Successfully Opened!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}

			else{
				System.out.println("fail!");
			    JOptionPane.showMessageDialog(null, "Cannot Open Checking Account. Change Account Number and Try Again!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
