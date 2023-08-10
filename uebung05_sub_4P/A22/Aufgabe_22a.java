package uebung05_sub_4P.A22;

// Necessary packages/classes:
import java.util.Random;

public class Aufgabe_22a {

    // --------------------------------------

    public static void main(String[] args) {

        // Random Seed
        Random random = new Random();

        // 1. unter Benutzung der ints-Methode der Klasse Random ein IntStream-Objekt mit
        //    1000 Zufallszahlen zwischen 0 (einschließlich) und 100 (ausschließlich) erzeugt,
        int sum = random.ints(0, 100)
                .limit(1000)
                // 2. alle enthaltenen Werte ganzzahlig durch 10 teilt,
                .map(n -> n / 10)
                // 3. alle Duplikate mit einer geeigneten Methode aus dem Stream entfernt,
                .distinct()
                // 4. die Summe aller verbleibenden Zahlen berechnet ...
                .sum(); 

        // ... und ausgibt. (sum ist quasi immer 45 (1+2+3+4+5+6+7+8+9))
        System.out.println("Summe: " + sum);
    }

    // --------------------------------------

}