package A_Skript.C5_Java_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;

public class C5_5_Streams {

    // Fließband für Daten
    // Vorteil: kann auch parralel verarbeitet werden

    // Collections lännen mit Stream durchlaufen werden
    //ArrayList, linkedList, HashSet, TreeSet, ArrayDeque, DelayQueue,

    public static void main (String[] args){

        ArrayList <StringBuilder> myArrayList = new ArrayList<StringBuilder>();

        // random Lange Strings erstellen und befüllen
        // ArrayList erstellen:
        System.out.println("ArrayList erstellen:");

        Random myRandom = new Random();

        int length = myRandom.nextInt(1000); // Array Length

        for(int i = 0; i < length; i++){

            int lengthS = myRandom.nextInt(1, 15); //StringBuilder Length

            StringBuilder mySB = new StringBuilder();

            for (int j = 0; j < lengthS; j++){
                char RandomChar = (char) (97 + myRandom.nextInt(26));
                mySB.append(RandomChar);
            }
            myArrayList.add(mySB);

        }

        System.out.println(myArrayList);

        // S56 - Stream
        System.out.println("\nStream:");

        List<StringBuilder> shortList = myArrayList.stream()
                                                    .map(s -> s.append("ABC"))
                                                    .filter(n -> n.charAt(0) == 'a')
                                                    .sorted(Comparator.comparing(s -> s.toString()))
                                                    .collect(Collectors.toList());
                                                    //.toList(); //returned ein anderes Objekt -> Ausprobieren

        System.out.println(shortList.getClass());
        System.out.println(shortList);


        System.out.println("Count:" + myArrayList.stream()
                                                    .map(s -> s.append("ABC"))
                                                    .filter(n -> n.charAt(0) == 'a')
                                                    .sorted(Comparator.comparing(s -> s.toString()))
                                                    .count()
        );

        // +++++++++++

        // S59 - Reduce
        System.out.println("\nReduce:");


        int[] numbers = new int[10];  // Creates an array of size 10

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i;  // Fills the array with numbers from 0 to 9
        }

        // Using a stream to print the array
        // Wir haben nur ein einfaches Array, deswegen können wir nicht direkt .stream() machen
        int max = Arrays.stream(numbers).reduce(0,(a,b) -> (a > b)? a : b); // Reduce acts like a terminal operation
        // Used an Identity, serves as starting point or default result when stream empty
        System.out.println(max);

        // Alterantiv zu Identity:
        // Optional <T> enthält enweder T oder ist leer
        OptionalInt max2 = Arrays.stream(numbers).reduce((a,b) -> (a > b)? a : b);

        System.out.println(max2);

    }
    
}
