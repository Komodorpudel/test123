package B_Uebung.uebung04_sub_4P.Aufgabe_19_neu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Aufgabe_19a_neu {

    public static void main (String[] args){

        List <String> myStringList = new ArrayList<>(Arrays.asList(args));

        UnaryOperator<String> toUpper = a -> a.toUpperCase();

        myStringList.replaceAll(toUpper);

        Predicate <String> startswithA = s -> s.startsWith("A");

        myStringList.removeIf(startswithA);

        myStringList.forEach(s -> System.out.println(s));

    }
    
}
