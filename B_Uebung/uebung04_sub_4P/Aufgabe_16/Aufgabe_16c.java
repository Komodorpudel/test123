package B_Uebung.uebung04_sub_4P.Aufgabe_16;

// Necessary packages/classes:
import java.time.LocalTime;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/package-summary.html
//

public class Aufgabe_16c {

    // --------------------------------------

    // Methode zur Generierung einer zufälligen Uhrzeit
    public static LocalTime zufaelligeUhrzeit() {
        int stunde = ThreadLocalRandom.current().nextInt(0, 24);
        int minute = ThreadLocalRandom.current().nextInt(0, 60);

        // Return
        return LocalTime.of(stunde, minute);
    }

    // --------------------------------------

    public static void main(String[] args) {

        // Zwei zufällige Zeiten bestimmen
        LocalTime t1 = zufaelligeUhrzeit();
        LocalTime t2 = zufaelligeUhrzeit();

        // Speichern Sie die frühere der beiden Zeiten in der Variable t1, die spätere in der Variable t2
        if (t2.isBefore(t1)) {
            LocalTime temp = t1;
            t1 = t2;
            t2 = temp;
        }

        // Geben Sie beide Zeiten aus
        System.out.println("Zeit t1: " + t1);
        System.out.println("Zeit t2: " + t2);

        // Bestimmen Sie dann, solange zwischen t1 und t2 mehr als 15 Minuten liegen, eine neue zufällige Zeit
        while (Duration.between(t1, t2).toMinutes() > 15) {
            LocalTime neueZeit = zufaelligeUhrzeit();
            
            // mit der sie t2 überschreiben, sofern die neue Zeit zwischen t1 und dem alten Wert von t2 liegt
            if (neueZeit.isAfter(t1) && neueZeit.isBefore(t2)) {
                t2 = neueZeit;
            }
        }

        // Geben Sie am Ende die neue Zeiten jeweils in einer eigenen Zeile auf der Kommandozeile aus
        System.out.println("Neue Zeit t1: " + t1);
        System.out.println("Neue Zeit t2: " + t2);
    }

    // --------------------------------------

}
