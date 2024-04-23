package SoSe23.B_Uebung.uebung04_sub_4P.Aufgabe_16_neu;

import java.time.LocalDate;
import java.time.Period;

public class Aufgabe_16a_neu {

    public static void main (String[] args){
        LocalDate today = LocalDate.now();

        LocalDate exam = LocalDate.of(2023, 10, 2);

        Period bisZurKlausur = Period.between(today, exam);

        System.out.println(bisZurKlausur.getDays() + "monate" + bisZurKlausur.getMonths());
    }
    
}
