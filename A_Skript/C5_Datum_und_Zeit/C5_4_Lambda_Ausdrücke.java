package A_Skript.C5_Datum_und_Zeit;

import java.util.ArrayList;
import java.util.TreeSet;

public class C5_4_Lambda_Ausdrücke {

        public static void main (String[] args){


        //S37 - TreeSet mit forEach Methode und Lambda
        TreeSet<Integer> myTreeSet = new TreeSet<Integer>();

        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(3);
        myTreeSet.add(4);
        myTreeSet.add(5);

        myTreeSet.forEach(n -> System.out.println(n));

        // Lambda geht nur mit Objecten, die bestimmte Schnittstellen implementieren

    }
}
