import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This class provides a JFrame window that displays information to user
 * @author Ace
 *
 */

public class BookRecommendationWindow extends JFrame {
	
	private ArrayList<JLabel> books = new ArrayList<JLabel>();
	private JLabel book;
	private JButton closebutton;
	
//this method takes in a arraylist of book input
//and then set the JFrame
//and it will create an arraylist of JLabels too
//it matches each book title with a new JLabel and add all the JLabels to the arraylist
	
	public BookRecommendationWindow(ArrayList<String> bookinput){
		this.setSize(400,  400);
		setLayout(new FlowLayout());		
		
		for (int i = 0; i < bookinput.size(); i++){
			book = new JLabel();
			book.setText(bookinput.get(i));
			books.add(book);
		}

//here we add all the JLabels in the arraylist to the JFrame		
		
		for (int i = 0; i < books.size(); i++){
			add(books.get(i));
		}

//we also added a close button to allow user to exit the JFrame		
		
		closebutton = new JButton("Close window");
		add(closebutton);		
		event e = new event();
		closebutton.addActionListener(e);
	}

//here is the action for the close button	
	
	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("event");
			setVisible(false);
		}
	}
	
	
}

	