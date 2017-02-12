import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	private String userId = "12345678";
	private String isbn = "122332";
	private String title = "A book";
	private String author = "A writer";
	private String pubYear = "1998";
	private String publisher = "Random";
	private String url = "http://awebsite";
	
	@Before
	public void setup(){
		user = new User(userId);
	}
	
	@Test
	public void testUserId() {
		String id = user.getId();
		assertEquals("Id must match the one given", id, userId);
	}
	
	@Test
	public void testAddBook(){
		Book newBook = new Book(isbn, title, author, pubYear, publisher, url);
		user.addBookToLibrary(newBook);
		assertNotNull("Book library can't be null", user.getBookLibrary());
	}
	
	@Test
	public void testBookContents(){
		Book newBook = new Book(isbn, title, author, pubYear, publisher, url);
		user.addBookToLibrary(newBook);
		ArrayList<Book> bookLibrary = user.getBookLibrary(); 
		Book book = bookLibrary.get(0);
		String title1 = book.getTitle(); 
		assertEquals("Book library can't be null", title1, title);
	}

}
