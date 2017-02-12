import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * Class to find all matches in our book dataset
 * @author Joseph
 *
 */
public class FindMatches {
	private HashMap<String, String> bookMatches;
	private String finalTitle;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String pubYear;
	private String frontCoverURL;
	private ArrayList<String> books;
	
	public FindMatches(String theTitle){
		
		title = theTitle;
		bookMatches = new HashMap<String, String>();
		books = new ArrayList<String>();
		getInfo();
		findMatch();
	}
	
	/**
	 * Method to search the Book crossing data base for book titles given the user title
	 * Stores those books and their Isbns to a hashmap
	 * Next method will ask the user to choose the book
	 */
	private void getInfo(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("data/books.csv"));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				String titleTest = title.toLowerCase();
				String test = info[1].toLowerCase();
				if(test.contains(titleTest)){
					bookMatches.put(info[1], info[0]);
				}
			}
			
			reader.close();
				
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Method that asks the user to specify which book they would choose from a book search
	 */
	private void findMatch(){
		Set<String> keySet = bookMatches.keySet();
		for(String s : keySet){
			books.add(s);
		}
	}

	/**
	 * Getter method for the matches 
	 */
	public ArrayList<String> getMatches(){
		return books;
	}
}
