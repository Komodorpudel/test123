package B_Uebung.uebung06_sub_4P.A28;


// Aufgabenstellung:
    // 1. Eine Bank verwaltet Bankkonten, die einzigartige Kontennummern, einen Inhaber sowie einen Kontostand haben.

    // 2. Eine Bank kann neue Konten er¨offnen lassen, dazu bekommt Sie den Namen des Inhabers sowie die gewunschte Kontonummer gegeben.
    // 2.a Ist bereits ein Konto ¨mit dieser Kontonummer bei der Bank angelegt worden, so wird eine IllegalBankingException geworfen (Die Ausnahme wird in der n¨achsten Teilaufgabe implementiert).

    // 3. Die Bank stellt eine M¨oglichkeit zur Verfugung, die Summe aller Kon- ¨tost¨ande eines Inhabers zu erhalten.
    // 3.a Wird versucht, die Summe aller Kontost¨ande fur¨ einen Inhaber zu erhalten, der kein Konto in dieser Bank hat, so wird die Summe 0 zuruckgegeben.

    // 4. Außerdem kann von bzw. auf einem Konto mit einer gegebenen Konto- ¨nummer Geld abgehoben bzw. eingezahlt werden.
    // 4.a Wenn versucht wird, mehr als 500 Euroabzuheben oder einzuzahlen, oder eine nicht existente Kontonummer verwendet wird, so wird eine IllegalBankingException geworfen.
    
    // 5. Erzeugen Sie fur die Berechnung der Summe aller Kontost ¨ ¨ande einen geeigneten Stream.
//

// Necessary packages/classes:
import java.util.*;
//

public class Bank {

    // Attribute:
    // 1. Eine Bank verwaltet Bankkonten, die einzigartige Kontennummern, einen Inhaber sowie einen Kontostand haben. 
    private Map<String, BankAccount> accountsByNumber;
    private Map<String, List<BankAccount>> accountsByHolder;

    // --------------------------------------

    // Konstruktor:
    // Not really needed because no specific logic to construct class necessary. HashMaps could be created above in "Attribute" instead.
    public Bank() {
        accountsByNumber = new HashMap<>();
        accountsByHolder = new HashMap<>();
    }

    // --------------------------------------

    // 2. Eine Bank kann neue Konten er¨offnen lassen, dazu bekommt Sie den Namen des Inhabers sowie die gewunschte Kontonummer gegeben.
    // createBankAccount
    public void createBankAccount(String accountHolderName, String accountNumber) throws IllegalBankingException {

        // 2.a Ist bereits ein Konto ¨mit dieser Kontonummer bei der Bank angelegt worden,
        //     so wird eine IllegalBankingException geworfen (Die Ausnahme wird in der n¨achsten Teilaufgabe implementiert).
        if (accountsByNumber.containsKey(accountNumber)) {
            throw new IllegalBankingException("Konto mit dieser Kontonummer existiert bereits.");
        }

        // SAH: Call BankAccount to create new account
        BankAccount newAccount = new BankAccount(accountHolderName, accountNumber);

        // by Number:
        //          SAH: Place memory reference to newly created account in HashMap with accountNumber as key
        accountsByNumber.put(accountNumber, newAccount);

        // byHolder:
        //          SAH: If holder not yet present in HashMap, create new ArrayList to store associated accountNumbers in it
        accountsByHolder.putIfAbsent(accountHolderName, new ArrayList<>());
        //          SAH: adds newAccount to associated key for accountHolderName
        accountsByHolder.get(accountHolderName).add(newAccount);
    }

    // --------------------------------------

    // 3. Die Bank stellt eine M¨oglichkeit zur Verfugung, die Summe aller Kon- ¨tost¨ande eines Inhabers zu erhalten.
    public double getBalanceByHolder(String accountHolderName) {
        
        // 5. Erzeugen Sie fur die Berechnung der Summe aller Kontost ¨ ¨ande einen geeigneten Stream.
        // 3.a Wird versucht, die Summe aller Kontost¨ande fur¨ einen Inhaber zu erhalten, der kein Konto in dieser Bank hat, so wird die Summe 0 zuruckgegeben. 
        return accountsByHolder.getOrDefault(accountHolderName, Collections.emptyList()) // gets me the accountHolderName list or an emptylist if no mapping
                .stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    // --------------------------------------

    // 4. Außerdem kann von bzw. auf einem Konto mit einer gegebenen Konto- ¨nummer Geld abgehoben bzw. eingezahlt werden.
    public void addBalance(String accountNumber, double amount) throws IllegalBankingException {

        // 4.a Wenn versucht wird, mehr als 500 Euroabzuheben oder einzuzahlen, oder eine nicht existente Kontonummer verwendet wird, so wird eine IllegalBankingException geworfen.
        if (Math.abs(amount) > 500) {
            throw new IllegalBankingException("Der Betrag darf 500 Euro nicht übersteigen.");
        }

        // Holt sich reference zu passendem Account
        BankAccount account = accountsByNumber.get(accountNumber);

        if (account == null) {
            throw new IllegalBankingException("Konto mit dieser Kontonummer existiert nicht.");
        }

        // Added balance to account über addBalance
        account.addBalance(amount);
    }

    // --------------------------------------

}
