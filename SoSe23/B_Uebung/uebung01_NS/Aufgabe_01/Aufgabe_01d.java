package SoSe23.B_Uebung.uebung01_NS.Aufgabe_01;

import java.util.Random;

public class Aufgabe_01d {

    public static void main (String[] args){

        Random myRandom = new Random();

        for (int i = 1; i <= 100; i++){

            if (myRandom.nextBoolean() == true){

                int myInt = myRandom.nextInt(1, 1000);

                System.out.println(myInt + " and Square root: " + Math.sqrt(myInt));
            }

        }

    }

}
