package sait.bms.problemdomain;

/**
 * Class Book that describe the book object.
 * 
 * @author Hanin
 * @author Henry
 * @author Deborah 
 * @version February 2022
 */
public class Book {
	private long isbn;
	private String callNum;
	private int availableNum;
	private int total;
	private String title;

	/**
	 * Constructor creates a Book object with default values.
	 */
	public Book() {
		// TODO Auto-generated constructor stub
		super();
	}

	/***
	 * Book Constructor that creates a book object from this parameters
	 * 
	 * @param isbn
	 * @param callNum
	 * @param availableNum
	 * @param total
	 * @param title
	 */

	public Book(long isbn, String callNum, int availableNum, int total, String title) {
		super();
		this.isbn = isbn;
		this.callNum = callNum;
		this.availableNum = availableNum;
		this.total = total;
		this.title = title;
	}

	/**
	 * method that return isbn
	 * 
	 * @return isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * method that sets the isbn to the isbn provided
	 * 
	 * @param isbn
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * method that return callNum
	 * 
	 * @return the callNum
	 */

	public String getCallNum() {
		return callNum;
	}

	/**
	 * method that sets the callNum to the callNum provided
	 * 
	 * @param callNum
	 */
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}

	/**
	 * method that return availableNum
	 * 
	 * @return availableNum
	 */
	public int getavailableNum() {
		return availableNum;
	}

	/**
	 * method that sets the availableNum to the availableNum provided
	 * 
	 * @param availableNum
	 */

	public void setAvailable(int availableNum) {
		this.availableNum = availableNum;
	}

	/**
	 * method that return Total
	 * 
	 * @return getTotal
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * method that sets the Total provided to the Total
	 * 
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/***
	 * method that return title
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/***
	 * method that sets the title provided to the title
	 * 
	 * @param title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book \n" + "ISBN:		" + getIsbn() + "\n" + "Call Number:    " + getCallNum() + "\n"
				+ "Available:	" + getavailableNum() + "\n" + "Total:		" + getTotal() + "\n";
	}
}
