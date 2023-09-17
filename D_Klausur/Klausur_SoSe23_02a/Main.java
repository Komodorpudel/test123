package D_Klausur.Klausur_SoSe23_02a;

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
}
