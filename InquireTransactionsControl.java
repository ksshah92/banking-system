/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: November, 2015														  *
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

public class InquireTransactionsControl
{

	public InquireTransactionsControl(String s_date, String e_date, String  UName, String  Name)  // constructor with four parameters
	{
       Vector vect = new Vector();

       if (s_date.equals("") || e_date.equals("") || s_date.length()!= 8 || e_date.length() != 8)
	   		    JOptionPane.showMessageDialog(null, "Pleasse Enter Date in YYYYMMDD Format ", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	   else{

		   Transactions ts = new Transactions(UName);
		   vect = ts.retriveTransaction(s_date,e_date);

		   Vector<String> v = new Vector<String>(6);
		   v.add(0,"TransactionID");
		   v.add(1,"TransactionType");
		   v.add(2,"TransactionDate");
		   v.add(3,"Amount");
		   v.add(4,"FromAccount");
		   v.add(5,"ToAccount");


		   TransactionsList sit = new TransactionsList(vect,v);
     }
	}
}