package sait.bms.problemdomain;
/**	
 * 
 * @author Hanin
 * @author Henry
 * @author Deborah 
 * @version February 2022
 * Class ChildrenBooks that describe the ChildrenBooks object and extended from Book.
 */
public class ChildrenBooks extends Book{
private String authors; 
private char format;

 /**
 *  Constructor creates aChildrenBooks object with default values.
 */

public ChildrenBooks() {
	super();
	// TODO Auto-generated constructor stub
}
/***
 * class constructor that we can create an object by passing the parameters
 * @param isbn
 * @param callNum
 * @param availableNum
 * @param total
 * @param title
 * @param authors
 * @param format
 */
public ChildrenBooks(long isbn, String callNum, int availableNum, int total, String title, String authors,
		char format) {
	super(isbn, callNum, availableNum, total, title);
	this.authors = authors;
	this.format = format;
}
/**
 * method that return authors
 * @return authors
 */

public String getAuthors() {
	return authors;
}

/***
 * method that set the author to the author provided  
 * @param authors
 */
public void setAuthors(String authors) {
	this.authors = authors;
}
/***
 * method that return format
 * @return format
 */
public char getFormat() {
	return format;
}
/***
 *  method that set the format to the format provided  
 * @param format
 */
public void setFormat(char format) {
	this.format = format;
}
/***
 * method that change the char into a String world
 * @return fullFormat
 */
public String changeFormat(char format) {
	String fullFormat = null;
	if(format=='P') {
		fullFormat = "Picture book";
	}else if(format=='E') {
		fullFormat = "Early Readers";
	}else if(format=='C') {
		fullFormat = "Chapter book";
	}
	return fullFormat;
}

@Override
public String toString() {
	return "ISBN:		" + getIsbn()+"\n"+ "Call Number:    " + getCallNum()+"\n"+
			"Available:	" + getavailableNum() +"\n"+ "Total:		" + getTotal()+"\n"
			+ "Title:		" + getTitle()+"\n"+"Authors:	" + authors + "\n"+
			"Format:		" + changeFormat(format) +"\n"  ;
			
}


	

}
