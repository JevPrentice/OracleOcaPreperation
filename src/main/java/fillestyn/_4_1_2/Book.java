package fillestyn._4_1_2;

/**
 * @author fillestyn66
 */
public class Book { // Remove "public" to see the issue.

    public int noOfBooks = 5;
    protected String authorName = "Kevin Karp";
    private double costOfBook = 123.11;
    String tital = "The Trials and tribulation of the Karp";

    protected double getCostOfBook() {
	return costOfBook;
    }
}
