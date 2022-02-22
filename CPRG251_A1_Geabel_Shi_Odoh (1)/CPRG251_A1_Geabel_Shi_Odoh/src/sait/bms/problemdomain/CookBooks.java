package sait.bms.problemdomain;
/**	
 * Class CookBooks that describe the CookBooks object and extended from Book.
 * @author Hanin
 * @author Henry
 * @author Deborah 
 * @version February 2022
 */
public class CookBooks extends Book{
private String publisher;
private char diet;
/***
 * Constructor creates an CookBooks object with default values.
 */
public CookBooks() {
	super();
	// TODO Auto-generated constructor stub
}
/***
 * Constructor creates an CookBooks object with assigned parameters .
 * @param isbn
 * @param callNum
 * @param availableNum
 * @param total
 * @param title
 * @param publisher
 * @param diet
 */
public CookBooks(long isbn, String callNum, int availableNum, int total, String title, String publisher, char diet) {
	super(isbn, callNum, availableNum, total, title);
	this.publisher = publisher;
	this.diet = diet;
}
/**
 * method that return publisher
 * @return publisher
 */
public String getPublisher() {
	return publisher;
}
/***
 * method that set the publisher to the publisher provided 
 * @param publisher
 */
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
/**
 * method that get the diet
 * @return publisher
 */
public char getDiet() {
	return diet;
}
/***
 *  method that set the diet to the diet provided 
 * @param diet
 */
public void setDiet(char diet) {
	this.diet = diet;
}
/***
 * method that change the char into a String world
 * @return fullDiet
 */
public String fullDiet(char diet) {
	String fullDiet =null;
	if(diet=='D') {
		fullDiet = "Diabetic";
	}else if(diet=='V') {
		fullDiet = "Vegetarian";
	}else if(diet=='G') {
		fullDiet = "Gluten-free";
	}else if(diet=='I') {
		fullDiet = "International";
	}else if(diet=='N') {
		fullDiet = "None";
	}
	return fullDiet;
}

@Override
public String toString() {
	return "ISBN:		" + getIsbn()+"\n"+ "Call Number:    " + getCallNum()+"\n"+
			"Available:	" + getavailableNum() +"\n"+ "Total:		" + getTotal()+"\n"
			+ "Title:		" + getTitle()+"\n"+"Publisher:      "+getPublisher()
			+"\n"+"Diet:           "+fullDiet(diet)+"\n" ;
}

	

}
