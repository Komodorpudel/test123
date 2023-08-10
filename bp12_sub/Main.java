package bp12_sub;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "meineDatei.txt";
        String neueZeile = "Dies ist eine neue Zeile.";

        try {
            FileWriter fw = new FileWriter(filename, true); // Der zweite Parameter 'true' aktiviert Anhänge-Modus
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine(); // Fügt eine neue Zeile hinzu
            bw.write(neueZeile); // Schreibt die neue Zeile

            bw.close(); // Schließt den BufferedWriter
            fw.close(); // Schließt den FileWriter
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
