import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class adds a users ratings to our dataset
 * @author Joseph
 *
 */
public class AddRatings {
	private String[] rating;
	private String isbnId;
	private HashMap<String, String> isbnToIds;
	
	/**
	 * Constructor
	 * @param userRating ArrayList containing userid, book isbn, and rating 
	 */
	public AddRatings(String[] userRating){
		rating = userRating;
		add();
	}
	
	
	/**
	 * Append to the file using buffered writer
	 */
	public void add(){
		StoreBookData data = new StoreBookData("data/books.csv", "data/isbn-id-map.csv");
		isbnToIds = data.getIsbnToIds();
		isbnId = isbnToIds.get(rating[1]);
		rating[1] = isbnId;
		
		if(rating[1] != null){
			try{
				BufferedWriter bw = new BufferedWriter(new FileWriter("data/book-ratingsV2.csv", true));
				bw.write(rating[0]+ "," +rating[1] + "," + rating[2]);
				bw.newLine();
				bw.flush();
				bw.close();

			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
