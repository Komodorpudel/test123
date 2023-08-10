package uebung02_NS;

import java.util.Scanner;

// --------------------------------------

public class Aufgabe_6b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine ganze Zahl zwischen 0 und 50 (einschließlich) ein:");
        
        if (scanner.hasNextInt() == false) {
            System.err.println("Die eingegebene Zahl ist kein Integer");

            System.exit(1);
        }

        int number = scanner.nextInt();
        System.out.println("Die eingegebene Zahl ist: " + number);

        scanner.close();

    }
}

// --------------------------------------