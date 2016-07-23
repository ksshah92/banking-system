/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/
package com.shah.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.shah.banking.*;

public class Payee{
	private String PayeeID, PayeeName, PayeeAddress, CustomerID, PayeePhoneNumber;


	public Payee(String Py_Nm, String Py_Add, String Py_PhnNum, String Cust_ID){
		PayeeID = generateId();
		PayeeName = Py_Nm;
		PayeeAddress = Py_Add;
		CustomerID = Cust_ID;
		PayeePhoneNumber = Py_PhnNum;
	}

	public Payee(String Cust_ID){
		CustomerID = Cust_ID;
	}

	public Payee(){

	}

	public String getAdd(String Un, String Py_name){
		String address = "-";
		try{
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command = "SELECT PayeeAddress FROM Payee WHERE PayeeName ='"+Py_name+"' AND CustomerID = '"+Un+"'";//SQL query command
				ResultSet Rslt = Stmt.executeQuery(SQL_Command);
				while(Rslt.next()){
					address = Rslt.getString(1);
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
				return address;
	}

	public String getPhoneNumber(String Un, String Py_name){
			String number = "-";
			try{
					DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					Connection DBConn = ToDB.openConn();
					Statement Stmt = DBConn.createStatement();
					String SQL_Command = "SELECT PayeePhoneNumber FROM Payee WHERE PayeeName ='"+Py_name+"' AND CustomerID = '"+Un+"'"; //SQL query command
					ResultSet Rslt = Stmt.executeQuery(SQL_Command);
					while(Rslt.next()){
						number = Rslt.getString(1);
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
					return number;
	}




	public boolean addPayee(){
		boolean done = false;
		try{
			if(!done){
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Command = "SELECT PayeeID FROM Payee WHERE PayeeName ='"+PayeeName+"' AND CustomerID = '"+CustomerID+"'"; //SQL query command
				ResultSet Rslt = Stmt.executeQuery(SQL_Command);
				done = !Rslt.next();
				if(done){
					SQL_Command="INSERT INTO Payee values ('" + PayeeID + "', '" + PayeeName + "', '" + PayeeAddress + "', '" + PayeePhoneNumber + "', '" + CustomerID + "')";
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

	public void updtPayee(String PName, String PAdd, String PPNum, String un){

		try{
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
			Statement Stmt = DBConn.createStatement();
			String SQL_Comm="UPDATE Payee Set PayeeAddress ='"+PAdd+"', PayeePhoneNumber ='"+PPNum +"'WHERE PayeeName ='"+PName+"' AND CustomerID = '"+un+"'";
			Stmt.executeUpdate(SQL_Comm);
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
	}

	public boolean DelPayee(String Un, String PyName){
			boolean done = false;
			if(!done){
				try{
					DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					Connection DBConn = ToDB.openConn();
					Statement Stmt = DBConn.createStatement();
					String SQL_Comm="Select * From Payee WHERE PayeeName ='"+PyName+"' AND CustomerID = '"+Un+"'";
					ResultSet Rslt = Stmt.executeQuery(SQL_Comm);
					done = Rslt.next();
					if(done){
						SQL_Comm="Delete From Payee WHERE PayeeName ='"+PyName+"' AND CustomerID = '"+Un+"'";
						Stmt.executeUpdate(SQL_Comm);
					}
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
		}
			return done;
	}

	public Vector viewPayees(String Un){
			Vector v = new Vector();
			try{
				DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();
				String SQL_Comm = "select PayeeName, PayeeAddress, PayeePhoneNumber from Payee WHERE CustomerID ='" + Un+ "'";
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

	public String generateId(){
		DateFormat date_f = new SimpleDateFormat("yyyyMMdd");
		DateFormat time_n = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		return date_f.format(date)+time_n.format(date);
	}

}