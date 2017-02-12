import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class asks for user inputs for a new username and password
 * @author Ace
 *
 */


public class NewUserInterface extends JFrame{

	public NewUserInterface(){
		
			
	}
	
	public int NewUser(){

//contruct the panels that reads user input		
		
		String username = JOptionPane.showInputDialog("Enter new username");
		String password = JOptionPane.showInputDialog("Enter new password");
		
//convert the string input into integers		
		
		int us = Integer.parseInt(username);
		int ps = Integer.parseInt(password);

//then it calls for the create user class and give it the user inputs		
//it also checks for if the username is already in the database
		
		CreateUser create = new CreateUser();
		int result = create.CreatNewUser(us, ps);
		
		if (result == 1){		
			JOptionPane.showMessageDialog(null, "new account created");
		}
		else if (result == 0){
			JOptionPane.showMessageDialog(null, "account already exists. please login");
		}
		return 1;
	}
	
	
}
