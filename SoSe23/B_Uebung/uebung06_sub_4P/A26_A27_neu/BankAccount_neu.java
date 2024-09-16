package SoSe23.B_Uebung.uebung06_sub_4P.A26_A27_neu;

import java.time.LocalDate;

public class BankAccount_neu {

    private String accountHolderName; // wir setzen alles auf private, weil wir es ja über die getter und setter be
    private String accountNumber; // Cannot set private her, otherwise i can not init it later
    private final LocalDate openingDate; // but works here, because i init it directly in constructor
    // with final i have to do it directly or in constructor directly
    private double accountBalance;


    public BankAccount_neu(String accountHolderName, String accountNumber){

        this.setAccountHolderName(accountHolderName);
        this.setAccountNumber(accountNumber); 
        this.openingDate = LocalDate.now();
        this.accountBalance = 0;

        
    }

    public static boolean checkAccountHolderName (String accountHolderName){
        if (accountHolderName != null && accountHolderName.matches("[A-Z][a-z]*(\\s[A-Z][a-z]*)*")) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checkAccountNumber (String accountNumber){
        if(accountNumber != null && accountNumber.matches("[A-Z0-9]{12}")){
            return true;
        }
        else {
            return false;
        }
    }

    public void setAccountHolderName(String accountHolderName) {

        if (checkAccountHolderName(accountHolderName)) {
            this.accountHolderName = accountHolderName;
        }
        else {
            throw new IllegalArgumentException("Wrong format for accountHolderName");
        }
    }

    private void setAccountNumber(String accountNumber){

        if (checkAccountNumber(accountNumber)){
            this.accountNumber = accountNumber;
        }
        else {
            throw new IllegalArgumentException("Wrong format for accountNumber");
        }

    }

    public void addBalance (double value) {
        this.accountBalance = accountBalance + value;
    }
    

    public String getAccountHolderName(){
        return accountHolderName;

    }

    public String getAccountNumber(){
        return accountNumber;

    }

    public double getAccountBalance(){
        return accountBalance;
    }

    public LocalDate getOpeningDate(){
        return openingDate;

    
    }


    @Override
    public String toString() {
        return "AccountHolderName: " + accountHolderName + " // AccountNumber: " + accountNumber + " // AccountBalance: " + accountBalance;
    }

    @Override
    public boolean equals (Object o){
        if (o == null) return false;

        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        BankAccount_neu object = (BankAccount_neu) o;

        return object.getAccountNumber().equals(this.getAccountNumber());

    }
}
