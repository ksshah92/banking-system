/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;

class DeleteAPayeeBO extends JFrame implements ActionListener
{
	private JButton DeleteButton;
	private JTextField NameField;
    private String UsrName,CustoName;
	private String PName;

	public DeleteAPayeeBO(String UName, String CustomerName)
	{
		UsrName = UName;
		CustoName = CustomerName;

		setTitle("Delete Payee");
		setSize(600, 200);

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

		JLabel PNameLabel = new JLabel("Payee Name:");

		NameField = new JTextField(25);

		JPanel PDeletePanel = new JPanel();
		PDeletePanel.add(PNameLabel);
		PDeletePanel.add(NameField);


        DeleteButton = new JButton("Delete");

        GridBagLayout Gridbg = new GridBagLayout();
		setLayout(Gridbg);
		GridBagConstraints gbc = new GridBagConstraints();

		// UsernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PDeletePanel, gbc, 0, 0, 1, 1);

		// FromAccountTypeCheckBox
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(DeleteButton, gbc, 0, 1, 1, 1);


		DeleteButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt)  //event handling
	    {
			String arg = evt.getActionCommand();
			PName= NameField.getText();

		    if(arg.equals("Delete") && !PName.equals("")){

		  		dispose();
		  		PayeeControl pc = new PayeeControl(arg,PName,UsrName);

		  }

		  else{

		  		JOptionPane.showMessageDialog(null, "Enter Payee Name Then Click Delete", "Help", JOptionPane.INFORMATION_MESSAGE);
		  }
	  }

		public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
	       {
		    gbc.gridx = x;
		    gbc.gridy = y;
		    gbc.gridwidth = w;
		    gbc.gridheight = h;
		    add(c, gbc);
	    }



}


