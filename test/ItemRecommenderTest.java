import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.mahout.cf.taste.common.TasteException;
import org.junit.Before;
import org.junit.Test;

public class ItemRecommenderTest {
	private ItemRecommender items;
	
	@Before
	public void setup(){
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		HashMap<String, String> isbnToTitle = data.getIsbnToTitle();
		HashMap<String, String> idToIsbn = data.getIdToIsbn();
		HashMap<String, String> isbnToIds = data.getIsbnToIds();
		String isbn = "0394895894";
		try {
			items = new ItemRecommender(isbn, idToIsbn, isbnToIds, isbnToTitle);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TasteException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testGetTitles() {
		ArrayList<String> titles = items.getTitles();
		assertNotNull("Recommendation titles cannot be null", titles);
	}

}
