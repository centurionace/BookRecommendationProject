import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.mahout.cf.taste.common.TasteException;
import org.junit.Before;
import org.junit.Test;

public class UserRecommenderTest {

	private ArrayList<String> recommendations;
	
	@Before
	public void setup(){
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		HashMap<String, String> isbnToTitle = data.getIsbnToTitle();
		HashMap<String, String> idToIsbn = data.getIdToIsbn();
		HashMap<String, String> isbnToIds = data.getIsbnToIds();
		String userId = "107718";
		
		try {
			UserRecommender userRec = new UserRecommender(userId, isbnToIds, isbnToTitle);
			recommendations = userRec.getTitles();
		} catch (IOException | TasteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUserRecommender() {
		assertNotNull("Title array cannot be null", recommendations);
	}

	

}
