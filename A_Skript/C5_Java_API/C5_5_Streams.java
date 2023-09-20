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


        /*         
        Casting int to char (and vice-versa):
        Both int and char are primitive types in Java.
        A char represents a single 16-bit Unicode character and has a range of values from 0 to 65,535 inclusive.
        An int is a 32-bit signed integer, with a much larger range.
        When you cast an int to a char, you are effectively reducing its size and taking the lowest 16 bits of the integer. If the int value is within the valid range for a char, the cast works as you might expect. If the int is outside the range for char, the value will be truncated.

        Casting Between Other Primitives:
        You can cast between other primitives as well, like double to int (which truncates the decimal), long to int (which may result in loss of data), etc.
        However, implicit narrowing conversions (where you might lose information, like from long to int) need an explicit cast, while widening conversions (like from int to long) do not.

        Casting with Objects:
        Casting among objects follows a different set of rules than primitives.
        You can only cast between objects if there's a valid inheritance relationship (either superclass to subclass or vice-versa).
        If you try to cast between unrelated classes, you'll get a compile-time error. Even if you bypass that, at runtime, you'd get a ClassCastException.

        Primitive Wrappers:
        Java has wrapper classes for each primitive type (e.g., Integer for int, Character for char).
        You can't cast between unrelated wrapper objects directly. For example, you can't cast an Integer object to a Character object. You'd need to first convert to primitives and then perform the cast.
        */

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
