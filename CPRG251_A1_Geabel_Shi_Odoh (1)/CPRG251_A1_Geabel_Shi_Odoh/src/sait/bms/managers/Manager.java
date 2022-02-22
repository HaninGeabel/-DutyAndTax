/**	
 * Class Book that describe the book object.
 * @author Hanin
 * @author Henry
 * @author Deborah 
 * Feb 2022
 */
package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrenBooks;
import sait.bms.problemdomain.CookBooks;
import sait.bms.problemdomain.Paperbacks;
import sait.bms.problemdomain.PeriodicalsBooks;
/**
 * @author Hanin
 * @author Henry
 * @author Deborah
 * @version February 2, 2022
 */
public class Manager {
	private static ArrayList<Book> books = new ArrayList<>();
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Constructor creates a manager object with default values.
	 */
	public Manager() throws IOException {
		loadBooks();
		printList();
	}

	/**
	 * method that adds the books in the text file to an array list
	 */
	private ArrayList<Book> loadBooks() throws FileNotFoundException {
		// ArrayList<Book> books = new ArrayList<Book>();
		Scanner in = new Scanner(new File("res/books.txt"));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] bookProperties = line.split(";");
			Long ISBN = Long.parseLong(bookProperties[0]);
			long lastDigit = Math.abs(ISBN % 10);

			if (Long.toString(ISBN).endsWith("0") || Long.toString(ISBN).endsWith("1")) {
				Book childrenBook = new ChildrenBooks(ISBN, bookProperties[1], Integer.parseInt(bookProperties[2]),
						Integer.parseInt(bookProperties[3]), bookProperties[4], bookProperties[5],
						bookProperties[6].charAt(0));
				books.add((ChildrenBooks) childrenBook);
			}

			if (Long.toString(ISBN).endsWith("2") || Long.toString(ISBN).endsWith("3")) {
				Book cookBook = new CookBooks(ISBN, bookProperties[1], Integer.parseInt(bookProperties[2]),
						Integer.parseInt(bookProperties[3]), bookProperties[4], bookProperties[5],
						bookProperties[6].charAt(0));
				books.add((CookBooks) cookBook);
			}

			if (Long.toString(ISBN).endsWith("8") || Long.toString(ISBN).endsWith("9")) {
				Book periodical = new PeriodicalsBooks(ISBN, bookProperties[1], Integer.parseInt(bookProperties[2]),
						Integer.parseInt(bookProperties[3]), bookProperties[4], bookProperties[5].charAt(0));
				books.add((PeriodicalsBooks) periodical);
			}

			if (lastDigit > 3 && lastDigit < 8) {
				Book paperback = new Paperbacks(ISBN, bookProperties[1], Integer.parseInt(bookProperties[2]),
						Integer.parseInt(bookProperties[3]), bookProperties[4], bookProperties[5],
						Integer.parseInt(bookProperties[6]), bookProperties[7].charAt(0));
				books.add((Paperbacks) paperback);
			}

		}
		in.close();
		return books;
	}

	/**
	 * method that  takes the books stored in the array list and writes them back to the books.txt file
	 */
	private void saveBooksToFile() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("res/books.txt"));

		for (int i = 0; i < books.size(); i++) {
			Long ISBN = books.get(i).getIsbn();
			long lastDigit = Math.abs(ISBN % 10);

			if (Long.toString(ISBN).endsWith("0") || Long.toString(ISBN).endsWith("1")) {
				out.println(books.get(i).getIsbn() + ";" + books.get(i).getCallNum() + ";"
						+ books.get(i).getavailableNum() + ";" + books.get(i).getTotal() + ";" + books.get(i).getTitle()
						+ ";" + ((ChildrenBooks) books.get(i)).getAuthors() + ";"
						+ ((ChildrenBooks) books.get(i)).getFormat());
			}

			if (Long.toString(ISBN).endsWith("2") || Long.toString(ISBN).endsWith("3")) {
				out.println(books.get(i).getIsbn() + ";" + books.get(i).getCallNum() + ";"
						+ books.get(i).getavailableNum() + ";" + books.get(i).getTotal() + ";" + books.get(i).getTitle()
						+ ";" + ((CookBooks) books.get(i)).getPublisher() + ";" + ((CookBooks) books.get(i)).getDiet());
			}

			if (Long.toString(ISBN).endsWith("8") || Long.toString(ISBN).endsWith("9")) {
				out.println(books.get(i).getIsbn() + ";" + books.get(i).getCallNum() + ";"
						+ books.get(i).getavailableNum() + ";" + books.get(i).getTotal() + ";" + books.get(i).getTitle()
						+ ";" + ((PeriodicalsBooks) books.get(i)).getFrequency());
			}

			if (lastDigit > 3 && lastDigit < 8) {
				out.println(books.get(i).getIsbn() + ";" + books.get(i).getCallNum() + ";"
						+ books.get(i).getavailableNum() + ";" + books.get(i).getTotal() + ";" + books.get(i).getTitle()
						+ ";" + ((Paperbacks) books.get(i)).getAuthor() + ";" + ((Paperbacks) books.get(i)).getYear()
						+ ";" + ((Paperbacks) books.get(i)).getGenre());
			}
		}
		out.close();
	}

	/**
	 * method that help the user to search for specific book based on the ISBN
	 */
	private void checkOutBook() {
		//Scanner in = new Scanner(System.in);
		System.out.print("Enter ISBN of book: ");
		long isbnInPut = in.nextLong();
		int count;
		for (int i = 0; i < books.size(); i++) {
			count = books.get(i).getavailableNum();
			if (isbnInPut == books.get(i).getIsbn()) {
				if (count > 0) {
					System.out.println("The book '" + books.get(i).getTitle() + "' has been checked out.");
					System.out.println("It can be located using a call number: " + books.get(i).getCallNum());
					count--;
					books.get(i).setAvailable(count);
					return;
				} else {
					System.out.println("The book with this ISBN is not available.");
					return;
				}
			}

		}
		System.out.println("The book with this ISBN does not exist.");
	}

	/**
	 * method that display the list and based on the number option, the method will
	 * be executed
	 * 
	 * @throws IOException
	 */
	private void printList() throws IOException {
		int option=7;
		while (option!=5) {
		System.out.println("\n Welcome in ABC Book Company: How May We Assist You?");
		System.out.println("1	Checkout Book");
		System.out.println("2	Find Books by Title");
		System.out.println("3	Display Books by Type");
		System.out.println("4	Produce Random Book List");
		System.out.println("5	Save & Exit");
		System.out.println();
		System.out.print("Enter option: ");
		option = in.nextInt();

		switch (option) {
		case 1:
			checkOutBook();
			break;
		case 2:
			searchByTitle();
			break;
		case 3:
			displayBookType();
			break;
		case 4:
			randomBook();
			break;
		case 5:
			saveBooksToFile();
			break;

		default:
			System.out.println("Please try again and enter one of the options. ");

		}
		}

	}

	/**
	 * method that asked the user to input the number of books that the method will
	 * display randomly
	 */
	private void randomBook() {
		System.out.print("Enter number of books: ");
		int numberOfBooks = in.nextInt();
		System.out.println();
		if (numberOfBooks > 0) {
			System.out.println("Random books: ");
			for (int i = 0; i < numberOfBooks; i++) {
				int random = (int) (Math.random() * books.size());
				System.out.println(books.get(random));
			}

		} else {
			System.out.println("Try again and Enter number >0 ");
		}
	}

	/**
	 * method that help the user to display a type of book
	 */
	private void displayBookType() {
		System.out.println("#     Type");
		System.out.println("1     Children's Books");
		System.out.println("2     Cookbooks");
		System.out.println("3     Paperbacks");
		System.out.println("4     Periodicals");
		System.out.println();
		System.out.print("Enter type of book: ");
		int typeOfBook = in.nextInt();

		switch (typeOfBook) {
		case 1:
			System.out.print("Enter a format(P for Picture book; E for Early Readers; C for Chapter book.");
			char inputFormat = Character.toUpperCase(in.next().charAt(0));// user input for format
			System.out.println("Matching books:");
			for (int i = 0; i < books.size(); i++) { // compare format in arrayList to the user input
				if (books.get(i) instanceof ChildrenBooks
						&& ((ChildrenBooks) books.get(i)).getFormat() == inputFormat) {
					System.out.println(books.get(i));
				}
			}
			break;
		case 2:
			System.out.print(
					"Enter a diet (D for Diabetic, V for Vegetarian, G for Gluten-free,I for International, N for None): ");
			char inputDiet = Character.toUpperCase(in.next().charAt(0));// user input for diet
			System.out.println();
			System.out.println("Matching books:");
			for (int i = 0; i < books.size(); i++) {// compare diet in arrayList to the user input
				if (books.get(i) instanceof CookBooks && ((CookBooks) books.get(i)).getDiet() == inputDiet) {
					System.out.println(books.get(i));
				}
			}
			break;
		case 3:
			System.out.print(
					"Enter a genre (A for Adventure, D for Drama, E for Education,C for Classic, F for Fantasy, S for Science Fiction): ");
			char inputGenre = Character.toUpperCase(in.next().charAt(0));// user input for genre
			System.out.println();
			System.out.println("Matching books:");
			for (int i = 0; i < books.size(); i++) {// compare genre in arrayList to the user input
				if (books.get(i) instanceof Paperbacks && ((Paperbacks) books.get(i)).getGenre() == inputGenre) {
					System.out.println(books.get(i));

				}
			}
			break;
		case 4:
			System.out.print(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly):");
			char inputFrequency = Character.toUpperCase(in.next().charAt(0));// user input for frequency
			System.out.println("Matching books:");
			for (int i = 0; i < books.size(); i++) {// compare frequency in arrayList to the user input
				if (books.get(i) instanceof PeriodicalsBooks
						&& ((PeriodicalsBooks) books.get(i)).getFrequency() == inputFrequency) {
					System.out.println();
					System.out.println(books.get(i));
				}
			}
			break;
		}
	}

	/**
	 * method that help the user to search for specific book based on the title
	 */
	private void searchByTitle() {

		System.out.print("Enter title to search for: ");
		in.nextLine();
		int num = 2;
		String titleBook = in.nextLine();
		System.out.println("Matching books: ");
		System.out.println();
		for (int i = 0; i < books.size(); i++) {
			if ((books.get(i).getTitle()).toLowerCase().contains(titleBook.toLowerCase())) {

				System.out.println(books.get(i));
				num = 2;

			}

		}

		if (num != 2) {

			System.out.println(titleBook + " Book not found!");
		}
	}

}
