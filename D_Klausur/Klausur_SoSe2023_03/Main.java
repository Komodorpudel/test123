package D_Klausur.Klausur_SoSe2023_03;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collection;


public class Main {

    public static void main (String[] args){
        ArrayList <Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(squaresum(list));
    }
    
    public static Integer squaresum (Collection <Integer> c){
        int sum = c.stream()
                            .mapToInt(Integer::intValue)
                            .filter(n -> n % 2 == 0)
                            .map(n -> n * n)
                            .sum(); // Funktioniert nur mit einem intStream
        return sum;
    }
}
