package sait.bms.problemdomain;

/**
 * Class PeriodicalsBooks that describe the PeriodicalsBooks object and extended
 * from Book.
 * 
 * @author Hanin
 * @author Henry
 * @author Deborah 
 * @version February 2022
 */

public class PeriodicalsBooks extends Book {

	private char frequency;

	/***
	 * Constructor creates an PeriodicalsBooks object with default values.
	 */
	public PeriodicalsBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/***
	 * Constructor creates an PeriodicalsBooks object with assigned parameters .
	 * 
	 * @param isbn
	 * @param callNum
	 * @param availableNum
	 * @param total
	 * @param title
	 * @param frequency
	 */

	public PeriodicalsBooks(long isbn, String callNum, int availableNum, int total, String title, char frequency) {
		super(isbn, callNum, availableNum, total, title);
		this.frequency = frequency;
	}

	/***
	 * method that return frequency
	 * 
	 * @return frequency
	 */

	public char getFrequency() {
		return frequency;
	}

	/***
	 * method that set the frequency to the frequency provided
	 * 
	 * @param frequency
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}

	/***
	 * method that change the char into a String world
	 * 
	 * @return fullFrequency
	 */
	public String fullFrequency(char frequency) {
		String fullFrequency = null;
		if (frequency == 'D') {
			fullFrequency = "Daily";
		} else if (frequency == 'W') {
			fullFrequency = "Weekly";
		} else if (frequency == 'M') {
			fullFrequency = "Monthly";
		} else if (frequency == 'B') {
			fullFrequency = "Bi-monthly";
		} else if (frequency == 'Q') {
			fullFrequency = "Quarterly";
		}
		return fullFrequency;
	}

	@Override
	public String toString() {
		return "ISBN:		" + getIsbn() + "\n" + "Call Number:    " + getCallNum() + "\n" + "Available:	"
				+ getavailableNum() + "\n" + "Total:		" + getTotal() + "\n" 
				+ "Title:		" + getTitle()+"\n"+ "Frequency:      "
				+ fullFrequency(frequency) + "\n";
	}

}
