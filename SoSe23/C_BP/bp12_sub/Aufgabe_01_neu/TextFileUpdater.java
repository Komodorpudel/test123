package SoSe23.C_BP.bp12_sub.Aufgabe_01_neu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFileUpdater {

    public static void main(String[] args){

        String neueZeile = "NeueZeile";

        try(PrintWriter writer = new PrintWriter(new FileWriter("textfile.txt", true))){

            writer.println(neueZeile);
            System.out.println("Zeile erfolgreich gedruckt");

        }

        catch(IOException e) {

            System.out.println("Fehler");

        }

    }
    
}
