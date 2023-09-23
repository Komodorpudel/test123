package B_Uebung.uebung05_sub_4P.Aufgabe_22;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Aufgabe_22b_neu {

    public static void main (String[] args){

        IntSupplier mySupplier = () ->{

            int [] array = {2, 3, 5, 7};

            Random myRandom = new Random();

            return array[myRandom.nextInt(4)];

        };

        IntStream myStream = IntStream.generate(mySupplier);

        System.out.println(myStream.limit(100).reduce(0,(n,m) -> (n + m)));
    }
    
}
