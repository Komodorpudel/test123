package B_Uebung.uebung05_sub_4P.Aufgabe_22;

import java.util.Random;
import java.util.stream.IntStream;

public class Aufgabe_22a_neu {

    public static void main (String[] args){

        Random myRandom = new Random();

        IntStream ints = myRandom.ints(1000,0,100);

        int sum = ints.map(n -> n/10)
                        .distinct()
                        .sum();

        System.out.println(sum);

    }
    
}
