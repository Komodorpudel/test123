package SoSe23.A_Skript.C4_Java_Grundlagen;

import java.util.Arrays;
import java.util.List;
// import java.util.stream.Collectors;

public class C4_6_Arrays {

    public static void main (String[] args){

        // S73 - Normales Array
        int zahlenArray[] = new int[5];

        zahlenArray[1] = 666;

        int zahlenArrayB[] = new int[5];

        zahlenArrayB[1] = 666;

        // Array-Length (not size!!!!!!!)
        System.out.println("\nArray-Length:");
        System.out.println(zahlenArray.length); // This is not a method but a property (keine Klammern deshalb)

        // Printet Addresse
        System.out.println(zahlenArray);

        // Printed Inhalt
        System.out.println(Arrays.toString(zahlenArray));

        //equals
        System.out.println("\nEquals:");
        System.out.println(Arrays.equals(zahlenArray, 0, 5, zahlenArrayB, 0, 5));

        zahlenArrayB[3] = 3;
        System.out.println("Equals:");
        System.out.println(Arrays.equals(zahlenArray, 0, 5, zahlenArrayB, 0, 5));

        //Fill
        System.out.println("\nFill:");
        Arrays.fill(zahlenArrayB, 8888);
        System.out.println(Arrays.toString(zahlenArrayB));

        //asList
        System.out.println("\nasList von Integer Array aus:");

        Integer zahlenArrayC[] = new Integer[5];
        zahlenArrayC[4] = 5;

        List<Integer> zahlenListe = Arrays.asList(zahlenArrayC);
        System.out.println(zahlenListe);

        //asList
        System.out.println("\nasList von int Array aus:");

        // Eine LIste kann keine primitiven Datentypen aufnehmen, daher müssen wir die ints vorher in Integers verwanden via .boxed

        int zahlenArrayD[] = new int [5];
        zahlenArrayD[4] = 5;

        List<Integer> zahlenListeE = Arrays.stream(zahlenArrayD)
                                            .boxed()
                                            .toList();
                                            //.collect(Collectors.toList());

        System.out.println(zahlenListeE);

        // List - length
        System.out.println("\nList-Size:");
        System.out.println(zahlenListeE.size());

    }

}
