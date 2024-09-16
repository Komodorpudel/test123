package SoSe23.B_Uebung.uebung05_sub_4P.Aufgabe_22_neu;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Aufgabe_22b_neu {

    public static void main (String[] args){

        // Lambda method for intSupplier:
        IntSupplier mySupplier = () -> {

            int [] array = {2, 3, 5, 7};

            Random myRandom = new Random();

            return array[myRandom.nextInt(4)];

        };

        // Single expression instead:
        // IntSupplier mySupplier = () -> new int[]{2, 3, 5, 7}[new Random().nextInt(4)];


        IntStream myStream = IntStream.generate(mySupplier);

        System.out.println(myStream.limit(100).reduce(0,(n,m) -> (n + m)));
    }
    
}
