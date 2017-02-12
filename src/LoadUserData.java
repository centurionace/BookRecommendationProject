import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.*;
import org.codehaus.jackson.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;

import scala.util.parsing.json.JSON;
/**
 * This class finds the users data in a csv file and loads their information
 * Data is from the isbn numbers
 * @author Joseph
 *
 */
public class LoadUserData {
	
	private String id;
	private User user;
	private ArrayList<String> bookIsbn;
	private ArrayList<String> ratings;
	
	/**
	 * Constructor takes the user id
	 * Then it creates a new object
	 * @param userId
	 */
	public LoadUserData(String userId){
		id = userId;
		user = new User(id);
		bookIsbn = new ArrayList<String>();
		getData();
		findBooks();
	}
	
	/**
	 * Get data method fills an array list with isbn numbers
	 */
	private void getData(){
		
		try{
			BufferedReader fr = new BufferedReader(new FileReader("data/userdata.csv"));
					
			String line;
			while((line = fr.readLine()) != null){
				String[] info = line.split(",");
				if (info[0].equals(id)){
					for(int i = 1; i< info.length; i++){
						bookIsbn.add(info[i]);
					}
				}
				
			}
			fr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * FindBooks uses the isbn numbers in our array list to get book information
	 * Then adds those books to the users library
	 */
	private void findBooks(){
		for (int i = 0; i < bookIsbn.size(); i++){
			FindBookFromIsbn book = new FindBookFromIsbn(bookIsbn.get(i));
			Book newBook = book.getBook();
			user.addBookToLibrary(newBook);
		}
	}
	
	public User getUser(){
		return user;
	}
	

}
