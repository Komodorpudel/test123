package B_Uebung.uebung04_sub_4P.Aufgabe_16_neu;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Aufgabe_16b_neu {

    public static void main (String[] args){
        LocalDate now = LocalDate.now();

        int monatsEnde = now.lengthOfMonth();

        int tageBisMonatsende = monatsEnde - now.getDayOfMonth();

        System.out.println(tageBisMonatsende);

        LocalDate index = now;

        int weekend = 0;

        while (index.getMonth() == now.getMonth()){

            if(index.getDayOfWeek() == DayOfWeek.SATURDAY || index.getDayOfWeek() == DayOfWeek.SUNDAY){
                weekend++;
            }
            index.plusDays(1);

        }

        System.out.println(weekend);

    }
    
}
