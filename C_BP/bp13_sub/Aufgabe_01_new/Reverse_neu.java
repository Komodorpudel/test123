package C_BP.bp13_sub.Aufgabe_01_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Reverse_neu {


    public static void main (String [] args) {

        Path path = Paths.get("/Users/simonhinterreiter/Library/CloudStorage/Dropbox/06 - Coding/01 - Local GitHub Repositories/STUDY.BSc-S01-SoSe2023-C01-InformatikII/C_BP/bp13_sub/Aufgabe_01_new/textfile.txt"); 
        //Path path = Paths.get("textfile.txt");

        System.out.println("Absolute path:" + path.toAbsolutePath());


        try (BufferedReader myReader = Files.newBufferedReader(path);
            PrintWriter myWriter = new PrintWriter(Files.newOutputStream(path, StandardOpenOption.APPEND))){

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = myReader.readLine()) != null){

            content.append(line);
            content.append("\n");
 
            }

            content.reverse();

            myWriter.println(content);

        }

        catch(IOException e) {
            System.out.println("Fehler bei Lesen oder Schreiben");
        }

        System.out.println("Fertig");
    }
    
}
