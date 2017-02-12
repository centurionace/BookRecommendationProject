import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private Book book;
	private String isbn = "122332";
	private String title = "A book";
	private String author = "A writer";
	private String pubYear = "1998";
	private String publisher = "Random";
	private String url = "http://awebsite";
	
	@Before
	public void setup(){
		book = new Book(isbn, title, author, publisher, pubYear, url);
	}
	
	@Test
	public void test() {
		assertNotNull("book cannot be null", book);
	}
	
	@Test
	public void testGetIsbn(){
		String isbnTest = book.getIsbn();
		assertEquals("isbn returned should equal isbn in the constructor", isbnTest, isbn);
	}

	@Test 
	public void testGetTitle(){
		String titleTest = book.getTitle();
		assertEquals("title returned should equal title in the constructor", titleTest, title);
	}
	
	@Test
	public void testGetAuthor(){
		String authorTest = book.getAuthor();
		assertEquals("author returned should equal author in the constructor", authorTest, author);
	}
	
	@Test
	public void testGetPublisher(){
		String pubTest = book.getPublisher();
		assertEquals("publisher returned should equal publisher in the constructor", pubTest, publisher);
	}
	
	@Test
	public void testGetPubYear(){
		String yearTest = book.getPubYear();
		assertEquals("title returned should equal title in the constructor", yearTest, pubYear);
	}
	
	@Test
	public void testGetURL(){
		String urlTest = book.getFrontCoverURL();
		assertEquals("title returned should equal title in the constructor", urlTest, url);
	}
	
	@Test
	public void testAddRating(){
		String rate = "10.0";
		book.addRating(rate);
		String rating = book.getRating();
		assertEquals("Rating cannot must equal rating given in constructor", rate, rating);
	}
	
	

}
