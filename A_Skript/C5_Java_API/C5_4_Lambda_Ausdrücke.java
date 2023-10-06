package A_Skript.C5_Java_API;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
// import java.util.function.Function;
// import java.util.function.Predicate;
// import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C5_4_Lambda_Ausdrücke {

        public static void main (String[] args){

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //S37 - TreeSet mit forEach Methode und Lambda
        TreeSet<Integer> myTreeSet = new TreeSet<Integer>();

        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(3);
        myTreeSet.add(4);
        myTreeSet.add(5);

        myTreeSet.forEach(n -> System.out.println(n)); //Vor Pfeil steht der Eingabeparameter

        // Lambda geht nur mit Objecten, die bestimmte Schnittstellen implementieren

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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

        // <Integer> ist der Input typ

        /*
        List<Integer> evenNumbers = numbers.stream()
                                            .filter(isEven)
                                            .collect(Collectors.toList());
        */
        List<Integer> evenNumbers = numbers.stream()
                                    .filter(n -> n % 2 == 0) // Predicate
                                    .collect(Collectors.toList());

        System.out.println(evenNumbers);  // [2, 4]

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //S41 - Function
        System.out.println("\nFunction:");

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);

        // Function<Integer, Integer> square = (Integer number) -> number * number;
        /* List<Integer> squaredNumbers = numbers2.stream()
                                              .map(square) // Function
                                              .collect(Collectors.toList());
        */
        
        List<Integer> squaredNumbers = numbers2.stream()
                                              .map(n -> n * n) // Function
                                              .collect(Collectors.toList());

        System.out.println("Original numbers: " + numbers2);
        System.out.println("Squared numbers: " + squaredNumbers);
        
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //S43 - Lambda mit Consumer
        System.out.println("\nLambda with Consumer:");
        Consumer <Object> c = (n) -> {System.out.println(n);};

        myTreeSet.forEach(c);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // S44 - Consumer
        System.out.println("\nConsumer:");
        // A Consumer is a functional interface in Java that represents an operation that accepts a single input argument and returns no result. Its primary method is accept(T t).
        StringBuilder mySB = new StringBuilder("Ich bin ein StringBuilder");

        // Consumer <StringBuilder> myConsumer = (StringBuilder s) -> {s.setLength(5);};
        System.out.println(mySB);


        /*      
        public class ConsumerExample1 {
            public static void main(String[] args) {
                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

                Consumer<Integer> printConsumer = num -> System.out.println(num);
                numbers.forEach(printConsumer);
        } */


        // System.out.println(myConsumer.accept(mySB)); Achtung, das geht nicht, weil der Consumer ja nichts returned
        // myConsumer.accept(mySB);

        // System.out.println(mySB);


        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        // S47 - Methodenreferenz

        // anstatt Supplier normal:
        Supplier <Double> mySupplier2 = () -> Math.random();

        Supplier <Double> mySupplier3 = Math::random;

        /*  
        Supplier<Double> mySupplier2 = new Supplier<Double>() {
            @Override
            public Double get() {
            return Math.random();
            }
        };
        */

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // S49 - UnaryOperator

        /*
        Using UnaryOperator<T> over Function<T, T> has a few advantages:

        Clarity: When someone sees UnaryOperator<T>, they instantly know that the input and output types are the same. With Function<T, T>, one has to look at both type parameters to confirm this. It's a hint about the function's purpose.

        Brevity: It's slightly shorter, which can make code easier to read, especially in cases with more complex generic type definitions.

        Semantics: Using specific interfaces like UnaryOperator<T> can convey intent more clearly than using a more general interface like Function<T, T>. When designing APIs or libraries, choosing a specific interface can provide users with clearer guidance on how something is meant to be used.

        However, it's worth noting that the difference is largely a matter of style and clarity. The actual functionality provided by Function<T, T> and UnaryOperator<T> is identical in the case where the input and output types are the same. Use whichever feels more readable and makes the code's intent clearer in your specific context.
        */

        UnaryOperator <Integer> myUnaryOperator = s -> s * s;

        // vs.

        Function<Integer, Integer> square = x -> x * x;

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++




}

