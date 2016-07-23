/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/
package com.shah.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.util.*;
import com.shah.banking.*;
import java.util.UUID;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transactions
{	//Instance Variables for Transactions Class
	private String TransactionID, TransactionType, TransactionDate, FromAccount, ToAccount, CustomerID;
	private float TransactionAmount;

	public Transactions(String Tr_Typ,String Frm_Acct, String To_Acct, String Cust_ID, String Amnt){

		TransactionID=generateTransID();
		TransactionType=Tr_Typ;
		ToAccount=To_Acct;
		FromAccount=Frm_Acct;
		CustomerID=Cust_ID;
		TransactionDate= generateTransDate();
		TransactionAmount=Float.parseFloat(Amnt);
	}

	public Transactions(String Cust_ID){
		CustomerID = Cust_ID;
	}

	public String generateTransID(String... arguments){
		UUID TId = UUID.randomUUID();
		String tid = String.valueOf(TId);
		return tid;
	}

	public String generateTransDate(){
		String TransDate;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");   //get currentdate
		Date date = new Date();
		TransDate=dateFormat.format(date);
		return TransDate;
	}

	public boolean recordTransaction(){
		boolean done = false;
		try{
			if(!done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command="INSERT INTO Transactions values ('" + TransactionID + "', '" + TransactionType + "', '" + TransactionDate + "', '" + TransactionAmount + "', '" + FromAccount + "', '" + ToAccount + "', '" + CustomerID + "')";
				Stmt.executeUpdate(SQL_Command);
				done= true;
				Stmt.close();
				ToDB.closeConn();
			}
		}


		catch(java.sql.SQLException e){
			done = false;
			System.out.println("SQLException: " + e);
			while (e != null){
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		}

		catch (java.lang.Exception e){
			done = false;
			System.out.println("Exception: " + e);
			e.printStackTrace ();
		}
		return done;
	}

	public Vector retriveTransaction(String FromDate, String ToDate ){
		Vector v = new Vector();
		try{
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
			Statement Stmt = DBConn.createStatement();
			String SQL_Comm = "select TransactionID, TransactionType, TransactionDate, Amount, FromAccount, ToAccount from Transactions WHERE CustomerID ='" + CustomerID + "' AND TransactionDate BETWEEN '"+FromDate+"' AND '"+ToDate+"' ";
			ResultSet Rslt = Stmt.executeQuery(SQL_Comm);
			ResultSetMetaData Rsmd= Rslt.getMetaData();
			while(Rslt.next()){
				v.addElement(ToDB.getNextRow(Rslt,Rsmd));
			}
			Stmt.close();
			ToDB.closeConn();
		}

		catch(java.sql.SQLException e){
			System.out.println("SQLException: " + e);
			while (e != null){
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		}

		catch (java.lang.Exception e){
			System.out.println("Exception: " + e);
			e.printStackTrace ();
		}
		return v;
	}

}

