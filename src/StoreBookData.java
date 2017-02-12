

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * This class takes in the book data set
 * It separates the csv values and stores them to hashmaps
 * @author Joseph
 *
 */
public class StoreBookData {
	String bookFile;
	String isbnFile;
	private HashMap<String, String> isbnToTitle;
	private HashMap<String, String> idToIsbn;
	private HashMap<String, String> titleToIsbn;
	private HashMap<String, String> isbnToIds;
	
	public StoreBookData(String books, String isbnIds){
		bookFile = books;
		isbnFile = isbnIds;
		isbnToTitle = new HashMap<String, String>();
		idToIsbn = new HashMap<String, String>();
		titleToIsbn = new HashMap<String, String>();
		isbnToIds = new HashMap<String, String>();
		findIsbnToTitles();
		findIsbnIdToIsbn();
		findTitleToIsbn();
		findIsbntoIsbnIds();
	}
	
	/**
	 * Method to create a hashmap of isbns to titles
	 * keys are the isbn
	 * values are the title
	 * Taken from the book crossing data
	 */
	
	private void findIsbnToTitles(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(bookFile));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				isbnToTitle.put(info[0], info[1]);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method to create a hashmap of isbn ids to isbn numbers all in string format
	 * key are the String ids
	 * values are the String isbn numbers
	 */
	private void findIsbnIdToIsbn(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(isbnFile));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				idToIsbn.put(info[1], info[0]);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method to create a hashmap from titles to isbn numbers
	 */
	private void findTitleToIsbn(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(bookFile));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				titleToIsbn.put(info[1], info[0]);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to create a hashmap from isbn numbers to isbn ids
	 */
	private void findIsbntoIsbnIds(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(isbnFile));
			
			String line;
			while((line = reader.readLine()) != null){
				String[] info = line.split(",");
				isbnToIds.put(info[0], info[1]);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getter method for isbn title hash map
	 * @return hashmap isbn to title
	 */
	public HashMap<String, String> getIsbnToTitle() {
		return isbnToTitle;
	}

	/**
	 * getter method for id to isbn hashmap
	 * @return id to isbn hashmap
	 */
	public HashMap<String, String> getIdToIsbn() {
		return idToIsbn;
	}

	public HashMap<String, String> getTitleToIsbn() {
		return titleToIsbn;
	}


	public HashMap<String, String> getIsbnToIds() {
		return isbnToIds;
	}

	
	
	
	
}
