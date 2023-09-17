package C_BP.bp06_sub;

// import Uebung_6.Book;
// import Uebung_6.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

// SAH:
import java.util.stream.Collectors;

public class Library {

    // --------------------------------------

    // SAH: Attribute:
    private final List<Book> books;

     // --------------------------------------

     // SAH: Konstruktor:
    public Library() {

        // SAH: Anfänglich leere Liste/Library
        this.books = new ArrayList<>();
    }

    // --------------------------------------

    // SAH: addBook
    public void addBook(Book book) {

        //SAH: Fügt Buch der Liste books hinzu
        books.add(book);
    }

    // --------------------------------------

    // SAH: addBooks
    public void addBooks(List<Book> newBooks) {

        // SAH: Fügt eine Liste von Büchern der Liste books hinzu
        books.addAll(newBooks);
    }

    // --------------------------------------

    // SAH: findBooksbyAuthor
    public List<Book> findBooksByAuthor(String author) {

        // TO-DO Rückgabewert per Stream ermitteln
        return books.stream() // Convert list into a stream
                    .filter(book -> book.getAuthor().equals(author)) // filters the list for true
                    .toList();
                    //.collect(Collectors.toList()); //Terminal: converts stream into a new list
    }

    // --------------------------------------

    // SAH: findBooksPublishedAfter
    public List<Book> findBooksPublishedAfter(int year) {
        // TO-DO Rückgabewert per Stream ermitteln
        return books.stream() // Convert list into a stream
                    .filter(book -> book.getYear() > year) // filters the list for true
                    .collect(Collectors.toList()); //Terminal: converts stream into a new list
    }

    // --------------------------------------

    // SAH: displayBooks
    public void displayBooks() {
        // TO-DO Ausgabe aller Bücher unter Verwendung einer Methoden-Referenz von system.print (eine Codezeile!)
        books.forEach(System.out::println);

        // System.out::println ist eine Methodenreferenz, die in Verbindung mit der forEach()-
        // Methode verwendet wird, um fur jedes Element einer Sequenz oder Sammlung die ¨ toString()-
        // Methode aufzurufen.
    }

    // --------------------------------------

    // SAH: borrowBook
    public Book borrowBook(Book book) throws BookNotFoundException {
        // TO-DO's:
        //        - BookNotFoundException werfen wenn das Buch nicht gefunden wurde
        //        - BookNotFoundException werfen, wenn das Buch schon verliehen ist
        //        - Ansonsten Buch als ausgeliehen markieren
        //        - Konsolen-Ausgabe: "Folgendes Buch wurde ausgeliehen: " + book
        //        - book zurück geben

        if (!books.contains(book)) {
            throw new BookNotFoundException("Book not found in library.");
        }
        
        else if (book.isBorrowed()) {
            throw new BookNotFoundException("Book has already been borrowed.");
        }
        
        else {
            book.setBorrowed(true);
            System.out.println("Folgendes Buch wurde ausgeliehen: " + book);
            return book;
        }
    }

    // --------------------------------------

    // SAH: returnBook
    public Book returnBook(Book book) throws BookNotFoundException {
        // TO-DO's:
        //        - BookNotFoundException werfen, wenn das Buch nicht gefunden wurde
        //        - BookNotFoundException werfen, wenn das Buch gar nicht verliehen ist
        //        - Ansonsten Buch als nicht ausgeliehen markieren
        //        - Konsolen-Ausgabe: "Folgendes Buch wurde zurückgegeben: " + book
        //        - book zurück geben

        if (!books.contains(book)) {
            throw new BookNotFoundException("Book not found in library.");
        }
        
        else if (!book.isBorrowed()) {
            throw new BookNotFoundException("Book was not borrowed.");
        }
        
        else {
            book.setBorrowed(false);
            System.out.println("Folgendes Buch wurde zurückgegeben: " + book);
            return book;
        }
    }

    // --------------------------------------
    
}
