package SoSe24.C_BP.bp02;

import java.util.Scanner; // Der Import ist nötig, um den Scanner zu nutzen.

public class RationalComp {
    public static void main(String[] args) {
        // Der Scanner ist eine einfache Möglichkeit, um Benutzereingaben
        // einzulesen. Hier wird von der Standardeingabe (System.in) eingelesen.
        Scanner scan = new Scanner(System.in);
        
        try {
            // Teil 1: Einlesen einer ganzen Zahl und Verarbeitung als IntegerNumber
            System.out.print("Bitte geben Sie eine ganze Zahl ein: ");
            int number = scan.nextInt();
            IntegerNumber integerNumber = new IntegerNumber(number);
            System.out.println("Sie haben " + integerNumber + " eingegeben.");
            System.out.println("Die Zahl ist " + (integerNumber.isZero() ? "null." : (integerNumber.isPositive() ? "positiv." : "negativ.")));

            // Teil 2: Einlesen von Zähler und Nenner für einen Bruch
            System.out.print("Bitte geben Sie den Zähler ein: ");
            int numerator = scan.nextInt();
            System.out.print("Bitte geben Sie den Nenner ein: ");
            int denominator = scan.nextInt();

            IntegerNumber numIntegerNumber = new IntegerNumber(numerator);
            IntegerNumber denIntegerNumber = new IntegerNumber(denominator);

            // Versuchen, ein Fraction-Objekt zu erzeugen
            try {
                Fraction fraction = new Fraction(numIntegerNumber, denIntegerNumber);
                System.out.println("Der Bruch ist: " + fraction);
                System.out.println("Der Bruch ist " + (fraction.isZero() ? "null." : (fraction.isPositive() ? "positiv." : "negativ.")));
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Es gab einen Fehler bei der Eingabe: " + e.getMessage());
        } finally {
            // Der Scanner sollte geschlossen werden, sobald man ihn nicht mehr benötigt.
            scan.close();
        }
    }
}