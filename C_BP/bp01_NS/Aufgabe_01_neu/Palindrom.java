package C_BP.bp01_NS.Aufgabe_01_neu;

import java.util.Scanner;

public class Palindrom {

    public static void main (String [] args) {
        Scanner myScanner = new Scanner(System.in);

        while (true) {

            System.out.println("Eingabe:");

            String line = myScanner.nextLine();
            

            if (line.equalsIgnoreCase("End")) {
                myScanner.close();
                System.exit(0);
            }

            if (line.equals(" ")) {
                System.err.println("Keine Eingabe getätigt");
                continue; // Drop out of while loop

            }

            String parsedString = removeUnnecessaryCharacters(line);
            boolean isPalindrome = isPalindrome(parsedString);


            if(isPalindrome == true) {
                System.out.println("Ist Palindrom");
            }

            else {
                System.out.println("Ist kein Palindrom");

            }

        }
    }
        
    public static String removeUnnecessaryCharacters(String s) {

        return s.toLowerCase().replaceAll("[^a-z]", "");

    }

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        StringBuilder reversedsb = new StringBuilder(sb);
        reversedsb.reverse();

        return sb.toString().equals(reversedsb.toString());
    }
    
}
