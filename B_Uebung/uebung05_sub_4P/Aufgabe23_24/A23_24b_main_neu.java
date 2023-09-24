package B_Uebung.uebung05_sub_4P.Aufgabe23_24;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class A23_24b_main_neu {

    public static void main (String[] args){
        Student_neu myStudent = new Student_neu("Hans Bauer", 1234567);
        System.out.println(myStudent);

        Scanner input = new Scanner(System.in);

        input.useDelimiter(Pattern.compile("[\\r\\n]+"));

        List<Student_neu> studentList = new ArrayList<>();

        studentList.add(myStudent);

        while (true) {

            try{
                System.out.println("Name:");
                String name = input.next();

                System.out.println("Matrikelnummer:");
                int matrikelnummer = input.nextInt();

                Student_neu newStudent = new Student_neu (name, matrikelnummer);

                studentList.add(newStudent);
            }
            
            catch(IllegalArgumentException | InputMismatchException e){

                System.out.println("Eingabefehler");
                input.close();
                break;

            }
        }

        Consumer<Student_neu> myConsumer = (n) -> System.out.println(n);
        
        studentList.forEach(myConsumer);
    }
}
