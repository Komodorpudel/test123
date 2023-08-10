package uebung05_sub_4P.A23_A24;

// Teilaufgabe c.1. Erstellen Sie eine eigene gepr¨ufte Ausnahme DuplicateException als Unterklasse
//                  von Exception.

public class DuplicateException extends Exception {

    // --------------------------------------

    // Teilaufgabe c.2. Eine Ausnahme des Typs DuplicateException enth¨alt eine Fehlermeldung
    // [Attribute] already taken: [Value], wobei Attribute und Value dem Konstruktor
    // von DuplicateException als Zeichenketten ¨ubergeben werden.

    public DuplicateException(String attribute, String value) {
        super(attribute + " already taken: " + value);
    }

    // --------------------------------------
    
}