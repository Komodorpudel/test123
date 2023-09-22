package B_Uebung.uebung02_NS.Aufgabe_07;

import java.util.Random;

public class Aufgabe_07c {
    
    public static void main (String[] args){

        Random myRandom = new Random();

        double a = myRandom.nextDouble();

        Double wrapperA = Double.valueOf(a);

        double e = myRandom.nextDouble(0, 999);

        double x = wrapperA * Math.pow(10, e);

        System.out.println(x);

        Double wrapperX = Double.valueOf(x);

        Boolean xInfinite = wrapperX.isInfinite();

        System.out.println(xInfinite);

        String stringX = String.valueOf(x);
        System.out.println(stringX);

        stringX = String.valueOf(wrapperX);
        System.out.println(stringX);

    }
}
