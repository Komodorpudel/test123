package B_Uebung.uebung06_sub_4P.A26_A27_neu;

// package blatt06;

public class A2627_main_neu {

    // --------------------------------------

    public static void main(String[] args) {

        // SAH: Create Account
        BankAccount_neu ba1 = new BankAccount_neu("Max Mustermann", "DE0123456789");

        // SAH: add Balance
        ba1.addBalance(20);
        ba1.addBalance(-13);

        // SAH: Print
        System.out.println("Bankkonto von " + ba1.getAccountHolderName() + " mit Kontonummer "
                + ba1.getAccountNumber() +  " am " + ba1.getOpeningDate() + " eroeffnet.");
        System.out.println("Aktueller Kontostand: " + ba1.getAccountBalance());
        System.out.println("Zeichenketten-Darstellung des Kontos:");
        System.out.println(ba1);

        // SAH: Try to create account
        try {
            BankAccount_neu ba2 = new BankAccount_neu("FalscheR Test1 naMe", "5R9S3B2N0Q7");
            System.out.println("Ueberpruefung des Namen fehlgeschlagen!" + ba2);
        }
        
        catch (IllegalArgumentException e) {
            System.out.println("Falscher Name führt zu folgender Fehlermeldung: " + e.getMessage());
        }

        // SAH: Try to create account
        try {
            BankAccount_neu ba2 = new BankAccount_neu("Gueltiger Name", "5R9S3a2N0Q7");
            System.out.println("Ueberpruefung der Kontonummer fehlgeschlagen!" + ba2);
        }
        
        catch (IllegalArgumentException e) {
            System.out.println("Falsche Kontonummer führt folgender Fehlermeldung: " + e.getMessage());
        }
    }

    // --------------------------------------
    
}
