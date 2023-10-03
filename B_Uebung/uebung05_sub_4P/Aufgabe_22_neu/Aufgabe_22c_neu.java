package B_Uebung.uebung05_sub_4P.Aufgabe_22_neu;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aufgabe_22c_neu {

    public static void main (String[] args){

        Random myRandom = new Random();

        Supplier <Character> mySupplier = () -> {

            return (char) myRandom.nextInt('a', 'z');
        };

        Stream <String> myStream = Stream.generate(() -> {
            int length = myRandom.nextInt(5, 11);
            StringBuilder s = new StringBuilder();

            while (s.length() < length){
                s.append(mySupplier.get());
            }

            return s.toString();
        })
        .limit(500);

        IntStream myIntStream = myStream
                                .mapToInt(n -> n.length());

        System.out.println(myIntStream.average().orElseThrow());

    }
    
}
