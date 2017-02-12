import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is the useraccount interface
 * which is the first thing that pop out when user run the program
 * it gives the user choices of log in, if the user already has an username and password
 * or it allows user to create a new username and password (all integers) 
 * it is recommended that after the user creates a new account, he/she should close the program and run it again to log in
 * @author Ace
 *
 */
public class UserAccountInterface extends JFrame {

	private JLabel label1;
	private JButton button1;
	private JTextField text1;
	private JButton button2;

//here it sets the JFrame for display	
	
	public UserAccountInterface(){
		setLayout(new FlowLayout());
		label1 = new JLabel ("Welcome!");
		add(label1);
		
		button1 = new JButton("Login");
		add(button1);
		
		button2 = new JButton("Create New Account");
		add(button2);

//setting actions for the 2 buttons above		
		
		event e = new event();
		button1.addActionListener(e);
		
		event2 f = new event2();
		button2.addActionListener(f);
	}

//this action allows the user to log in to the system	
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			label1.setText("Loging in");
			LoginInterface trys = new LoginInterface();
			trys.UserLogin();
		}		
	}

//this action allows the user to create a new account	
	
	public class event2 implements ActionListener{
		public void actionPerformed(ActionEvent f){
			label1.setText("Creating username");
			NewUserInterface tryss = new NewUserInterface();
			tryss.NewUser();
		}		
	}

//here is the main method. I know, it is very hard to find	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserAccountInterface tryout = new UserAccountInterface();
		tryout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tryout.setVisible(true);
		tryout.setSize(250, 400);
		tryout.setTitle("Welcome to our book system");
	}
	
}
