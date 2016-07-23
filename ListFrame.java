/******************************************************************************
*	Name: Kaushal Shah for CSCI 6810 Java and the Internet	 			     *
*	Date: November, 2015													 *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.shah.banking.*;

public class ListFrame extends JFrame implements ActionListener
{
	private JButton LogoutButton;


   public ListFrame(String UName, String CustomerName)
   {
      setTitle("Welcome To JAVA Bank");
      setSize(800, 400);
      //pack();
      //setVisible(true);

      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 2 - 400, screenHeight / 7);

      addWindowListener (new WindowAdapter(){
		  public void windowClosing (WindowEvent e){
			  System.exit(0);
          }
      });

	  LogoutButton = new JButton("LogOut");

	  JPanel bankingPanel = new TabPanel(UName, CustomerName);


      Container contentPane = getContentPane();



      GridBagLayout Gridbg = new GridBagLayout();
	  setLayout(Gridbg);
	  GridBagConstraints gbc = new GridBagConstraints();

	  // Tabs
	  gbc.fill = GridBagConstraints.NONE;
	  gbc.weightx = 100;
	  gbc.weighty = 100;
	  add(bankingPanel, gbc, 0, 0, 1, 1);

	  // Button
	  gbc.fill = GridBagConstraints.NONE;
	  gbc.weightx = 100;
	  gbc.weighty = 100;
	  add(LogoutButton, gbc, 5, 5, 1, 1);

      LogoutButton.addActionListener(this); //event listener registration
      contentPane.add(bankingPanel);
      contentPane.add(LogoutButton);
      show();


   }
	public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		add(c, gbc);
	}


	public void actionPerformed(ActionEvent evt)  //event handling
	    {

	        String arg = evt.getActionCommand();
	        if (arg.equals("LogOut")) { //determine which button is clicked
	        	dispose();
	            LoginBO lb = new LoginBO();
	            lb.show();
			}
	    }

}

