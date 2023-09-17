package B_Uebung.uebung04_sub_4P;

// Necessary packages/classes:
import java.util.List;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
import java.util.Random;
//

public class Aufgabe_19b {

    // --------------------------------------

    public static boolean isPrime(int n) {

        // Smaller equal one = not prime
        if (n <= 1) {
            return false;
        }

        // Loop through all i smaller equal n and test divisibility
        for (int i = 2; i * i <= n; i = i + 1) {

            // Not a prime if modulo is ß
            if (n % i == 0) {
                return false;
            }
        }

        // Return true if above does not apply
        return true;
    }

    // --------------------------------------

    public static void main(String[] args) {

        // 1. eine Liste f¨ur Integer-Objekte erzeugt und diese mit 5000 zuf¨alligen ganzen Zahlen
        //    aus dem Intervall [0, 10000[ bef¨ullt,
        Random rand = new Random(); // random seed
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5000; i = i + 1) {
            list.add(rand.nextInt(10000)); // inclusive 0 exclusive 10000
        }

        // 2. direkt mit einem Lambda-Ausdruck alle geraden Zahlen der Liste quadriert,
        UnaryOperator<Integer> squareIfEven = i -> i % 2 == 0 ? i * i : i; // if even is true, then square it, if false do nothing
        list.replaceAll(squareIfEven);

        // 3. ein Objekt vom Typ Predicate<Integer> erzeugt, das zur¨uckgibt, ob eine ¨ubergebene
        //    nat¨urliche Zahl eine Primzahl ist,
        Predicate<Integer> isNotPrime = i -> !isPrime(i);

        // 4. mit diesem Objekt alle Primzahlen aus der Liste entfernt und
        list.removeIf(isNotPrime);

        // 5. am Ende alle Zahlen in einer jeweils eigenen Zeile mithilfe einer Methodenreferenz
        //    ausgibt.
        list.forEach(System.out::println);
    }

    // --------------------------------------

}
