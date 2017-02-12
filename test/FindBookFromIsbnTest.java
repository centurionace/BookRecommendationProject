import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindBookFromIsbnTest {

	private String isbn;
	private FindBookFromIsbn find;
	
	@Before
	public void setup(){
		isbn = "0451525221";
		find = new FindBookFromIsbn(isbn);
	}
	
	@Test
	public void testFindBookFromIsbn() {
		Book title = find.getBook();
		assertEquals("Book found must match given book", isbn, title.getIsbn());
	}

	@Test
	public void testGetBook() {
		Book title = find.getBook();
		assertEquals("Book found must match given book", title.getTitle(), "Scarlet Letter");
	}

}
