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

class TransactionsList extends JFrame
{
	public TransactionsList(Vector vec, Vector v)
	{
		JTable jt = new JTable(vec,v);
       	JScrollPane jsp = new JScrollPane(jt);
		add(jsp);
        setTitle("List of Transactions");
		setVisible(true);
		setSize(700,300);
	}
}