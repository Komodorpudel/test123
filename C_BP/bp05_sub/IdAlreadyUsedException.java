package C_BP.bp05_sub;


public class IdAlreadyUsedException extends Exception { // Erbt von Exception
    
    // Konstruktur nimmt Message entgegen die ausgegeben wird wenn Exception
    public IdAlreadyUsedException(String message) {
        
        // Aufruf des Konstruktors von  Exception
        super(message);
    }
}
