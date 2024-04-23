package SoSe23.B_Uebung.uebung01_NS.Aufgabe_01;

import java.util.function.BiPredicate;

public class Aufgabe_01a {
    public static void main (String[] args) {

        for (int i = 0; i <= 100; i++){
            alleTeiler(i);
        }

    }

    public static void alleTeiler (int n) {

        BiPredicate <Integer,Integer> istTeiler = (number, divisor) -> number % divisor == 0; 
        
        for (int i = 100; i > 1; i--) {

            if(istTeiler.test(n,i)) {  // so sollte man Predicate nicht verwenden, die idee von predicate ist es, Bedingungne herumzureichen, z.B. zu einer Methode die eine Liste filtert
                System.out.print(i + ",");
            }
        }
        System.out.print("1\n");
    }

}