package SoSe23.B_Uebung.uebung03_submittedWrong.Aufgabe_13;

import java.util.Arrays;
import java.util.Random;

public class Aufgabe_13b {

    // --------------------------------------
    public static void main(String[] args) {

        // Erstelle char Array länge 30 und befülle zufällig

        // -- Erstellen
        char[] chars  = new char[30];

        // -- Random befüllen
        Random random = new Random();
        for (int i = 0; i < chars.length; i = i + 1) {
            chars[i] = (char) ('A' + random.nextInt(1,26));
        }

        // Array sortieren
        Arrays.sort(chars);

        // Binärsuche und Ausgabe

        // -- Binärsuche
        int index = Arrays.binarySearch(chars, 'X');

        // -- Ausgabe
        if (index >= 0) {
            System.out.println("Der Index von 'X' ist: " + index);
        }
        
        else {
            int insertIndex = -index - 1;
            System.out.println("Anzahl der Zeichen, die lexikographisch kleiner als 'X' sind: " + insertIndex);
        }
    }

    // --------------------------------------
}
