package sait.bms.problemdomain;

/**
 * Class Paperbacks that describe the CookBooks object and extended from Book.
 * 
 * @author Hanin
 * @author Henry
 * @author Deborah 
 * @version February 2022
 */
public class Paperbacks extends Book {
	private String author;
	private int year;
	private char genre;

	/***
	 * Constructor creates an Paperbacks object with default values.
	 */
	public Paperbacks() {
		super();
		// TODO Auto-generated constructor stub
	}
	/***
	 * Constructor creates an Paperbacks object with assigned parameters .
	 * @param isbn
	 * @param callNum
	 * @param availableNum
	 * @param total
	 * @param title
	 * @param author
	 * @param year
	 * @param genre
	 */
	public Paperbacks(long isbn, String callNum, int availableNum, int total, String title, String author, int year,
			char genre) {
		super(isbn, callNum, availableNum, total, title);
		this.author = author;
		this.year = year;
		this.genre = genre;
	}
	/**
	 * method that return authors
	 * @return authors
	 */
	public String getAuthor() {
		return author;
	}
	/***
	 * method that set the author to the author provided 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * method that return year
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/***
	 * method that set the year to the year provided 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * method that return genre
	 * @return genre
	 */
	public char getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}
	/***
	 * method that change the char into a String world
	 * @return FullGenre
	 */
	public String FullGenre(char genre) {
		String fullGenre = null;
		if (genre == 'A') {
			fullGenre = "Adventure";
		} else if (genre == 'D') {
			fullGenre = "Drama";
		} else if (genre == 'E') {
			fullGenre = "Education";
		} else if (genre == 'C') {
			fullGenre = "Classic";
		} else if (genre == 'F') {
			fullGenre = "Fantasy";
		} else if (genre == 'S') {
			fullGenre = "Science Fiction";
		}
		return fullGenre;
	}

	@Override
	public String toString() {
		return "ISBN:		" + getIsbn() + "\n" + "Call Number:    " + getCallNum() + "\n" + "Available:	"
				+ getavailableNum() + "\n" + "Total:		" + getTotal() + "\n" + "Title:		" + getTitle() + "\n"
				+ "Authors:	" + author + "\n" + "Year:           " + getYear() + "\n" + "Genre:          "
				+ FullGenre(genre) + "\n";
	}
}