package SoSe23.D_Klausur.SoSe23.Aufgabe_02a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // --------------------------------------
    
    public static void main(String[] args){

        int[] aWithDuplicates = new int [10];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++){

            System.out.println("Bitte geben Sie eine ganze Zahl ein:");
        
            if (scanner.hasNextInt() == false) {
                System.err.println("Die eingegebene Zahl ist kein Integer");

                System.exit(1);
            }

            aWithDuplicates[i]= scanner.nextInt();
        }

        scanner.close();

        ArrayList <Integer> aWithoutDuplicates = removeDuplicatesB(aWithDuplicates);
        System.out.println(aWithoutDuplicates);

    }

    // --------------------------------------

    public static ArrayList<Integer> removeDuplicatesA (int[] a){

        ArrayList<Integer> aWithoutDuplicates = Arrays.stream(a)
                                                        .boxed()
                                                        .distinct()
                                                        .collect(Collectors.toCollection(ArrayList::new));

        return aWithoutDuplicates;
    }
    
    // --------------------------------------

    public static ArrayList<Integer> removeDuplicatesB (int[] a){

        ArrayList <Integer> aWithoutDuplicates = new ArrayList<Integer>();

        for (int value : a){
            if(!aWithoutDuplicates.contains(value)){
                aWithoutDuplicates.add(value);
            }
        }

        return aWithoutDuplicates;
    }
    
    // --------------------------------------

    // Das geht nicht. Man muss Arrays.stream(a) machen
    /* It's worth noting that for arrays of primitive types like int, long, and double,
    there are specialized stream classes (IntStream, LongStream, and DoubleStream respectively)
    that are returned by Arrays.stream(). These specialized streams offer additional methods tailored to the primitive types. */
    /*
    
    public static ArrayList<Integer> removeDuplicatesC (int[] a){

        ArrayList<Integer> aWithoutDuplicates = a.stream()
                                                        .distinct()
                                                        .collect(Collectors.toCollection(ArrayList::new));

        return aWithoutDuplicates;
    } */
    
    // --------------------------------------
}
