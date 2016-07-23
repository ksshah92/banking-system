/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.text.*;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.shah.banking.*;

class VEDPaymentBO extends JFrame
{
	private JTable jt;
	private JPanel DPanel, EPanel;
	private String UsrName,CustoName;
	private Vector vect = new Vector();

	public VEDPaymentBO(String UName, String CustomerName)
	{
		UsrName = UName;
		CustoName = CustomerName;

		setTitle("Scheduled Payments");
		setSize(800, 600);

		//get screen size and set the location of the frame
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setLocation( screenWidth / 3, screenHeight / 4);

		addWindowListener (new WindowAdapter()  //handle window event
		{
			public void windowClosing (WindowEvent e){
			//System.exit(0);
			}
        });

		Payment py = new Payment(UsrName);
        vect = py.viewPayments(UsrName);

		Vector<String> v = new Vector<String>(7);
		v.add(0,"PaymentID");
		v.add(1,"PayeeName");
		v.add(2,"Amount");
		v.add(3,"ScheduledDate");
		v.add(4,"FromAccount");
		v.add(5,"Edit");
		v.add(6,"Delete");

		//////////
		DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
    		}
		};
		dm.setDataVector(vect,v);

		final JTable table = new JTable();
		table.setModel(dm);
		table.setRowHeight(30);
		table.getColumn("Edit").setCellRenderer(new ButtonRenderer());
		table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(5).setPreferredWidth(50);
		columnModel.getColumn(6).setPreferredWidth(50);
		JScrollPane scroll = new JScrollPane(table);
		getContentPane().add(scroll);
		setSize(600, 600);
		setVisible(true);

		table.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
		            // This is for double click event on anywhere on JTable
		            if (e.getClickCount() == 2) {
		                JTable target = (JTable) e.getSource();
		                int row = target.getSelectedRow();
		                int column = target.getSelectedColumn();
		               // you can play more here to get that cell value and all
						if (column == 5 || column==6){

							Object o = new Object();
							o = table.getModel().getValueAt(row, 0);
							int p = e.getX();
							System.out.println(p);
							dispose();
							PaymentControl pc = new PaymentControl(String.valueOf(p), o.toString(),UsrName);
						}
		            }
		        }
    			});





		/////////

	}
					/*
							public void actionPerformed(ActionEvent evt)  //event handling
								    {
										String arg = evt.getActionCommand();
										//PyID = PaymentIDField.getText();


									    if(arg.equals("Delete") ){

									  		dispose();
									  		PaymentControl pc = new PaymentControl(arg, UsrName);

									  }

									  else{

									  		JOptionPane.showMessageDialog(null, "Enter Payment ID.\nYou can see Payment ID in View Scheduled Payment(s).", "Help", JOptionPane.INFORMATION_MESSAGE);
									  }
								  }

							*/

		class ButtonRenderer extends JButton implements TableCellRenderer{

			    public ButtonRenderer() {
			        setOpaque(true);
			    }


	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){


	        if (isSelected) {
	            setForeground(table.getSelectionForeground());
	            setBackground(table.getSelectionBackground());
	        } else {
	            setForeground(table.getForeground());
	            setBackground(UIManager.getColor("Button.background"));
	        }

	        return this;
	    	}

		}


}






