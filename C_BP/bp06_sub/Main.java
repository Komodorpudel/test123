package SoSe23.C_BP.bp06_sub;

// import Uebung_6.Book;
// import Uebung_6.BookNotFoundException;
// import Uebung_6.Library;

import java.util.List;

public class Main {

    // --------------------------------------

    public static void main(String[] args) {


        Library library = new Library();

        // TO-DO Kommentar
        // SAH: Erstellt eine neue Liste newBooks mit 5 verschiedenen Büchern
        List<Book> newBooks = List.of(
                new Book("Java Programming", "John Doe", 2010),
                new Book("Python Basics", "Jane Smith", 2015),
                new Book("C# in Depth", "John Doe", 2018),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960)
        );
        // SAH: Fügt die newBooks zur library hinzu indem addBooks aufgerufen wird
        library.addBooks(newBooks);

        // TO-DO Kommentar
        // SAH: Fügt ein weiteres neues Buch hinzu
        library.addBook(new Book("1984", "George Orwell", 1949));

        // TO-DO Kommentar
        // SAH: Printed "Alle Bücher ...."
        System.out.println("Alle Bücher der Bibliothek:");
        // SAH: Ruft die Methode displayBooks der Klasse library auf
        library.displayBooks();

        // TO-DO Kommentar
        // SAH: Erstellt string John Doe
        String author = "John Doe";
        // SAH: Erstellt liste nur mit Büchern von John Doe via libary method "findBooksbyAuthor"
        List<Book> booksByAuthor = library.findBooksByAuthor(author);
        // SAH: Print "Bücher von ..."
        System.out.println("\nBücher von " + author + ":");
        // SAH: Calls toString von jedem Buch aus der Liste:
        booksByAuthor.forEach(System.out::println);

        // TO-DO Kommentar
        // SAH: Erstellt year 2012
        int year = 2012;
        // SAH: Erstellt Liste nur mit Büchern die nach/in 2012 veröffentlicht wurden via libary klassenmethode findBooksPubishedAfter
        List<Book> booksPublishedAfterYear = library.findBooksPublishedAfter(year);
        // SAH: Print "Bücher veröffentlicht nach ...."
        System.out.println("\nBücher veröffentlicht nach " + year + ":");
        // SAH: Calls toString von jedem Buch aus der Liste:
        booksPublishedAfterYear.forEach(System.out::println);

        // TO-DO Kommentar
        // SAH: Erstellt neues Object book der Klasse Book -> dieses will man ausleihen
        Book book = new Book("Java Programming", "John Doe", 2010);
        // SAH: Try catch um exception abzufangen
        try {
            // SAH: Leiht Buch aus
            book = library.borrowBook(book);

        } catch (BookNotFoundException e) {
            // SAH: Ausgabe wenn Buch nicht gefunden wird
            System.err.println("\nFehler: " + e.getMessage());
        }

        // TO-DO Kommentar
        // SAH: try catch um exception abzufangen
        try {
            // SAH: Gibt Buch zurück
            book = library.returnBook(book);
        } catch (BookNotFoundException e) {
            // SAH: Fehlermeldung wenn Buch nicht in library
            System.err.println("\nFehler: " + e.getMessage());
        }

        // TO-DO Kommentar
        // SAH: Ausgabe "Alle Bücher nach ...."
        System.out.println("\nAlle Bücher der Bibliothek nach der Rückgabe:");
        // Calls for String auf alle Bücher
        library.displayBooks();
    }

    // --------------------------------------

}
