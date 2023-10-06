package D_Klausur.SoSe23.Aufgabe_03;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collection;


public class Main {

    public static void main (String[] args){
        ArrayList <Integer> list = new ArrayList<>();

        list.add(2); //
        list.add(3);
        list.add(4); // 
        list.add(5);
        list.add(6); //

        System.out.println(squaresumB(list));
    }
    
    public static Integer squaresum (Collection <Integer> c){
        int sum = c.stream()
                            .mapToInt(Integer::intValue)
                            .filter(n -> n % 2 == 0)
                            .map(n -> n * n)
                            .sum(); // Funktioniert nur mit einem intStream
        return sum;
    }

        public static Integer squaresumB (Collection <Integer> c){
        Integer sum = c.stream()
                            .filter(n -> n % 2 == 0)
                            .map(n -> n * n)
                            .reduce((n,m) -> n + m)
                            .orElse(0);
                             
        return sum;
    }
}
