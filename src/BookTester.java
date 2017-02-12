

import java.io.IOException;
import java.util.HashMap;
import org.apache.mahout.cf.taste.common.TasteException;

public class BookTester {

	public static void main(String[] args) throws IOException, TasteException {	
		
//		DataFix fix = new DataFix("data/BX-Book-Ratings.csv", "book-ratings.csv");
//		DataFix fix2 = new DataFix("data/BX-Books.csv", "books.csv");
//		
//		IDFix isbns = new IDFix("data/book-ratings.csv", "data/book-ratingsV2.csv", "data/isbn-id-map.csv");
		
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		HashMap<String, String> isbnToTitle = data.getIsbnToTitle();
		HashMap<String, String> idToIsbn = data.getIdToIsbn();
		HashMap<String, String> isbnToIds = data.getIsbnToIds();
		
		String userId = "107718";
		UserRecommender userRec = new UserRecommender(userId, isbnToIds, isbnToTitle);
		userRec.printRecommendations();
		
//		FindBookInfo findBook = new FindBookInfo("Great Expectations");
//		Book book = findBook.getBook();
//		String isbn = "0440118204";
//		ItemRecommender items = new ItemRecommender(book.getIsbn(), idToIsbn, isbnToIds, isbnToTitle);
//		items.printRecommendations();
		
		

		
		
	}

}
