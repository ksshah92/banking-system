/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012
*	Modified By: Kaushal Shah  Date: November, 2015
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LoginBO extends JFrame implements ActionListener // Implementing ActionListener is for event handling.
{
    private JButton SignUpButton, LoginButton;  //Instance variables
    private JTextField UsernameField;
    private JPasswordField PasswordField;


    public LoginBO()
    {
        setTitle("Account Login");
        setSize(400, 400);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         SignUpButton = new JButton("Sign Up"); //initializing two button references
         LoginButton = new JButton("Login");

         UsernameField = new JTextField(15);
         PasswordField = new JPasswordField(15);

         JLabel FirstTimeUserLabel = new JLabel("First time user? Click Sign Up to register!");
         JLabel UsernameLabel = new JLabel("Username: ");
         JLabel PasswordLabel = new JLabel("Password: ");

         JPanel UsernamePanel = new JPanel();
         JPanel PasswordPanel = new JPanel();

         UsernamePanel.add(UsernameLabel);
         UsernamePanel.add(UsernameField);
         PasswordPanel.add(PasswordLabel);
         PasswordPanel.add(PasswordField);

         JPanel LoginPanel = new JPanel();
         LoginPanel.add(UsernamePanel);
         LoginPanel.add(PasswordPanel);
		 LoginPanel.add(LoginButton);  //add the two buttons on to this panel
         LoginPanel.add(FirstTimeUserLabel);
         LoginPanel.add(SignUpButton);

		// gridbaglayout
		GridBagLayout Gridbg = new GridBagLayout();
		setLayout(Gridbg);
		GridBagConstraints gbc = new GridBagConstraints();

		// UsernamePanel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(UsernamePanel, gbc, 0, 0, 1, 1);

		// PasswordPanel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PasswordPanel, gbc, 0, 1, 1, 1);

	  // LoginButton
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(LoginButton, gbc, 0, 2, 1, 1);

		// FirstTime
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(FirstTimeUserLabel, gbc, 0, 3, 1, 1);

		// SignUpButton
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(SignUpButton, gbc, 0, 4, 1, 1);


		 SignUpButton.addActionListener(this);  //event listener registration
         LoginButton.addActionListener(this);

         Container contentPane = getContentPane(); //add a panel to a frame
         contentPane.add(LoginPanel);

	}

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();

        if (arg.equals("Sign Up")) { //determine which button is clicked
            //System.out.println("Name: "+arg);
			dispose();
            SignUpControl SUC = new SignUpControl(); //take actions
		}

		if (arg.equals("Login")) {
			//System.out.println("Name: "+arg);
			dispose();
			String Username = UsernameField.getText();
			String Password = PasswordField.getText();
            LoginControl LoginC = new LoginControl(Username, Password);
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

    public static void main(String [] args)
    { JFrame frame = new LoginBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

