package SoSe23.B_Uebung.uebung02_NS.Aufgabe_07;

import java.util.Random;

public class Aufgabe_07a {

    public static void main(String[] args){
        Random myRandom = new Random();

        int x = myRandom.nextInt();

        System.out.println(x);

        System.out.println(Integer.reverse(x));
        System.out.println(Integer.reverseBytes(x));
        System.out.println(Integer.highestOneBit(x));

    }
    
}
