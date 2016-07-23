/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/
package com.shah.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.shah.banking.*;

public class SavingAccount
{   //Instance Variables
	private String SavingAccountNumber, CustomerName, CustomerID;
	private float Balance = -1;

	public SavingAccount(String SA_Num, String Cust_Name, String Cust_ID, String Bal) { //Constructor One with three parameters
		SavingAccountNumber = SA_Num;
		CustomerName = Cust_Name;
		CustomerID = Cust_ID;
		Balance = Float.parseFloat(Bal);
	}

	public SavingAccount(String SA_Num) { //Constructor Two with one parameter
		SavingAccountNumber = SA_Num;
	}

	public SavingAccount() {}

	public boolean alhavact(){
		boolean done = false;
		try{
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
			Statement Stmt = DBConn.createStatement();
			String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
			ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			done = Rslt.next();
			Stmt.close();
			ToDB.closeConn();
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

    public boolean openAcct() {
	     boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingAccountNumber+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        done = !Rslt.next();
				        if (done) {
						    SQL_Command = "INSERT INTO SavingsAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID)"+
						                  " VALUES ('"+SavingAccountNumber+"','"+CustomerName+"',"+Balance+", '"+CustomerID+"')"; //Save the username, password and Name
						    Stmt.executeUpdate(SQL_Command);
					    }
					    Stmt.close();
					    ToDB.closeConn();
					}
				}
			    catch(java.sql.SQLException e)
			    {         done = false;
						 System.out.println("SQLException: " + e);
						 while (e != null)
						 {   System.out.println("SQLState: " + e.getSQLState());
							 System.out.println("Message: " + e.getMessage());
							 System.out.println("Vendor: " + e.getErrorCode());
							 e = e.getNextException();
							 System.out.println("");
						 }
			    }
			    catch (java.lang.Exception e)
			    {         done = false;
						 System.out.println("Exception: " + e);
						 e.printStackTrace ();
			    }
	    return done;
	}
    public double getBalance() {  //Method to return a SavingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				System.out.println("Exception: " + e);
				e.printStackTrace ();
	    }
	    return Balance;
	}

    public double getBalance(String SvAcctNumber) {  //Method to return a SavingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SvAcctNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {
				System.out.println("Exception: " + e);
				e.printStackTrace ();
	    }
	    return Balance;
	}


	public String getSavingsAccountNum(String Username) //Method to return a SavingsAccount number
	{
		try {
			DBConnection ToDB = new DBConnection(); //connection to the DB
			Connection DBConn = ToDB.openConn();
			Statement Stmt = DBConn.createStatement();
			String SQL_Command = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE CustomerID = '"+Username+"'"; //SQL query command
			ResultSet Rtst = Stmt.executeQuery(SQL_Command);
			while (Rtst.next()) {
				SavingAccountNumber = Rtst.getString(1);
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


		return SavingAccountNumber;
	}


	public double depToAcct(String dep, String SvAcctNumber){  // Method to Deposit Money to a Saving Account

		float depAmount= Float.parseFloat(dep);
			try{

					DBConnection ToDB = new DBConnection();
					Connection DBConn = ToDB.openConn();
					Statement Stmt = DBConn.createStatement();
					String SQL_Comm= "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SvAcctNumber+"'";
					ResultSet Rslt1 = Stmt.executeQuery(SQL_Comm);

					if(Rslt1.next()){
						Balance = Rslt1.getFloat(1);
						Balance+= depAmount;
						SQL_Comm = "UPDATE SavingsAccount Set Balance ="+Balance +  "WHERE SavingsAccountNumber ='"+SvAcctNumber+"'";
						Stmt.executeUpdate(SQL_Comm);
					}
					Stmt.close();
					ToDB.closeConn();
				}

		catch(java.sql.SQLException e)
			    {

						 System.out.println("SQLException: " + e);
						 while (e != null)
						 {   System.out.println("SQLState: " + e.getSQLState());
							 System.out.println("Message: " + e.getMessage());
							 System.out.println("Vendor: " + e.getErrorCode());
							 e = e.getNextException();
							 System.out.println("");
						 }
			    }
			    catch (java.lang.Exception e)
			    {

						System.out.println("Exception: " + e);
						e.printStackTrace ();
			    }
	    return Balance;
	}

	public double widFromAcct(String amt, String SvAcctNumber){  //Method to Withdraw Money From a Saving Account

			float widAmount= Float.parseFloat(amt);
				try{

						DBConnection ToDB = new DBConnection();
						Connection DBConn = ToDB.openConn();
						Statement Stmt = DBConn.createStatement();
						String SQL_Comm= "SELECT Balance FROM SavingsAccount WHERE SavingsAccountNumber ='"+SvAcctNumber+"'";
						ResultSet Rslt2 = Stmt.executeQuery(SQL_Comm);

						if(Rslt2.next()){
							Balance = Rslt2.getFloat(1);
							System.out.println(Balance);
							Balance -= widAmount;
							System.out.println(Balance);
							if(Balance>=0){
								SQL_Comm = "UPDATE SavingsAccount Set Balance ="+Balance + "WHERE SavingsAccountNumber ='"+SvAcctNumber+"'";
								Stmt.executeUpdate(SQL_Comm);
							}
						}
						Stmt.close();
						ToDB.closeConn();
					}

			catch(java.sql.SQLException e)
				    {

							 System.out.println("SQLException: " + e);
							 while (e != null)
							 {   System.out.println("SQLState: " + e.getSQLState());
								 System.out.println("Message: " + e.getMessage());
								 System.out.println("Vendor: " + e.getErrorCode());
								 e = e.getNextException();
								 System.out.println("");
							 }
				    }
			catch (java.lang.Exception e)
				    {

							System.out.println("Exception: " + e);
							e.printStackTrace ();
				    }
		    return Balance;
	}
}