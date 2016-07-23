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

public class PaymentControl
{
   public PaymentControl(String Ope, String PName, String Amt, String SchD, String ActType, String UsrName) //constructor with seven paramenters
    {

		if (Ope.equals("Schedule")) {
					CheckingAccount ca = new CheckingAccount();
					String ChekAccNum = ca.getCheckingAccountNum(UsrName);
					Double InitChkBalance = ca.getBalance(ChekAccNum);
					SavingAccount sa = new SavingAccount();
					String SavAccNum = sa.getSavingsAccountNum(UsrName);
           			Double InitSavBalance = sa.getBalance(SavAccNum);

			if(ActType.equals("Checking")){

					if(InitChkBalance >= Double.parseDouble(Amt)){

           			    Payment pyt = new Payment(PName, Amt, SchD, ActType, UsrName,"S");
           			    if(pyt.schedulingPaymnt()){
							JOptionPane.showMessageDialog(null, "Payment Successfully Scheduled.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						}

						else{
							JOptionPane.showMessageDialog(null, "Cannot Find Payee. Try Again!", "Warning", JOptionPane.WARNING_MESSAGE);
						}

					}

					else{
						JOptionPane.showMessageDialog(null, "Not Enough Balance in your " + ActType+" Account.", "Failed", JOptionPane.INFORMATION_MESSAGE);
					}
			}

			else if(ActType.equals("Savings")){

					if(InitSavBalance >= Double.parseDouble(Amt)){

           			    Payment pyt = new Payment(PName, Amt, SchD, ActType, UsrName, "S");
           			    if(pyt.schedulingPaymnt()){
							JOptionPane.showMessageDialog(null, "Payment Successfully Scheduled.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						}

						else{
							JOptionPane.showMessageDialog(null, "Cannot Find Payee. Try Again!", "Warning", JOptionPane.WARNING_MESSAGE);
						}

					}

					else{
						JOptionPane.showMessageDialog(null, "Not Enough Balance in your " + ActType+" Account.", "Failed", JOptionPane.INFORMATION_MESSAGE);
					}
			}
		}
	}

	public PaymentControl(String Ope, String PayID, String Usr)
    {
		int p = Integer.parseInt(Ope);
		if (p >= 450 && p <=511) {

				Payment py = new Payment(Usr);
				if(py.canSchPay(PayID)){
					JOptionPane.showMessageDialog(null, "Payment Successfully Deleted", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Payment ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}

		else if (p >= 517 && p <=576) {

				Payment py = new Payment();
				if(py.canSchPay(PayID)){
					JOptionPane.showMessageDialog(null, "Payment Successfully Updated", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Payment ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}

		else{

				JOptionPane.showMessageDialog(null, "Try Again!", "Error", JOptionPane.ERROR_MESSAGE);

			}

		  }
	  }




