

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to create a Book object from the book crossing data set
 * @author Joseph
 *
 */
public class FindBookInfo {
	private String finalTitle;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String pubYear;
	private String frontCoverURL;
	
	
	public FindBookInfo(String theTitle){
		finalTitle = theTitle;
		getFinalBook();
	}
	
	
	/**
	 * Method to retrieve book data once a specific book is chosen
	 */
	private void getFinalBook(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("data/books.csv"));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				String titleTest = finalTitle.toLowerCase();
				String test = info[1].toLowerCase();
				if(test.equalsIgnoreCase(titleTest)){
					isbn = info[0];
					title = info[1];
					author = info[2];
					pubYear = info[3];
					publisher = info[4];
					frontCoverURL = info[7];
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
	 * Method to create a new book based on the given title from the user
	 * @return
	 */
	public Book getBook(){
		Book newBook = new Book(isbn, title, author, publisher, pubYear, frontCoverURL);
		return newBook;
	}
	
	
}
