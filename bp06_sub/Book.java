package bp06_sub;

// package Uebung_6;

import java.util.Objects;

class Book {

    // --------------------------------------

    // Attribute:
    private final String title;
    private final String author;
    private final int year;
    private boolean borrowed;

    // --------------------------------------

    // Konstruktor:
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    // --------------------------------------

    // getTitle:
    public String getTitle() {
        return title;
    }

    // --------------------------------------
    
    // getAuthor:
    public String getAuthor() {
        return author;
    }

    // --------------------------------------

    // getYear:
    public int getYear() {
        return year;
    }

    // --------------------------------------

    // toString:
    @Override
    public String toString() {
        return title + " von " + author + " (" + year + ")";
    }

    // --------------------------------------

    // getBorrowed:
    public boolean isBorrowed() {
        return borrowed;
    }

    // --------------------------------------

    // setBorrowed:
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    // --------------------------------------

    // equals (Vergleich mit anderem Buch)
    @Override
    public boolean equals(Object obj) {

        // booktoCompare initialisieren
        Book bookToCompare;

        // Ist object mit Klasse Buch kompatibel?
        if(!this.getClass().isInstance(obj))
            // Falls nein, return false
            return false;
        else
            // Falls ja, speichere object als booktoCompare
            bookToCompare = (Book) obj;

        // Prüfen ob Autor identisch
        if(!Objects.equals(this.author, bookToCompare.author))
            return false;

        // Prüfen ob Jahr identisch
        if(this.year != bookToCompare.year)
            return false;

        // Prüfen ob titel identisc und return
        return Objects.equals(this.title, bookToCompare.title);
    }

    // --------------------------------------

}
