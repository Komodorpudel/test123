package B_Uebung.uebung06_sub_4P.A28_neu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank_neu {

    private final HashMap <String, BankAccount_neu> accountsByNumber = new HashMap<>();

    private final HashMap <String, List <BankAccount_neu>> accountsByHolder = new HashMap<>();
    
    
    public void createBankAccount(String accountHolderName, String accountNumber) throws IllegalBankingException_neu {

        if (accountsByNumber.containsKey(accountNumber)){
            throw new IllegalBankingException_neu ("Kontonummer schon vergeben");

        }

        if (accountsByHolder.containsKey(accountHolderName) == false){
            accountsByHolder.put(accountHolderName, new ArrayList<>());


        }

        BankAccount_neu temp = new BankAccount_neu(accountHolderName, accountNumber);

        // zu byNumber hinzufügen
        accountsByNumber.put(accountNumber, temp);

        // zu byHolder hinzufügen
        accountsByHolder.get(accountHolderName).add(temp);

    }


    public double getBalanceByHolder (String accountHolderName){

        if (!accountsByHolder.containsKey(accountHolderName)){
            return 0;
        }

       //  double sum =0;
        /* 
        for (BankAccount_neu b : accountsByHolder.get(accountHolderName)){

            sum = sum + b.getAccountBalance();

        }
        return sum; */

        return accountsByHolder.get(accountHolderName).stream().mapToDouble(n -> n.getAccountBalance()).sum();
    }

    public void addBalance (String accountNumber, double value) throws IllegalBankingException_neu {
        if(Math.abs(value) > 500){
            throw new IllegalBankingException_neu("Amount to big");
        }

        BankAccount_neu temp = accountsByNumber.get(accountNumber);

        if (temp == null) {
            throw new IllegalBankingException_neu("Account does not exist");
        }

        temp.addBalance(value);

    }

    
}
