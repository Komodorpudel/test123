package A_Skript.C5_Datum_und_Zeit;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C5_4_Lambda_Ausdrücke {

        public static void main (String[] args){

        // +++++++++++

        //S37 - TreeSet mit forEach Methode und Lambda
        TreeSet<Integer> myTreeSet = new TreeSet<Integer>();

        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(3);
        myTreeSet.add(4);
        myTreeSet.add(5);

        myTreeSet.forEach(n -> System.out.println(n)); //Vor Pfeil steht der Eingabeparameter

        // Lambda geht nur mit Objecten, die bestimmte Schnittstellen implementieren

        // +++++++++++

        // S41 - Predicate
        // Gibt immer ein Boolean zurück
        System.out.println("\nPredicate:");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        
        // Predicate<Integer> isEven = n -> n % 2 == 0;
        /*
        List<Integer> evenNumbers = numbers.stream()
                                            .filter(isEven)
                                            .collect(Collectors.toList());
        */
        List<Integer> evenNumbers = numbers.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());

        System.out.println(evenNumbers);  // [2, 4]

        // +++++++++++

        //S41 - Function
        System.out.println("\nFunction:");

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);

        // Function<Integer, Integer> square = (Integer number) -> number * number;
        /* List<Integer> squaredNumbers = numbers2.stream()
                                              .map(square)
                                              .collect(Collectors.toList());
        */
        
        List<Integer> squaredNumbers = numbers2.stream()
                                              .map(n -> n * n)
                                              .collect(Collectors.toList());

        System.out.println("Original numbers: " + numbers2);
        System.out.println("Squared numbers: " + squaredNumbers);
        
        // +++++++++++

        //S43 - Lambda mit Consumer
        System.out.println("\nLambda with Consumer:");
        Consumer <Object> c = (n) -> {System.out.println(n);};

        myTreeSet.forEach(c);

        // +++++++++++

        // S44 - Supplier (z.B. für Stream.generate()
        System.out.println("\nSupplier:");

        // Supplier <Double> myRand = () -> Math.random();

        /*
        List<Double> randomNumbers = Stream.generate(myRand)
                                           .limit(10)
                                           .toList();
        */

        List<Double> randomNumbers = Stream.generate(() -> Math.random())
                                        .limit(10)
                                        .toList();

        System.out.println("Generated random numbers: " + randomNumbers);

    }

        // +++++++++++
        
        // S4





}

