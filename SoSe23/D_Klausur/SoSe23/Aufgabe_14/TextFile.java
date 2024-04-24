package SoSe23.D_Klausur.SoSe23.Aufgabe_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TextFile {

    Path path;

    public static ArrayList<Person> creator(Path path) {

        String line;

        try (BufferedReader myReader = Files.newBufferedReader(path)){

            ArrayList <Person> myArrayList = new ArrayList<>();

            while ((line = myReader.readLine()) != null){
                String[] name = line.split(" ");
                String vorname = name [0];
                String nachname = name[1];

                myArrayList.add(new Person(vorname, nachname));

            }
            
            return myArrayList;

        }

        catch (IOException e ){

            e.printStackTrace();
            return null;
        }
    }
    
}
