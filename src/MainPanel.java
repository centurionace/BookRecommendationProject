import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class MainPanel extends JFrame {

	private JLabel label1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private String username;
	private User user;

/**
 * 	This is the main user panel
 * it allows user to manage their accounts
 * the user can view all the books that he/she stored in the program
 * and can also rate books and add them to the user booklist
 * the system can also return book recommendations in the following two ways:
 * 1.ask the user to put in a favorite book and return a list of recommendations
 * 2.give the user a recommendation list based on the user's rated books
 * @author Ace
 */
	
//this is the start of the main panel and it takes a user account number as an argument
//the program first loads the user file according to the account number
	
	public MainPanel(int account){
		username = Integer.toString(account);
		LoadUserData getData = new LoadUserData(username);
		user = getData.getUser();
		
//setting the layout for the panel
//adding labels and buttons for different functions
		
		setLayout(new FlowLayout());
		label1 = new JLabel ("Welcome, user " + username);
		add(label1);
		
		button1 = new JButton("View your books");
		add(button1);
		
		button2 = new JButton("Rate your books");
		add(button2);
		
		button4 = new JButton("Get a book recommendation");
		add(button4);
		
		button5 = new JButton("Get a user based recommendation");
		add(button5);
		
		button3 = new JButton("Saving your books");
		add(button3);		

//setting events that are triggered by the press of these buttons		
		
		event e = new event();
		button1.addActionListener(e);
		
		event2 f = new event2();
		button2.addActionListener(f);
		
		event3 g = new event3();
		button3.addActionListener(g);
		
		event4 h = new event4();
		button4.addActionListener(h);
		
		event5 i = new event5();
		button5.addActionListener(i);
	}

//event of when user wants to view all their books
//this action calls for a book viewing JFrame that displays all the books
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			label1.setText("Viewing your books");
			ViewingBooksWindow viewbook = new ViewingBooksWindow(user);
			viewbook.setVisible(true);
			viewbook.setSize(250, 400);
			viewbook.setTitle("Here are your book list");
//more actions			
		}		
	}

//event of when user wants to rate a book
//this actions calls for a bookrating window to pop out
	
	public class event2 implements ActionListener{
		public void actionPerformed(ActionEvent f){
			label1.setText("Rating a book");
			BookRatingWindow trys = new BookRatingWindow(user);
			trys.RateYourBook();
//more actions			
		}		
	}

//event of when user wants to save all the user data	
	
	public class event3 implements ActionListener{
		public void actionPerformed(ActionEvent f){
			SaveUserData savedata = new SaveUserData(user);
//more actions			
		}		
	}	

//event of when user wants to get a book recommendation from a single book
//it calls for a book recommending class based on a single input
//and then calls for a display of the list of recommendations
	
	public class event4 implements ActionListener{
		public void actionPerformed(ActionEvent h){
			label1.setText("Getting a recommendation");
			RecommendOneBook recommendation = new RecommendOneBook();
			ArrayList<String> result = recommendation.BookInput();
			BookRecommendationWindow tryout = new BookRecommendationWindow(result);
			tryout.setVisible(true);
			tryout.setSize(250, 400);
			tryout.setTitle("Here are the books recommended");
//more actions			
		}		
	}

//event of when user wants to get a book recommendation from his/her profile
//it calls for a book recommending class that reads the user profile and return recommendations
//and then calls for a display of these recommendations	
	
	public class event5 implements ActionListener{
		public void actionPerformed(ActionEvent i){
			label1.setText("Get a user based recommendation");
			BookRatingRecommendation userbased = new BookRatingRecommendation(user);
			ArrayList<String> result = userbased.RateRecommend();
			BookRecommendationWindow tryout = new BookRecommendationWindow(result);
			tryout.setVisible(true);
			tryout.setSize(300, 400);
			tryout.setTitle("Here are the user based book recommendation");
			
//more actions			
		}		
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MainPanel tryout = new MainPanel();
		
//		tryout.setVisible(true);
//		tryout.setSize(250, 400);
//		tryout.setTitle("Welcome to our book system");
//	}
	
}
