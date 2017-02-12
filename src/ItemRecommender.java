

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class ItemRecommender {
	private long isbnId;
	private String isbn;
	private List<RecommendedItem> recommendations;
	private ArrayList<String> titles;
	private HashMap<String, String> isbnToIdMap;
	private HashMap<String, String> idToIsbnMap;
	private HashMap<String, String> isbnTitleMap;

	/**
	 * Constructor for item based recommender
	 * @param isbn1 isbn number of the book to find recommendations for
	 * @param idToIsbn Hashmap of ids to isbn numbers
	 * @param isbnToId Hashmap of isbn numbers to ids
	 * @param titles hashmap of isbn numbers to titles
	 * @throws IOException
	 * @throws TasteException
	 */
	public ItemRecommender(String isbn1, HashMap<String, String> idToIsbn, HashMap<String, String> isbnToId, HashMap<String, String> userTitles) throws IOException, TasteException{
		isbn = isbn1;
		isbnToIdMap = isbnToId;
		idToIsbnMap = idToIsbn;
		isbnTitleMap = userTitles;
		titles = new ArrayList<String>();
		isbnId = Long.parseLong(isbnToIdMap.get(isbn));
		System.out.println(isbnId);
		getRecommendations();
	}
	
	/**
	 * Method to find book recommendations based on the given book isbn
	 * Uses Apache mahout item based recommender
	 * @throws IOException
	 * @throws TasteException
	 */
	private void getRecommendations() throws IOException, TasteException{
		DataModel model = new FileDataModel(new File("data/book-ratingsV2.csv"));
		TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(model);
		GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(model, sim);
		recommendations = recommender.mostSimilarItems(isbnId, 5);
		for (RecommendedItem recommendation : recommendations){
			long id = recommendation.getItemID();
			String bookId = Long.toString(id);
			String isbn = idToIsbnMap.get(bookId);
			String title = isbnTitleMap.get(isbn);
			if(title == null){
				continue;
			}
			else{
				titles.add(title);
			}
		}
	}
	
	/**
	 * Method to print all recommendations for the given book
	 */
	public void printRecommendations(){
		String book = isbnTitleMap.get(isbn);
		System.out.println("Recommendations for " + book + "\n");
		for (String recommendation : titles){
			System.out.println(recommendation);
		}
	}
	
	/**
	 * getter method for the titles
	 */
	
	public ArrayList<String> getTitles(){
		return titles;
	}
}
