package uebung06_sub_4P.A28;


// package blatt06;
import java.util.Scanner;
import java.util.regex.Pattern;
//

public class A28_main {

    // --------------------------------------

    public static void main(String[] args) {

        // SAH: Create scanner
        Scanner input = new Scanner(System.in);
        input.useDelimiter(Pattern.compile("[\\r\\n]+"));

        // SAH: Create Bank
        Bank bank = new Bank();

        // SAH: Try create Bank accounts
        try {
            // SAH: Create Bank Accounts
            bank.createBankAccount("Dagobert Duck", "ENTENHAUSEN1");
            bank.createBankAccount("Dagobert Duck", "ENTENHAUSEN2");
            bank.createBankAccount("Dagobert Duck", "ENTENHAUSEN3");

            bank.createBankAccount("Donald Duck", "ENTENHAUSEN4");
            bank.createBankAccount("Donald Duck", "PHANTOMIAS12");

            bank.createBankAccount("Klaas Klever", "ENTENHAUSEN5");

            // SAH: initialize int i
            int i = 0;

            // SAH: Add Balance
            bank.addBalance("ENTENHAUSEN2", -100);
            bank.addBalance("PHANTOMIAS12", 200);

            // SAH: While loop addBalance
            while (i < 5) {
                bank.addBalance("ENTENHAUSEN2", -150);
                bank.addBalance("ENTENHAUSEN4", -200);
                bank.addBalance("ENTENHAUSEN3", -500);
                i++;
            }

            // SAH: While loop addBalance
            while (i < 50) {
                bank.addBalance("ENTENHAUSEN1", 500);
                bank.addBalance("ENTENHAUSEN5", 250);
                i++;
            }
        }
        
        catch (IllegalBankingException e) {
            throw new RuntimeException(e);
        }

        // SAH: Print out
        System.out.println("Does Dagobert Duck have more money than Klaas Klever? " +
                (bank.getBalanceByHolder("Dagobert Duck") > bank.getBalanceByHolder("Klaas Klever")));
        
        // SAH: Try to addBalance
        try {
            bank.addBalance("ENTENHAUSEN4", -1000);
        }
        
        catch (IllegalBankingException e) {
            System.out.println("Donald Duck can't withdraw 1000 Euros");
        }

    }

    // --------------------------------------
    
}
