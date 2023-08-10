package uebung05_sub_4P.A22;

// Necessary packages/classes:
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
//

public class Aufgabe_22b {

    // --------------------------------------

    public static void main(String[] args) {

        // Array
        int[] numbers = {2, 3, 5, 7};

        // Random seed
        Random random = new Random();

        // 1. ein IntSupplier-Objekt erzeugt, dass zuf¨allig, d.h. mit jeweils gleicher Wahrscheinlichkeit,
        //    eine der Zahlen {2, 3, 5, 7} zur¨uckgibt,
        IntSupplier supplier = () -> numbers[random.nextInt(4)];

        // 2. damit ein IntStream-Objekt erzeugt, das entsprechend zuf¨allige Zahlen aus {2, 3, 5, 7}
        //    zur¨uckgibt,
        int sum = IntStream.generate(supplier)

                // 3. die L¨ange des Streams auf 100 beschr¨ankt und
                .limit(100)
                
                // 4. mit der reduce-Operation und einem geeigneten Lambda-Ausdruck f¨ur die funktionale
                //    Schnittstelle IntBinaryOperator die Summe der enthaltenen Zahlen bestimmt und ausgibt.
                .reduce((a, b) -> a + b) // Summiert effektiv alle elemente nacheinander auf a + b -> (a+b) + c -> (a+b+c) + d
                .getAsInt();

        // Ausgabe
        System.out.println("Summe: " + sum);
    }

    // --------------------------------------

}
