import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginInterface extends JFrame{

	public LoginInterface(){
		
		
			
	}
	
	public int UserLogin(){
		
		String username = JOptionPane.showInputDialog("Enter your username");
		String password = JOptionPane.showInputDialog("Enter your password");
		
		int us = Integer.parseInt(username);
		int ps = Integer.parseInt(password);
		
		UserLogin login = new UserLogin();
		int result = login.userlogin(us, ps);
		
		if (result == 1){
			JOptionPane.showMessageDialog(null, "login success");
			MainPanel tryout = new MainPanel(us);
			tryout.setVisible(true);
			tryout.setSize(250, 400);
			tryout.setTitle("Welcome to our book system");
			return 1;
		}
		else if (result == 2){
			JOptionPane.showMessageDialog(null, "wrong password, please try again");
			return 2;
		}
		else {
			JOptionPane.showMessageDialog(null, "username not fonud, please create new one");
			return 0;
		}
	}
	
	
}
