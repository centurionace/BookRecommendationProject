import javax.swing.JOptionPane;

import org.apache.mahout.cf.taste.common.TasteException;

import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class takes in a user object and get the book recommendations and return the recommendation list
 * @author Ace
 *
 */
public class BookRatingRecommendation extends JFrame{
	private User user;
	ArrayList<String> titles;
	private HashMap<String, String> isbnToTitle;
	private HashMap<String, String> idToIsbn;
	private HashMap<String, String> isbnToIds;

//constructor with user object as an argument	
//using the user object to get information 
	
	public BookRatingRecommendation(User newUser){
		user = newUser;
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		isbnToTitle = data.getIsbnToTitle();
		idToIsbn = data.getIdToIsbn();
		isbnToIds = data.getIsbnToIds();
				
	}
	
	public ArrayList<String> RateRecommend() {
		
//getting the book recommendation list		
		
		ArrayList<String> recommendation = new ArrayList<String>();

//saving the user id so that the program can get the user rating based book recommendation
		
		String userId = user.getId();
		
//get the book recommendation and store them in an arraylist	
		
		try {
			UserRecommender userRec = new UserRecommender(userId, isbnToIds, isbnToTitle);
			titles = userRec.getTitles();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TasteException e) {
			e.printStackTrace();
		}

		
//check if no recommendation is returned. this could happen if the system can't find a good recommendation		
		
		if (titles.isEmpty()){
			titles.add("sorry we didn't find any recommendations");
			return titles;
		}
		
		
		return titles;
		
	}
	
	
}
