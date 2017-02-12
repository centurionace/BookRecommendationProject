ReadMe for CIT 591 Homework 6
Joe Franz and Ace Zhang

Our project is a book recommender system. It uses Apache mahouts recommender engine to deliver
recommendations to users. The Recommender uses Book Crossing's database of user interactions and books
to find recommendations for a user.

Due to a last minute mistake on github we actually created a new repository to work with
The link is below
https://github.com/josep-mark/Recommender

One important thinhg is that userIds must be numbers of eight digits or more

To be fair I think the book crossing database was not the best choice. It has the right format for the recommender engine
but it distinguishes books by ISBN, which means every publisher and version of a single book is on there. This could skew the data results.

Our project also uses jframe to make a Graphical user interface.

First the program prompts to log in or create a new account
After you are logged in it loads the books you've already rated, if you have done that before
From there you get five options
1. View your books
2. Rate a book
3. Get a book recommendation
4. Get user recommendations
5. Save your books

View your books shows a screen with a list of all the books in a users library

Rate a book
This event prompts the user for a book title
It searches the Book Crossing dataset and returns all books that contain the string entered by the user
It then asks the user for the exact title, this must be entered correctly or it fails
After that it asks the user for a ratings
It adds the rating to the data set used to find recommendations, or it creates a new rating entry

Get a book recommendation
This Does the same process to find a book
Then it uses the Apache Mahout item based recommender to return 5 recommendations

Get user recommendations
This uses Apache Mahouts user based recommender to find five recommendations specific to the user currently logged in
In our tests a new users results did not always return recommendations
Using the userBased recommender in the book tester class did return results though

Save your books 
This option saves the books a user has rated to the csv that contains the users information
This way the user can see the books they have rated on previous log ins

Launching the program
Use the main method in userAccountInterface to launch the program


The back end and Apache Mahout.

To use Apache Mahout we looked at the Apache Mahout website and the manuals for creating simple recommender engines.

First we had to massage the data so that the recommender could use it.
The Data Fix class goes through the data files provided by book crossing and makes two new files
The files are book-ratingsV2.csv and books.csv

ISBN,Book-Title,Book-Author,Year-Of-Publication,Publisher,Image-URL-S,Image-URL-M,Image-URL-L
This is the format for books.csv

And this is the format for book-ratingsV2.csv
276725,0,0
User-Id, book identifier, ratingsV2

This was not how they came, book isbns contain letters as well as numbers, but Mahout requires numbers only

To fix this I used the IDFix class to create a map between isbns and arbitrary ids, in this case I started at 0 and mapped them incrementally
I stored those mappings in a new file so the program can find them again later so I can find the right isbn for the recommender

The next class is storebookdata class to create hashmaps that hold the isbn, to id, to title information

The HashMaps created by store book data are used by the recommender to decode results into something a user will understand

The Item recommender takes in an Isbn and the hashmaps created by storebookdata
The user specifies a book they want recommendations based on
This uses those maps to find the right id and run the recommender
It returns an arraylist containing the titles of the books These are displayed for the user to see

The userbased recommender finds recommendations based on the users previously entered ratings
Like the item recommender it is passed hashmaps to isbn, ids, and titles to decipher the results

SaveUserData class
This class updates the userdata file 
The user data file is a csv with id,isbn1,isbn2,...
First it reads the file into an ArrayList of Strings
Then it searches those strings for matching ids
If there is a match it replaces the string with the updated isbn
If there is no match it adds the string to the end
Then it reqrites the file with all the strings

LoadUserDataClass
The load user data class takes the userdata file and creates a new user from the file
It finds the matching id, if there is one, then creates new books from all the isbns
It has a method to return the user, the main panel gets the user object and uses it to run the program

Book class
The book class holds the information relating to a single book
This holds Title, author, publisher, publication year, and other details

User class
A user object has the user id and the library which is an ArrayList<Book>
It has methods to add books to the library

There are two classes to get book info
One using a given isbn
This reads the books.csv and finds the matching isbn
It then fills the Book datafields and creates a Book object using them

One for users searching by title
One finds all the matching titles to a search
The other finds Book information by using an exact title

The rest of the classes are used to create the GUI and handle user interactions



