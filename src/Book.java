
/**
 * This class holds the information pertaining to a specific book
 * @author Joseph
 *
 */
public class Book {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String pubYear;
	private String frontCoverURL;
	private String rating;

	
	/**
	 * Constructor for book class
	 * Book class holds information for a single book
	 * @param newISBN isbn for the book
	 * @param newTitle books title
	 * @param newAuthor books author
	 * @param newPub books publisher
	 * @param newPubYear book's publication year
	 */
	public Book(String newISBN, String newTitle, String newAuthor, String newPub, String newPubYear, String url){
		isbn = newISBN;
		title = newTitle;
		author = newAuthor;
		publisher = newPub;
		pubYear = newPubYear;
		frontCoverURL = url;
	}
	
	/**
	 * Method to get the front cover url
	 * @return String url for cover jpg
	 */
	public String getFrontCoverURL() {
		return frontCoverURL;
	}

	/**
	 * Getter for the books isbn
	 * @return String Isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * Getter for the book title
	 * @return String book title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * getter for the book's author
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * getter for the publisher
	 * @return String publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Getter for the publication year
	 * @return String publication year
	 */
	public String getPubYear() {
		return pubYear;
	}

	/**
	 * getter for the user rating
	 * @return String rating
	 */
	public String getRating() {
		return rating;
	}

	
	/**
	 * Method to add a rating to the book
	 * Ratings on a scale of 1-10
	 * @param rate String rating 
	 */
	public void addRating(String rate){
		rating = rate;
	}
}
