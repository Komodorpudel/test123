package B_Uebung.uebung12_NS.A56_neu;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;

public class SimpleXMLParser {

    // Attribute
    private final static String dateiAnfang = "<teilnehmer>";
    private final static String dateiEnde = "</teilnehmer>";

    // ------------------

    public static void main(String[] args) throws IOException, URISyntaxException {

        // Test directory
        System.out.println("Directory:");
        System.out.println(new java.io.File(".").getCanonicalPath());


        // Loppt durch die dateinahmen durch
        for (String filename : new String[]{"invalidTeilnehmer1.xml", "invalidTeilnehmer2.xml", "invalidTeilnehmer3.xml"}) {

            try {
                parseTeilnehmerFile(filename);
                System.out.println("Did not detect " + filename + " as wrongly formatted");
            }
            
            catch (WrongFormatException e) {
                System.out.println("Sucessfully detected " + e.getMessage() + " as wrongly formatted");
            }
        }

        try {
            parseTeilnehmerFile("validTeilnehmer.xml");
        }
        
        catch (WrongFormatException e ) {
            System.out.println("Failed to read validTeilnehmer.xml");
        }
    }

    // ------------------

    public static void parseTeilnehmerFile(String filename) throws WrongFormatException, URISyntaxException {
        ArrayList<Integer> matrikelnummern = new ArrayList<>();
        /* TO-DO
        *   - Datei filename oeffnen
        *   - Sicherstellen, dass Datei mit dateiAnfang beginnt, sonst WrongFormatException werfen
        *   - Zeilen einlesen:
        *       - Wenn die Zeile aus dateiEnde besteht, sind wir mit Einlesen fertig
        *       - Wenn die Zeile eine valide Matrikelnummer enthaelt, zu matrikelnummern hinzufuegen
        *       - Ansonsten WrongFormatException werfen
        *   - Wenn die Datei nicht mit dateiEnde beendet wurde, WrongFormatException werfen
        *   - Alle eingelesenen Matrikelnummern auf der Kommandozeile ausgeben
        *   - Wenn eine IOException auftritt, deren Trace ausgeben */


        Path path = null;
        java.net.URL url = SimpleXMLParser.class.getResource(filename);
        if (url != null) {
            path = Paths.get(url.toURI());
            // Now use path with Files.newBufferedReader or other file operations
        }
        
        else {
            // Handle error, file not found
        }


        try (BufferedReader myReader = Files.newBufferedReader(path)) {

            // Erste Zeile einlesen ob testen, ob wirklich dateiAnfang
            String line = myReader.readLine();

            if (line == null || !line.strip().equals(dateiAnfang)){
                throw new WrongFormatException(filename);
            }

            // Reihe nach durchlesen
            boolean validEnding = false;

            while ((line = myReader.readLine()) != null) {
                
                line = line.strip();

                if (line.equals(dateiEnde)){
                    validEnding = true;
                    break;
                }

                else if (line.matches("<student>\\d*</student>")){

                    int lastIndex = line.lastIndexOf("</student>");
                    
                    matrikelnummern.add(Integer.valueOf(line.substring(2+7, lastIndex)));
                }
                else {
                    throw new WrongFormatException(filename);
                }
            }

            if (!validEnding){
                throw new WrongFormatException(filename);
            }

            matrikelnummern.forEach(System.out::println);

        }

        catch (IOException e) {

            e.printStackTrace();

        }
    }
}
