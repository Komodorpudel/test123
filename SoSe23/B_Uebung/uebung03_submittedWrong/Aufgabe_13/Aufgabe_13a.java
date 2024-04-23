package SoSe23.B_Uebung.uebung03_submittedWrong.Aufgabe_13;

import java.util.Arrays;
import java.util.Random;

public class Aufgabe_13a {

    // --------------------------------------

    public static void main(String[] args) {
        // Ein int-Array der Länge 10000 erstellen und mit zufälligen ganzen Zahlen zwischen 1 (einschließlich) und 10 (ausschließlich) befüllen

        // -- array erstellen und random number generator erstellen
        int[] array = new int[10000];
        Random random = new Random();

        // -- Über array loopen und mit random befüllen
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(9) + 1; // Random number between (0 and 9) + 1 
        }

        // Eine Kopie der ersten Hälfte dieses Arrays mit einem einzigen Methodenaufruf erstellen
        int[] ersteHaelfteKopie = Arrays.copyOf(array, 5000); //copyOf() schneidet ab oder added 0en um auf newLength zu kommen

        // Die Kopie des Arrays sortieren
        Arrays.sort(ersteHaelfteKopie);

        // Ein drittes int-Array der Länge 5000 erstellen und mithilfe eines Methodenaufrufs jede Position des Arrays mit 1 befüllen
        int[] drittesArray = new int[5000];
        Arrays.fill(drittesArray, 1);

        // Bestimmen und ausgeben, an welcher Stelle sich die sortierte Kopie und das dritte Array das erste Mal unterscheiden

        // -- Bestimmen wann Unterschied über Loop
        int index = -1;

        for (int i = 0; i < 5000; i = i + 1) {
            if (ersteHaelfteKopie[i] != drittesArray[i]) {
                index = i;
                break;
            }
        }

        // Arrays.mismatch()

        // -- Ausgabe
        if (index != -1) {
            System.out.println("Die sortierte Kopie und das dritte Array unterscheiden sich erstmals an Position " + index);
        }
        
        else {
            System.out.println("Die sortierte Kopie und das dritte Array sind identisch.");
        }
    }

    // --------------------------------------
}
