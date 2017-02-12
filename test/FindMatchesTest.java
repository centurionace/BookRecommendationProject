import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FindMatchesTest {

	private String title;
	private FindMatches find;
	
	@Before
	public void setup(){
		title = "Infinite Jest";
		find = new FindMatches(title);
	}
	
	@Test
	public void testFindMatches() {
		ArrayList<String> matches = find.getMatches();
		assertNotNull("Returned matches should not be null", matches);
	}

	@Test
	public void testGetMatches() {
		ArrayList<String> matches = find.getMatches();
		assertEquals("Must contain the specified novel", matches.get(0), "Infinite Jest : A Novel");
	}

}
