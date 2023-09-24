package B_Uebung.uebung05_sub_4P.Aufgabe23_24;

import java.util.HashMap;

public class UniqueStudent_neu extends Student_neu {

    public static final HashMap <Integer, UniqueStudent_neu> uniqueListe = new HashMap <Integer, UniqueStudent_neu>();


    // Konstruktor:
    public UniqueStudent_neu(String name, int matrikelnummer)throws DuplicateException_neu {
        super(name, matrikelnummer);

        if(getByMatrikelnummer(matrikelnummer) == null){
            uniqueListe.put(matrikelnummer, this);
        }
        else{
            throw new DuplicateException_neu("matrikelnummer", String.valueOf(matrikelnummer));
        }
    }

    public static UniqueStudent_neu getByMatrikelnummer(int matrikelnummer){

        return uniqueListe.get(matrikelnummer);
    }
    
}
