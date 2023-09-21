package B_Uebung.uebung01_NS.Aufgabe_03;

import java.util.Arrays;

public class Aufgabe_03d {

    public static void main (String[] args){

        int[] array = {3,4,5,67,7123,34,3,4,323};

        System.out.println(secondLargest(array));

    }

    public static int secondLargest (int[] array){

        int[] newArray = Arrays.copyOf(array, array.length);

        Arrays.sort(newArray);

        return newArray[newArray.length - 2];
    }
    
}
