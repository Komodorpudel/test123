package SoSe23.B_Uebung.uebung04_sub_4P.Aufgabe_19_neu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Aufgabe_19b_neu {

    public static void main (String[] args){

        // Liste erzeugen und befüllen
        List<Integer> myIntegerList = new ArrayList<>();

        Random myRandom = new Random();

        for (int i = 0; i < 1000; i++){
            myIntegerList.add(myRandom.nextInt(1000));
        }

        // Alle geraden Zahlen quadrieren
        myIntegerList.replaceAll(x -> x % 2 == 0 ? x * x : x);

        // Using Unary:
        // UnaryOperator<Integer> squareEvenNumbers = x -> x % 2 == 0 ? x * x : x;
        // myIntegerList.replaceAll(squareEvenNumbers);

        // Methodreference:
        myIntegerList.forEach(System.out::println);

        // Lambda:
        // myIntegerList.forEach(x -> System.out.println(x));


        Predicate<Integer> isPrime = i -> {

            if (i == 1) {
                return false;
            }

            for (int j = 2; i < i / 2; i++) {
                if ( i % j == 0)
                    return false;
            }

            return true;
        };

        myIntegerList.removeIf(isPrime);

        myIntegerList.forEach(System.out::println); // Achtung, Methodenreferenz ist verlangt. das ist was die kürzere Version von Lambda

    }
    
}
