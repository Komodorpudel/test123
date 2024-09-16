package SoSe23.B_Uebung.uebung05_sub_4P.Aufgabe_22_neu;

import java.util.Random;
import java.util.stream.IntStream;

public class Aufgabe_22a_neu {

    public static void main (String[] args){

        Random myRandom = new Random();

        // The ints method of Random creates a IntStream object
        IntStream ints = myRandom.ints(1000,0,100);

        int sum = ints.map(n -> n/10) // filter(n -> n/10 == 0) using a Predicate to filter isntead of map
                        .distinct()
                        .sum();

        System.out.println(sum);

    }
    
}
