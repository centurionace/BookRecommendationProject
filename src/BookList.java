import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
/**
 * This class provides the books given a specific user account
 * @author Ace
 *
 */


public class BookList {

	private File input;
	private Scanner scan;
	private ArrayList<String> booklist = new ArrayList<String>();
	private String bookstorage;
	
//user call this function with an argument of username	
	
	public BookList(String username){
		
//the program will reading the file saved for each user and return an array list of strings of booknames
		
		try{
			input = new File(username+".txt");
			scan = new Scanner(input);
		}
		//reading the file and catch an exception
		catch (FileNotFoundException fnfe){
			System.out.println("system error, please contact provider");
		}
		//store all the book information into an arraylist
		while (scan.hasNextLine()){
			bookstorage = scan.nextLine();
			booklist.add(bookstorage);
			scan.nextLine();
			scan.nextLine();
		}
		
	}
	
	public ArrayList<String> getnames(){
		//providing getter method to get the book list
		return booklist;
		
	}
}
