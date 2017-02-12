import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class can be called from the UserAccountInterface class 
 * it will provide a way for user to log in to the system
 * @author Ace
 *
 */

public class UserLogin {

	private HashMap<Integer, Integer> useraccount = new HashMap<Integer, Integer>();
	private File input;
	private Scanner scan;
	private int username;
	private int password;

//the program first reads in the data base of usernames and passwords and store them in hashmaps	
	
	public UserLogin(){
		try{
			input = new File("UserAccountPassword.txt");
			scan = new Scanner(input);
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("system error, please contact provider");
		}
	}

//then the program takes in the user inputs of username and password and look for matches	
	
	public int userlogin(int accountinput, int passwordinput){
		
		while (scan.hasNextLine()){
			username = scan.nextInt();
			password = scan.nextInt();
			useraccount.put(username, password);
		}
		
		if (useraccount.containsKey(accountinput)){
			if (passwordinput == useraccount.get(accountinput)){
			return 1;
			}
			else{
				return 2;
			}
		}
		else {
			return 0;
		}
		
	}
	
	
}
