package B_Uebung.uebung05_sub_4P.Aufgabe_23_24_neu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class A23_24d_main_neu {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);

        input.useDelimiter(Pattern.compile("[\\r\\n]+"));

        try {

            for (int i = 0; i < 3; i++){
                System.out.println("Name und Matrikelnummer eingeben");

                String name = input.next();

                Integer matrikelnummer = input.nextInt();

                new UniqueStudent_neu(name, matrikelnummer);

            }

        }   

        catch (DuplicateException_neu e){
            System.out.println("Duplikate Eingabe");
            
        }
        catch (IllegalArgumentException e){
            System.out.println("Fehlerhafte Eingabe");
        }

        // Nutzer auffordern

        try{
            System.out.println("matrikelnummer eingeben");

            int matrikelnummer = input.nextInt();

            UniqueStudent_neu myUniqueStudent = UniqueStudent_neu.getByMatrikelnummer(matrikelnummer);

            if(myUniqueStudent == null){
                System.out.println("Matrikelnummer gibt es nicht");

            }
            else{
                System.out.println(myUniqueStudent);
            }
        }

        catch(InputMismatchException e){
            System.out.println("Fehlerhafte Eingabe");
        }

        input.close();
    }
    
}
