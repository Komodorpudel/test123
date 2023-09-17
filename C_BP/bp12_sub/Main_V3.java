package C_BP.bp12_sub;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main_V3 {
    public static void main(String[] args) {
        String filename = "meineDatei.txt";
        String neueZeile = "Dies ist eine neue Zeile_V3asdas.";

        try (PrintWriter writer = new PrintWriter (new FileWriter(filename, true))) {

            writer.println(neueZeile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Nur mit new PrintWriter kein append möglich!