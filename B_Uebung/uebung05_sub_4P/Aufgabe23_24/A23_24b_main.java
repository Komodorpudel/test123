package B_Uebung.uebung05_sub_4P.Aufgabe23_24;

// Necessary packages/classes:
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
//

public class A23_24b_main {

    // --------------------------------------

    public static void main(String[] args) {

            // 1. ein Student-Objekt erstellt und ausgibt,
            Student student = new Student("John Doe", 1234567);
            System.out.println(student);

            //
            //
            //
            //
            //
            
            // 2. ein Scanner-Objekt input f¨ur den Standardeingabestrom erstellt,
            Scanner input = new Scanner(System.in);

            // 3. das Trennzeichens dieses Objekts mit input.useDelimiter(Pattern.compile("[\\r\\n]+"));
            //    auf Zeilenumbr¨uche bzw. das Dr¨ucken der Entertaste setzt,
            input.useDelimiter(Pattern.compile("[\\r\\n]+"));

            // 4. eine Liste f¨ur Student-Objekte erstellt,
            ArrayList<Student> studentList = new ArrayList<>();

            // 5. das zuvor erstellte Student-Objekt dieser Liste hinzuf¨ugt,
            studentList.add(student);

            // 6a. den Benutzer solange zur Eingabe eines Namens und einer Matrikelnummer jeweils in
            //    einer eigenen Zeile auffordert und entsprechende Student-Objekte der zuvor erstellten
            //    Liste hinzuf¨ugt ....
            while (true) {
                try {

                    // Name
                    System.out.println("Geben Sie den Namen des Studenten ein:");
                    String name = input.next();

                    // Matrikelnummer
                    System.out.println("Geben Sie die Matrikelnummer des Studenten ein:");
                    int matrikelNummer = input.nextInt();

                    // Neuen Studenten anlegen und zu studentList hinzugügen
                    Student newStudent = new Student(name, matrikelNummer);
                    studentList.add(newStudent);
                }
                
                // 8. Im Falle einer ung¨ultigen Eingabe soll das Programm nicht abbrechen, sondern
                //    "Ungueltige Eingabe" auf der Kommandozeile ausgegeben werden.
                //
                catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Ungültige Eingabe");
                    break;
                }
            }

            // 7. alle in der Liste enthaltenen Studierenden in jeweils einer eigenen Zeile ausgibt.
            for (Student s : studentList) {
                System.out.println(s);
            }

            // SAH: Scanner close (wird von Aufgabenstellung nicht verlangt)
            input.close();
        
    }
        
    // --------------------------------------

}
