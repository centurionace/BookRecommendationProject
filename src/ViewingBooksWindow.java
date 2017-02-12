import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/**
 * This class provides the user with a display of the books the user stored in his/her account
 * @author Ace
 *
 */

public class ViewingBooksWindow extends JFrame {
	
	private ArrayList<JLabel> books = new ArrayList<JLabel>();
	private JLabel book;
	private JButton closebutton;
	private ArrayList<String> booklist = new ArrayList<String>();
	private ArrayList<Book> bookobject = new ArrayList<Book>(); 
	public ViewingBooksWindow(User user){

//first it gets the user library from the user object
		
		bookobject = user.getBookLibrary();

//then it stores all the book titles in an arraylist of strings		
		
		for (Book object : bookobject){
			String title = object.getTitle();
			booklist.add(title);
		}
		
//here it sets up the JFrame for display	
		
		this.setSize(400, 400);
		setLayout(new FlowLayout());

//then it creates a JLabel for each of the book titles
		
		for (int i = 0; i < booklist.size(); i++){
			book = new JLabel();
			book.setText(booklist.get(i));
			books.add(book);
		}
		
//here it adds all the JLabels to the JFrame
		
		for (int i = 0; i < books.size(); i++){
			
			add(books.get(i));
		}

//and it also provides a close button for user to exit out of the window		
		
		closebutton = new JButton("Close window");
		add(closebutton);		
		event e = new event();
		closebutton.addActionListener(e);
	}
	

	public class event implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("event");
			setVisible(false);
		}
	}
	
	
}

	