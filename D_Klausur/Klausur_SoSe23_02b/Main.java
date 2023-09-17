package D_Klausur.Klausur_SoSe23_02b;

import java.lang.Integer;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    // --------------------------------------
    
    public static void main (String [] args){

        if (args.length != 2){
            System.err.println("Fehlerhafte Eingabe");
        }

        for (String arg : args){
            if(!isInteger(arg)){
                System.err.println("Fehlerhafte Eingabe 2");
            }
        }

        try{
            int length = Integer.parseInt(args[0]);
            System.out.println("length: " + length);

            int max = Integer.parseInt(args[1]);
            System.out.println("max: " + max);
        
            int[] array = new int [length];

            Random myRandom = new Random();

            for(int i = 0; i < array.length; i++){
                array[i]= myRandom.nextInt(max);
            }

            System.out.println("arrayWithDuplicates:");

            for (int i = 0; i < array.length; i++){
                System.out.println(array[i]);
            }

            ArrayList <Integer> arrayWithoutDuplicates = removeDuplicatesB(array);

            System.out.println(arrayWithoutDuplicates);

        }

        catch (NumberFormatException e) {
            System.out.println("error");

        }
    }

    // --------------------------------------

    // Optional

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        
        catch (NumberFormatException e) {
            return false;
        }

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
