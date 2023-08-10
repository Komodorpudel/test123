// Necessary packages/classes:
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
//
//
//

public class A23_24d_main {

    // --------------------------------------

    public static void main(String[] args) {

        // b.1. ein Student-Objekt erstellt und ausgibt,
        try {
                UniqueStudent student = new UniqueStudent("John Doe", 1234567);
                System.out.println(student);
        }
        catch (DuplicateException e) {
            System.out.println("Die Matrikelnummer existiert bereits.");
        }


        // d.1. ein Scanner-Objekt input f¨ur den Standardeingabestrom erstellt,
        Scanner input = new Scanner(System.in);

        // d.2. das Trennzeichens dieses Objekts mit input.useDelimiter(Pattern.compile("[\\r\\n]+"));
        //      auf Zeilenumbr¨uche bzw. das Dr¨ucken der Entertaste setzt,
        input.useDelimiter(Pattern.compile("[\\r\\n]+"));

        // Keine Liste notwendig im Vergleich zu A23_24b_main wegen HashMap Klassenvariable
        //
        //
        //
        //

        // d.3. den Benutzer dreimal zur Eingabe eines Namens und einer Matrikelnummer jeweils
        //      in einer eigenen Zeile auffordert und entsprechende UniqueStudent-Objekte erzeugt,
        //
        for (int i = 0; i < 3; i = i + 1) {
            try {

                // Name:
                System.out.println("Geben Sie den Namen des Studenten ein:");
                String name = input.next();

                // Matrikelnummer:
                System.out.println("Geben Sie die Matrikelnummer des Studenten ein:");
                int matrikelNummer = input.nextInt();

                // UniqueStudent anlegen:
                UniqueStudent student = new UniqueStudent(name, matrikelNummer);
                System.out.println(student);
            }

            // d.4. bei fehlerhaften Eingaben eine entsprechende Meldung auf der Standardfehlerausgabe
            //      ausgibt, aber eine eigene Ausgabe bei einem Duplikat der Matrikelnummer erzeugt,
            //      und die restlichen Eingaben weiterhin erm¨oglicht,
            catch (DuplicateException e) {
                System.out.println("Die Matrikelnummer existiert bereits.");
            }
            
            catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Ungültige Eingabe");
            }
        }

        // d.5. nachdem versucht wurde, alle drei Eingaben vollst¨andig zu lesen, den Benutzer zur
        //      Eingabe einer Matrikelnummer auffordert und
        System.out.println("Suche - Geben Sie eine Matrikelnummer ein:");
        int matrikelNummer = input.nextInt();

        UniqueStudent student = UniqueStudent.getByMatrikelNummer(matrikelNummer);

        // d.6. das entsprechende UniqueStudent-Objekt ausgibt, sofern vorhanden.
        if (student != null) {
            System.out.println(student);
        }
        
        else {
            System.out.println("Es gibt keinen Studenten mit dieser Matrikelnummer.");
        }


        // SAH: Scanner close (wird von Aufgabenstellung nicht verlangt)
        input.close();
    }

    // --------------------------------------

}
   