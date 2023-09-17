package A_Skript.C5_Datum_und_Zeit;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class C5_1_Datum_und_Zeit {

    public static void main(String[] args){

        Instant start = Instant.now();

        ZoneId zone = ZoneId.of("America/New_York");

        LocalDateTime time = LocalDateTime.ofInstant(start, zone);

        //parse

        try{

            LocalTime argsTime = LocalTime.parse(args[0]);
            System.out.println(argsTime);

        }

        catch(ArrayIndexOutOfBoundsException e) {
            System.err.println("No time provided as argument");
        }

        System.out.println("time:" + time);

        // plusDays
        LocalDateTime newTime = time.plusDays(10);
        System.out.println("newTime: " + newTime);

        // printf
        System.out.println("\nFormatiertes Datum:");
        System.out.printf("%d. %s. %d\n",newTime.getDayOfMonth(), newTime.getMonth(), newTime.getYear());

        // if loop - square root
        for (long i = 0; i < 10000000; i++){
            // System.out.println(Math.sqrt(i));
        }

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Duration:" +duration);

        LocalDate semesterAnfang = LocalDate.of(23, 05, 13);

        // S9 - DateTimeFormatter
        DateTimeFormatter meinFormat = DateTimeFormatter.ofPattern("E, d.M.YYYY");

        System.out.println(meinFormat.format(semesterAnfang));

    }

}
