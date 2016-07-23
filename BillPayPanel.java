/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			  *
*	Date: November, 2015														  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;

public class BillPayPanel extends JPanel
{
   public BillPayPanel(String UName, String CustomerName)
   {
      tabbedPane = new JTabbedPane();

      tabPanel_1 = new PayeePanel(UName, CustomerName);
      tabPanel_2 = new PaymentPanel(UName, CustomerName);



      tabbedPane.addTab("Payee", tabPanel_1);
      tabbedPane.addTab("Payment", tabPanel_2);


      add(tabbedPane);
   }
   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2;



}
