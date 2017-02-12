import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindBookInfoTest {

	private String title;
	private FindBookInfo find;
	
	@Before
	public void setup(){
		title = "Romeo and Juliet";
		find = new FindBookInfo(title);
	}

	@Test
	public void testGetBook() {
		Book b = find.getBook();
		assertNotNull("Book cannot be null", b);
	}
	
	@Test
	public void testResult(){
		Book b = find.getBook();
		assertEquals("Book title must match given", b.getTitle(), title);
	}

	@Test
	public void testResult1(){
		Book b = find.getBook();
		System.out.println(b.getAuthor());
		assertEquals("Book Author must match given", b.getAuthor(), "William Shakespeare");
	}
}
