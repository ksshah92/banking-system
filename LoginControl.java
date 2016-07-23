/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.shah.banking.*;

public class LoginControl
{
    private Account Acct;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String CustomerName = Acct.signIn();
        if (!CustomerName.equals("")) {
			System.out.println("Successful!");
            //JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            //OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);
            ListFrame frm = new ListFrame(UName, CustomerName);

        }
        else{
			System.out.println("fail!");
			JOptionPane.showMessageDialog(null, "Invalid Username or Password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			LoginBO lb = new LoginBO();
			lb.show();
		}

	}
}