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

public class PayeeControl
{
   public PayeeControl(String Ope, String PName, String PAddress, String PPhoneNumber, String UsrName, String CustoName) //constructor with seven paramenters
    {

		if (Ope.equals("Add")) {

			    Payee py = new Payee(PName,PAddress, PPhoneNumber, UsrName);
				if(py.addPayee()){
					JOptionPane.showMessageDialog(null, "Payee Successfully Added.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

				}
				else{
					JOptionPane.showMessageDialog(null, "Payee Already Exists !!", "Warning", JOptionPane.WARNING_MESSAGE);

				}

		}

		else if (Ope.equals("Update")) {

			    Payee py = new Payee(PName,PAddress, PPhoneNumber, UsrName);
				py.updtPayee(PName,PAddress,PPhoneNumber, UsrName);
				JOptionPane.showMessageDialog(null, "Payee Successfully Updated.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public PayeeControl(String Ope, String PName, String UsrName){

		if (Ope.equals("Delete")) {

				Payee py = new Payee(UsrName);
				if(py.DelPayee(UsrName, PName)){
					JOptionPane.showMessageDialog(null, "Payee Successfully Deleted.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Payee Name Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		else{

				JOptionPane.showMessageDialog(null, "Try Again!", "Error", JOptionPane.INFORMATION_MESSAGE);

			}

		  }

	}
