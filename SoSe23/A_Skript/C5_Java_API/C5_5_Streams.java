package SoSe23.A_Skript.C5_Java_API;

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

    // Collections können mit Stream durchlaufen werden
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
                char RandomChar = (char) (97 + myRandom.nextInt(26)); // Wir casten hier, mehr unten
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
        int max = Arrays.stream(numbers)
                        .reduce(0,(a,b) -> (a > b) ? a : b); // Reduce acts like a terminal operation
        // Used an Identity, serves as starting point or default result when stream empty

        System.out.println(max);

        // Alterantiv zu Identity:
        // Optional <T> enthält enweder T oder ist leer
        OptionalInt max2 = Arrays.stream(numbers)
                                    .reduce((a,b) -> (a > b) ? a : b);

        System.out.println(max2);

    }
    
}

    /*
    In Java, many objects can be sources for streams. Here are some of the most common ones:

    Collections: Most collections in the Java Collections Framework can create streams:

    Collection.stream(): Provides a sequential stream.
    Collection.parallelStream(): Provides a possibly parallel stream.
    Example:
    List<String> myList = Arrays.asList("a", "b", "c");
    Stream<String> stream = myList.stream();

    Arrays: Arrays can be turned into streams using Arrays.stream() or Stream.of().
    Example:
        int[] intArray = {1, 2, 3, 4};
        IntStream intStream = Arrays.stream(intArray);

    String[] strArray = {"a", "b", "c"};
    Stream<String> stringStream = Stream.of(strArray);

    Strings: Strings can be turned into an IntStream of characters using the chars() method.
    Example:
        String s = "hello";
        IntStream charStream = s.chars();

    I/O Channels: For example, BufferedReader has a lines() method that returns a stream of lines from the given reader.
    Example:
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        Stream<String> lines = reader.lines();

    Random Numbers: The Random class can produce streams of random numbers.
    Example:
        Random random = new Random();
        IntStream randomInts = random.ints();

    Static Methods in the Stream class: These methods can be used to create streams:
    Stream.of(): Creates a stream from one or more explicit values.
    Stream.iterate(): Creates a stream by iteratively applying a function.
    Stream.generate(): Creates a stream by generating values on the fly.
    Examples:
        Stream<String> fromValues = Stream.of("a", "b", "c");
        Stream<Integer> fromIterate = Stream.iterate(0, n -> n + 1);
        Stream<Double> fromGenerate = Stream.generate(Math::random);

    Other: There are other sources like BitSet, Pattern, and JarFile which also have methods to produce streams.

    Remember, in addition to these, third-party libraries might provide their own data structures and objects that can be turned into streams, or they might extend existing Java objects with capabilities to produce streams.
 */