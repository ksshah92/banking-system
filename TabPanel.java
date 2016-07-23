/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: November, 2015														  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;

public class TabPanel extends JPanel
{
   public TabPanel(String UName, String CustomerName)
   {
      tabbedPane = new JTabbedPane();

      tabPanel_1 = new ViewBalanceBO(UName, CustomerName);

      tabPanel_2 = new OpenBankAccountBO(UName, CustomerName);
      tabPanel_3 = new TransferBO(UName, CustomerName);
      tabPanel_4 = new InquireTransactionsBO(UName, CustomerName);
      tabPanel_5 = new BillPayPanel(UName, CustomerName);


      tabbedPane.addTab("Account Overview", tabPanel_1);
      tabbedPane.addTab("Open Account", tabPanel_2);
      tabbedPane.addTab("Transfer Balance", tabPanel_3);
      tabbedPane.addTab("Transaction Inquiry", tabPanel_4);
	  tabbedPane.addTab("Pay Bills", tabPanel_5);


      add(tabbedPane);
   }
   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2, tabPanel_3, tabPanel_4,tabPanel_5;



}
