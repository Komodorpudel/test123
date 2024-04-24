package SoSe23.B_Uebung.uebung02_NS.Aufgabe_06;

import java.util.Scanner;

// --------------------------------------

public class Aufgabe_06c {
    public static void main(String[] args) {
        int sum = 0;

        for (String arg : args) {
            Scanner scanner = new Scanner(arg);

            while (scanner.hasNextInt() == true) {
                int number = scanner.nextInt();
                sum = sum + number;
            }

            scanner.close();
        }

        System.out.println("Die Summe der eingegebenen Zahlen ist: " + sum);
    }
}

// --------------------------------------
