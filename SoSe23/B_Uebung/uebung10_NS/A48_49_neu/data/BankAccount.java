package SoSe23.B_Uebung.uebung10_NS.A48_49_neu.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

public class BankAccount {

    // Attribute
    private String accountHolderName;
    private String accountNumber;
    private final LocalDate openingDate = LocalDate.now();
    private double balance = 0;
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);


    // Konstruktor
    public BankAccount(String accountHolderName, String accountNumber) {
        this.setAccountHolderName(accountHolderName);
        this.setAccountNumber(accountNumber);
    }

    // checkAccountHolderName
    private static boolean checkAccountHolderName(String accountHolderName) {
        return accountHolderName != null && accountHolderName.matches("[A-Z][a-z]*( [A-Z][a-z]*)*");
    }

    // checkAccountNumber
    private static boolean checkAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.matches("[A-Z\\d]{12}");
    }

    // setAccountHolderName
    public void setAccountHolderName(String accountHolderName) {
        if (checkAccountHolderName(accountHolderName)) {
            String oldName = this.accountHolderName;
            this.accountHolderName = accountHolderName;

            changes.firePropertyChange("account holder name", oldName, this.accountHolderName);

        }
        
        else {
            throw new IllegalArgumentException("Wrong name format");
        }
    }

    // addBalance
    public void addBalance(double value) {
        double oldBalance = this.balance;
        this.balance += value;
        changes.firePropertyChange("balance", oldBalance, balance);

    }

    // setAccountNumber
    private void setAccountNumber(String accountNumber) {
        if (!checkAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("wrong account number format");
        }
        this.accountNumber = accountNumber;
    }

    // getAccountHolderName
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    // getAccountNumber
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    // getBalance
    public double getBalance() {
        return this.balance;
    }

    //getOpeningDate
    public LocalDate getOpeningDate() {
        return this.openingDate;
    }

    // toString
    @Override
    public String toString() {
        return "Inhaber: " + this.getAccountHolderName() +
                " Kontonummer: " +
                this.getAccountNumber() +
                " Eroeffnungsdatum: " +
                this.getOpeningDate() +
                " Kontostand: " +
                this.getBalance() +
                " Euro";
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o.getClass().equals(this.getClass()))) {
            return false;
        }
        BankAccount a = (BankAccount) o;
        return a.getAccountNumber().equals(this.getAccountNumber());
    }

    // addPropertyChangeListener
    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    // removePropertyChangeListener
    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }
}
