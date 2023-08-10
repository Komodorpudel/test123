package src.blatt12;

import java.text.ParseException;
import java.util.ArrayList;

public class SimpleXMLParser {
    private final static String dateiAnfang = "<teilnehmer>";
    private final static String dateiEnde = "</teilnehmer>";

    public static void main(String[] args) {
        for (String filename : new String[]{"invalidTeilnehmer1.xml", "invalidTeilnehmer2.xml", "invalidTeilnehmer3.xml"}) {
            try {
                parseTeilnehmerFile(filename);
                System.out.println("Did not detect " + filename + " as wrongly formatted");
            } catch (WrongFormatException e) {
                System.out.println("Sucessfully detected " + e.getMessage() + " as wrongly formatted");
            }
        }
        try {
            parseTeilnehmerFile("validTeilnehmer.xml");
        } catch (WrongFormatException e ) {
            System.out.println("Failed to read validTeilnehmer.xml");
        }
    }

    public static void parseTeilnehmerFile(String filename) throws WrongFormatException {
        ArrayList<Integer> matrikelnummern = new ArrayList<>();
        /* TODO
        *   - Datei filename oeffnen
        *   - Sicherstellen, dass Datei mit dateiAnfang beginnt, sonst WrongFormatException werfen
        *   - Zeilen einlesen:
        *       - Wenn die Zeile aus dateiEnde besteht, sind wir mit Einlesen fertig
        *       - Wenn die Zeile eine valide Matrikelnummer enthaelt, zu matrikelnummern hinzufuegen
        *       - Ansonsten WrongFormatException werfen
        *   - Wenn die Datei nicht mit dateiEnde beendet wurde, WrongFormatException werfen
        *   - Alle eingelesenen Matrikelnummern auf der Kommandozeile ausgeben
        *   - Wenn eine IOException auftritt, deren Trace ausgeben */
    }
}
