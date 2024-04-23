package SoSe23.C_BP.bp12_sub.Aufgabe_01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main_V2 {
    public static void main(String[] args) {
        String filename = "meineDatei.txt";
        String neueZeile = "Dies ist eine neue Zeile_V2.";

        try (FileWriter fw = new FileWriter(filename, true); // Der zweite Parameter 'true' aktiviert Anhänge-Modus
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.newLine(); // Fügt eine neue Zeile hinzu
            bw.write(neueZeile); // Schreibt die neue Zeile
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}