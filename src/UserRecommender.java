
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * This class takes a given user and uses the user based recommender to find recommendations
 * @author Joseph
 *
 */
public class UserRecommender {
	private long userID;
	private List<RecommendedItem> recommendations; 
	private HashMap<String, String> isbnIdMap;
	private HashMap<String, String> isbnTitleMap;
	private ArrayList<String> titles;
	
	/**
	 * Constructor takes in id as a string
	 * @param newUserID user id String
	 * @param isbnids Hashmap of isbn numbers as a string and their long values
	 * @param isbnTitles Hashmap of isbn to titles
	 * @throws IOException
	 * @throws TasteException
	 */
	
	public UserRecommender(String newUserID, HashMap<String, String> isbnids, HashMap<String, String> isbnTitles) throws IOException, TasteException{
		userID = Long.parseLong(newUserID);
		isbnIdMap = isbnids;
		isbnTitleMap = isbnTitles;
		titles = new ArrayList<String>();
		getRecommendations();
	}
	
	
	/**
	 * Method to run the apache mahout user based recommender
	 * Uses the given user id in the class to find recommendations for that user
	 * @throws IOException
	 * @throws TasteException
	 */
	private void getRecommendations() throws IOException, TasteException{
		DataModel model = new FileDataModel(new File("data/book-ratingsV2.csv"));
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		recommendations = recommender.recommend(userID, 5);
		for (RecommendedItem recommendation : recommendations) {
			long isbnId = recommendation.getItemID();
			String id = Long.toString(isbnId);
			String isbn = isbnIdMap.get(id);
			String title = isbnTitleMap.get(isbn);
			titles.add(title);
			}
	}
	
	/**
	 * Method to print out the users recommendations by title
	 * Finds title based in isbnids, then isbn, then title
	 */
	
	public void printRecommendations(){
		System.out.println("Your recommendations are: ");
		for(RecommendedItem r : recommendations){
			long isbnId = r.getItemID();
			String id = Long.toString(isbnId);
			String isbn = isbnIdMap.get(id);
			String title = isbnTitleMap.get(isbn);
			System.out.println(title);
		}
	}
	
	/**
	 * Getter method for the titles of recommendations
	 * @return titles array list of string
	 */
	public ArrayList<String> getTitles(){
		return titles;
	}

}
