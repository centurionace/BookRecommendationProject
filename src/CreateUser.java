import java.util.HashMap;
import java.util.Scanner;

import scala.Int;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class CreateUser {

	private HashMap<Integer, Integer> useraccount = new HashMap<Integer, Integer>();
	private File input;
	private Scanner scan;
	private PrintWriter print;
	private int username;
	private int password;
	private String name;
	private String code;

/**
 * This class allows the user to create a new username and password for our program
 * @author Ace	
 */
	
	public CreateUser(){
		
	}

//this method takes in a user name and password the user wants to create	
	
	public int CreatNewUser(int newusername, int newpassword){

//it first reads our data file, and make sure the same username doesn't already exist		
		
		name = Integer.toString(newusername);
		code = Integer.toString(newpassword);
		try{
			input = new File("UserAccountPassword.txt");
			scan = new Scanner(input);
			
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("system error, please contact provider");
		}
		while (scan.hasNextLine()){
			username = scan.nextInt();
			password = scan.nextInt();
			useraccount.put(username, password);
		}
		scan.close();
		if (useraccount.containsKey(newusername)){
			return 0;
		}

//then it uses a buffered reader to add the new username and password to our data file		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("UserAccountPassword.txt", true));
			bw.newLine();
			bw.write(name + " " + code);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		return 1;
		
		
	}
	
	
}
