package SoSe23.B_Uebung.uebung04_sub_4P.Aufgabe_17;

// Necessary packages/classes:
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/package-summary.html
//

public class Aufgabe_17 {

    // --------------------------------------

    // 17a. Schreiben Sie eine Klassenmethode randomString, die eine nat¨urliche Zahl n erwartet 
    //      und ein String-Objekt der L¨ange n zur¨uckgibt, der aus zuf¨alligen lateinischen Groß- und
    //      Kleinbuchstaben besteht.
    public static String randomString(int n) {

        // String initializieren und random seed generieren
        StringBuilder sb = new StringBuilder(n); // StringBuilder: Sequence of characters
        Random rand = new Random(); // Random seed

        // Loop through um sb mit Buchstaben zu befüllen
        for (int i = 0; i < n; i = i + 1) {

            // zufälligen Groß- oder Kleinbuchstaben wählen
            char c = (rand.nextBoolean()) ? // Generates either true or false
                      (char) (rand.nextInt(26) + 'A') : // If true; 
                      (char) (rand.nextInt(26) + 'a'); // If false
                      // (char) ist notwendig, da (rand...) ein int returned, StringBuilder braucht aber einen char

            // Buchstaben an sb anhängen
            sb.append(c);
        }

        // Return
        return sb.toString();
    }

    // --------------------------------------

    public static void main(String[] args) {

        // 17b. Erzeugen Sie ein streng typisiertes ArrayList-Objekt f¨ur String-Objekte und eine Variable
        //      myList, die das Objekt referenziert
        ArrayList<String> myList = new ArrayList<>();



        // 1. Befüllen Sie myList mit 1000 zufälligen Zeichenketten mit Längen zwischen 3 und 7
        Random rand = new Random(); // random seed

        for (int i = 0; i < 1000; i = i + 1) {

            // zufällige Länge zwischen 3 und 7 bestimmen
            int length = rand.nextInt(5) + 3;

            // Appends string to end of ArrayList
            myList.add(Aufgabe_17.randomString(length));
        }

        // 2. Überprüfen Sie und geben Sie aus, ob myList die Zeichenkette "ABC" enthält.
        System.out.println("Enthält 'ABC': " + myList.contains("ABC")); // contains returns true if element is in list

        // 3. Erzeugen Sie ein Iterator-Objekt für myList und durchlaufen Sie alle Zeichenketten.
        //    Summieren Sie dabei die Länge der Zeichenketten auf und geben diese Gesamtlänge aus.

        Iterator<String> iterator = myList.iterator();
        // ("Performs the given action for each remaining element until all elements have been processed or the action throws an exception.""
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)
        int gesamtlaenge = 0;

        // while loop - Würde sich auch über for loop lösen lassen, aber while einfacher da wir iterator verwenden
        while (iterator.hasNext()) {
            gesamtlaenge = gesamtlaenge + iterator.next().length();
        }

        System.out.println("Gesamtlänge: " + gesamtlaenge);

        // 4. Iterieren Sie mithilfe einer for-each-Loop über myList und geben Sie alle Zeichenketten der Länge 7 aus.
        for (String str : myList) {
            if (str.length() == 7) {
                System.out.println(str);
            }
        }
    }

    // --------------------------------------

}
