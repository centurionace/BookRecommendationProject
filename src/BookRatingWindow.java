import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class takes in the user input of a book name and rating
 * and store them in the user database
 * @author Ace
 *
 */

public class BookRatingWindow extends JFrame{
	
	private String[] rating = new String[3];
	private User user;

//copying down the user object
	
	public BookRatingWindow(User userName){
		user = userName;
		
	}
	
	public void RateYourBook(){
		
//first, printing out a window to ask user for a book they want to rate
//then, using the match class to find the all the titles that match the user input
		
		String title = JOptionPane.showInputDialog("Enter the book title");
		FindMatches matches = new FindMatches(title);

//then it store all the matches and call another function to display all the matches in JFrame for the user to see		
//it then asks the user to type in the exact book name from all the matches
		
		ArrayList<String> bookmatch = matches.getMatches();
		RecommendationDisplay display = new RecommendationDisplay(bookmatch);
		display.setVisible(true);
		display.setSize(250, 400);
		display.setTitle("Please enter one of these options");

//a window that takes in the exact match of the book title		
//it then takes in the rating of the book by the user on a 0 to 10 scale
		
		String exacttitle = JOptionPane.showInputDialog("Enter the exact book title match");
		String rate = JOptionPane.showInputDialog("Enter your rating out of 10");

//using the exact books and rating from the user
//it searches to see if the book exists
//if it exists, it only add the rating to the book
//if the book doesn't exist, it add the book and the rating
		
		FindBookInfo book1 = new FindBookInfo(exacttitle);
		Book newBook = book1.getBook();
		newBook.addRating(rate);
		user.addBookToLibrary(newBook);
		
		ArrayList<Book> library = user.getBookLibrary();
		boolean found = false;
		
		for(Book book : library){
			if (book.getTitle().equalsIgnoreCase(title)){
				Book reviewBook = book;
				found = true;
				rating[0] = user.getId();
				rating[1] = reviewBook.getIsbn();
				rating[2] = rate;
				reviewBook.addRating(rate);
				break;
			}
		}
		
		if (found == false){
			FindBookInfo find = new FindBookInfo(title);
			Book revBook = find.getBook();
			rating[0] = user.getId();
			rating[1] = revBook.getIsbn();
			rating[2] = rate;
			revBook.addRating(rate);
			library.add(revBook);
		}
		
		
		AddRatings addRat = new AddRatings(rating);
		addRat.add();
	}
	
	
	
	
}
