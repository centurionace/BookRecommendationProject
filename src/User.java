import java.util.ArrayList;

/**
 * User clss
 * Holds user id and an array list of book objects
 * @author Joseph
 *
 */
public class User {

	private String id;
	private ArrayList<Book> bookLibrary;
	
	/**
	 * Constructor takes id and creates Book ArrayList object
	 * @param userId
	 */
	public User(String userId){
		id = userId;
		bookLibrary = new ArrayList<Book>();
	}

	/**
	 * Getter method for id
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter method for book library
	 * @return arrayList<Book>
	 */
	public ArrayList<Book> getBookLibrary() {
		return bookLibrary;
	}
	
	/**
	 * Add book to user library
	 * @param b Book
	 */
	public void addBookToLibrary(Book b){
		bookLibrary.add(b);
	}
	
}
