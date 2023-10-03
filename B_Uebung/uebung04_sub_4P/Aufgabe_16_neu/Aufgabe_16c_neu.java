package B_Uebung.uebung04_sub_4P.Aufgabe_16_neu;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Aufgabe_16c_neu {

    public static void main (String[] args){
        LocalTime time1 = randomTime();
        LocalTime time2 = randomTime();

        LocalTime t1;
        LocalTime t2;

        if (time1.isBefore(time2)){

            t1 = time1;
            t2 = time2;
        }
        else{
            t2 = time1;
            t1 = time2;
        }

        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);

        while (Duration.between(t1,t2).toMinutes() > 15) {
            LocalTime time3 = randomTime();

            if (time3.isAfter(t1) && time3.isBefore(t2)){
                t2 = time3;
            }

        }

        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);

    }

    public static LocalTime randomTime(){

        Random myRandom = new Random();
        int hours = myRandom.nextInt(24); // es gibt keine 24te stunde

        int minutes = myRandom.nextInt(60); // gibt keine 60te minute

        return LocalTime.of(hours, minutes);
    }
    
}
