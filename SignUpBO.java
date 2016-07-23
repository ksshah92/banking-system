/******************************************************************************
*	Program Author: Kaushal Shah for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import com.shah.banking.*;

class SignUpBO extends JFrame implements ActionListener
{
    private JButton RegisterButton;
    private JTextField UsernameField, NameField;
    private JPasswordField PasswordField, PasswordField1;
    private String UName, PsWord, PsWord1, Name;
    private Account Acct;

    public SignUpBO()
    {

        setTitle("Sign Up");
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
		     { 	System.exit(0);}
		 });

        RegisterButton = new JButton("Sign Up"); //initializing two button references

        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        PasswordField1 = new JPasswordField(15);
        NameField = new JTextField(15);

        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel PasswordLabel = new JLabel("Password: ");
        JLabel PasswordLabel1 = new JLabel("Verify Password:");
        JLabel NameLabel = new JLabel("Name:");

        JPanel UsernamePanel = new JPanel();
        JPanel PasswordPanel = new JPanel();
        JPanel PasswordPanel1 = new JPanel();
        JPanel NamePanel = new JPanel();

        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        PasswordPanel.add(PasswordLabel);
        PasswordPanel.add(PasswordField);
        PasswordPanel1.add(PasswordLabel1);
        PasswordPanel1.add(PasswordField1);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);

        JPanel SignUpPanel = new JPanel();
        SignUpPanel.add(UsernamePanel);
        SignUpPanel.add(PasswordPanel);
        SignUpPanel.add(PasswordPanel1);
        SignUpPanel.add(NamePanel);
        SignUpPanel.add(RegisterButton);  //add the two buttons on to this panel


		////////////////////

		// gridbaglayout
		GridBagLayout Gridbg = new GridBagLayout();
		setLayout(Gridbg);
		GridBagConstraints gbc = new GridBagConstraints();

		// UsernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(UsernamePanel, gbc, 0, 0, 1, 1);

		// UsernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PasswordPanel, gbc, 0, 1, 1, 1);

		// CusromernameLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(PasswordPanel1, gbc, 0, 2, 1, 1);

		// CusromernameTextField
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(NamePanel, gbc, 0, 3, 1, 1);

		// FromAccountTypeLabel
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(RegisterButton, gbc, 0, 4, 1, 1);

		////////////////////




        RegisterButton.addActionListener(this); //event listener registration

    	Container contentPane = getContentPane(); //add a panel to a frame
	    contentPane.add(SignUpPanel);
        show();
    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();
        if (arg.equals("Sign Up")) { //determine which button is clicked
            UName = UsernameField.getText(); //take actions
            PsWord =PasswordField.getText();
            PsWord1 = PasswordField1.getText();
            Name = NameField.getText();

            Acct = new Account(UName, PsWord, PsWord1, Name);
            if (Acct.signUp()){
				JFrame frame = new JFrame();
				dispose();
				JOptionPane.showMessageDialog(null, "Account has been created!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				ListFrame lst = new ListFrame(UName, Name);
			}
            else
                JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
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

