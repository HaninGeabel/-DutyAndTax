ABC Book Management System 

Written by Hanin, Henry, Deborah  

Block C  group 5 

Feb 2 2022 

 

This program contains three packages: application, problem domain and managers. We set all the four classes that are inherited from the book class in the domain package. Also, we wrote all the utilities in the manager class. In the application package, we put the main class as we create a manager object.  

In the Book class(superclass), we had 5 attributes common to all the types of books: 

ISBN  

Call number 

Available number  

Total  

Title 

The Book class has two constructors (a default constructor and another that takes in all 5 parameters), all the getters, setters, and toString method for all the variables.  

In Children Books (subclass from the book) it has additional variables (authors, format) with two constructors and getters and setters. We added a method that prints the full format because we had a character format in the file, and we need to have a full format. We used if statements to change the format. For example, if the format is “p” the program prints a Picture book.   

We did the same thing for the rest of the subclasses (Paperbacks, Periodicals Books, cookbooks). However, each of the subclasses has distinguished variables.   

  

In the manager class, we created the array list as a field that we store all the books in when we read from the file. We also created the scanner as a field that we need in all the methods. In the manager constructor, we call all the methods that are important to run the code. The first method that will run when we create the object is load from the file. This method reads each line from the text file and splits it based on the delimiter used in the file; in this case the delimiter is “;”. An ArrayList “books” was created to store the list of books in the file, but before it adds the list to the ArrayList, it first checks what type of book it is based on the last digit of the ISBN. The constructor for each type of book is called and the created object is added to the ArrayList.  

After loading the file, the printList method is called to print all the options available to the user; users have 5 options to choose from: 

Check out a book 

Find books by title 

Display books by type 

Produce random book list 

Save and exit 

In that printList function, we put switch cases that will execute that method that the user will choose. The first option checkOutBook will ask the user for the ISBN of the book, and then it will compare the ISBN in the ArrayList of books read from the text file and check the availability of the book. If the book exists and the availability is greater than 0, the book is checked out and its availability reduces by 1. Else, an appropriate message is printed to the user. 

If the user puts 2 as an input, case 2 will execute and will call the searchbyTitle method. In that method, the program asks the user to enter the title and based on that we create a for loop that can search in the array list for that title. The program can search for a full name or even a part of the name as we used ‘to lower case’ to prevent any case-sensitive situation and contain the string. Also, if the user puts a title that is not in the file, we print a text that the book is not found.  We put a condition (if num !=2) to print the not found book correctly.  

If the user enters option 3 displayBookType. There will be 4 choices from the 4 types of books using switch. And in each choice, there will be more detailed classification using if statement to provide choices with character, after getting the user input. There will display all the type of books by user’s choice. 

If the user types 4, the random method will execute. The program will ask the user to enter a number of books that the user wants to see. The program has an if statement to prevent an error if the user inputs a negative number. If the number is positive, we create a loop that starts from 0 until < number of books. Then, inside the loop, the program has math. Random method to pick three objects in the array list and print them 

Finally, if the user enters option 5, The program calls the saveBooksToFile method which saves the content of the books list back to the text file. A file object with the same name as the text file we are reading from is created, and for each array in the books ArrayList, we write the content back into the text file. Because there are different types of books with different variables in them, we still write into the file based on the type of book. 