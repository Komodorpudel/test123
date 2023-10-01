package B_Uebung.uebung10_NS.A48_49_neu.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class BankAccountContainer implements Iterable<BankAccount> {

    private ArrayList<BankAccount> bankAccounts;
    private static BankAccountContainer unique;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    // Konstruktor
    private BankAccountContainer() {
        this.bankAccounts = new ArrayList<>();
    }

    // Iteratormuster: Klasse implementiert iteratbel und gibt iterator zurück via Iterator Methode
    @Override
    public Iterator <BankAccount> iterator() {
        return bankAccounts.iterator();

    }

    // Singelton Muster: instance() erstellt Container falls notwendig und returned reference 
    // ist public damit jeder zugreifen kann
    public static BankAccountContainer instance(){

        if (unique == null){
            unique = new BankAccountContainer();
        }

        return unique;
    }

    // Link
    public void linkBankAccount (BankAccount b) throws IllegalBankingException {

        if(bankAccounts.contains(b)){
            throw new IllegalBankingException("Bank account already exists with account number " + b.getAccountNumber());
        }

        bankAccounts.add(b);
        changes.firePropertyChange("BankAccount", null, b);

    }

    // Unlink
    public void unlinkBankAccount(BankAccount b) {
        if (!this.bankAccounts.contains(b)){

            return;
        }

        bankAccounts.remove(b);
        changes.firePropertyChange("BankAccount", b, null);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changes.removePropertyChangeListener(listener);
    }

}
