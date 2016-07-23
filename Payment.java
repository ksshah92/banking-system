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



public class Payment{
	private String PaymentID, PayeeName, PaymentDate, FromAccount, CustomerID, Status;
	private Float PaymentAmount;

	public Payment(String Py_Name, String Py_Amt, String Py_Date, String Frm_Act, String Cust_ID, String St){
		PaymentID=generatePayID();
		PayeeName=Py_Name;
		PaymentDate=Py_Date;
		FromAccount=Frm_Act;
		CustomerID=Cust_ID;
		PaymentAmount= Float.parseFloat(Py_Amt);
		Status = St;
	}

	public Payment(String Cust_ID){
		CustomerID=Cust_ID;
	}

	public Payment(String st, String Cust_ID){
			Status = st;
			CustomerID=Cust_ID;
	}

	public Payment(){
	}

	public String generatePayID(String... arguments){
		UUID PId = UUID.randomUUID();
		String pid = String.valueOf(PId);
		return pid;
	}

	public boolean schedulingPaymnt(){
		boolean done = false;
		try{
			if(!done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command="Select * from Payee Where PayeeName = '" + PayeeName+ "' And CustomerID = '"+CustomerID+"'";
				ResultSet Rslt = Stmt.executeQuery(SQL_Command);
				done = Rslt.next();
				if(done){
					SQL_Command="INSERT INTO Payment values ('" + PaymentID + "', '" + PayeeName+ "', '" +PaymentAmount + "', '" + PaymentDate + "', '" + FromAccount + "','" + CustomerID + "','" + Status + "')";
					Stmt.executeUpdate(SQL_Command);
				}

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

	public boolean canSchPay(String pid){
		boolean done = false;
		try{
			if(!done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command="Select * FROM Payment WHERE PaymentID ='"+pid+"'";
				ResultSet Rslt = Stmt.executeQuery(SQL_Command);
				done = Rslt.next();
				if(done){
					SQL_Command="DELETE FROM Payment WHERE PaymentID ='"+pid+"'";
					Stmt.executeUpdate(SQL_Command);
				}
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



	public boolean delSchPay(){
		boolean done = false;
		try{
			if(!done){
				System.out.println(generatePDate());

				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				String SQL_Command="select * from Payment WHERE CustomerID ='" + CustomerID+ "' And PaymentDate = '"+ generatePDate()+"' and Status = 'S'";
				ResultSet Rslt = Stmt.executeQuery(SQL_Command);
				//ResultSetMetaData Rsmd= Rslt.getMetaData();
				//done = Rslt.next();

				while(Rslt.next()){
					System.out.println(Rslt.getString(5));
					if(Rslt.getString(5).equals("Checking")){
						System.out.println("checking");
						CheckingAccount Chk = new CheckingAccount(CustomerID);
						Chk.widFromAcct(String.valueOf(Rslt.getString(3)), Chk.getCheckingAccountNum(CustomerID));
						ToDB = new DBConnection(); //Have a connection to the DB
						DBConn = ToDB.openConn();
						Transactions Tr = new Transactions("Bill Pay",Chk.getCheckingAccountNum(CustomerID),"0",CustomerID,String.valueOf(Rslt.getString(3)));
						if(Tr.recordTransaction()){
							done = true;
							ToDB = new DBConnection(); //Have a connection to the DB
							DBConn = ToDB.openConn();
						}
						SQL_Command="UPDATE Payment Set Status ='D' WHERE PaymentID ='"+Rslt.getString(1)+"' AND CustomerID = '"+CustomerID+"'";
						Stmt.executeUpdate(SQL_Command);
						//ToDB = new DBConnection(); //Have a connection to the DB
						//DBConn = ToDB.openConn();

					}
					else if(Rslt.getString(5).equals("Savings")){
						System.out.println("saving");
						SavingAccount Sv = new SavingAccount(CustomerID);
						Sv.widFromAcct(String.valueOf(Rslt.getString(3)), Sv.getSavingsAccountNum(CustomerID));
						ToDB = new DBConnection(); //Have a connection to the DB
						DBConn = ToDB.openConn();
						Transactions Tr = new Transactions("Bill Pay",Sv.getSavingsAccountNum(CustomerID),"0",CustomerID,String.valueOf(Rslt.getString(3)));
						if(Tr.recordTransaction()){
							done = true;
							ToDB = new DBConnection(); //Have a connection to the DB
							DBConn = ToDB.openConn();
						}
						SQL_Command="UPDATE Payment Set Status ='D' WHERE PaymentID ='"+Rslt.getString(1)+"' AND CustomerID = '"+CustomerID+"'";
						Stmt.executeUpdate(SQL_Command);
						//ToDB = new DBConnection(); //Have a connection to the DB
						//DBConn = ToDB.openConn();
					}
				}

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


public Vector viewPayments(String Un){
			Vector v = new Vector();
			try{
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Comm = "select PaymentID, PayeeName, Amount, PaymentDate, FromAccount from Payment WHERE CustomerID ='" + Un+ "' and Status = 'S' and PaymentDate >= '"+generatePDate()+"'";
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


 public String generatePDate(){
 		String PDate;
 		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");   //get currentdate
 		Date date = new Date();
 		PDate=dateFormat.format(date);
 		return PDate;
	}

}
