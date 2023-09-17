package C_BP.bp05_sub;


public class EmptyShelfException extends Exception { // Erbt von Exception

    // Konstruktor
    public EmptyShelfException(String message) {

        // Aufruf des Konstruktors von Exception
        super(message);
    }
}
