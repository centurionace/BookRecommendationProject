import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This is a class to save user data in a csv file
 * @author Joseph
 *
 */
public class SaveUserData {
	private User user;
	private String id;
	private ArrayList<Book> userBooks;
	ArrayList<String> holder;
	
	
	/**
	 * Constructor takes in a user object
	 * @param newUser
	 */
	public SaveUserData(User newUser){
		user = newUser;
		userBooks = user.getBookLibrary();
		id = user.getId();
		holder = new ArrayList<String>();
		save();
	}
	
	/**
	 * Save method puts the users data into a readable format
	 * 
	 */
	private void save(){		
		String data = id;
		String l = "";
		String q = "";
		for(Book b : userBooks){
			l = b.getIsbn();
			if(l.isEmpty()){
				continue;
			}
			else{
				q ="," + l;
				data += q;
			}
		}
		data += "\n";
		
		
		try{
			BufferedReader fr = new BufferedReader(new FileReader("data/userdata.csv"));
			
			String line;
			while((line = fr.readLine()) != null){
				holder.add(line);
				
			}
			fr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		replaceLine(data);
		rewrite();
	}
	
	private void replaceLine(String data){
		boolean alreadyInFile = false;
		for(int i = 0; i < holder.size(); i++){
			String test = holder.get(i);
			String[] split = test.split(",");
			if (split[0].equals(id)){
				System.out.println("Test Hit");
				alreadyInFile = true;
				holder.set(i, data);
			}
		}
		
		if(alreadyInFile == false){
			holder.add(data);
		}
	}
	
	private void rewrite(){
		try{
			BufferedWriter file = new BufferedWriter(new FileWriter("data/userdata.csv"));
			
			for (String s : holder){
				System.out.println(s);
				file.write(s);
				
			}
			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
