package SoSe23.B_Uebung.uebung04_sub_4P.Aufgabe_16;

// Necessary packages/classes:
import java.time.LocalDate;
import java.time.Period;
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/package-summary.html
//

public class Aufgabe_16a {

    // --------------------------------------
    public static void main(String[] args) {
        
        // 1. Erstellen Sie ein LocalDate-Objekt für das aktuelle Datum
        LocalDate heute = LocalDate.now();

        // 2. Erstellen Sie ein LocalDate-Objekt für den vorläufigen Termin der ersten Klausur
        //    1. August 2023
        LocalDate klausurtermin = LocalDate.of(2023, 8, 1);

        // 3. Erstellen Sie ein Period-Objekt, das die Zeitspanne vom aktuellen Datum zum Prüfungstermin enthält
        Period bisZurKlausur = Period.between(heute, klausurtermin);

        // 4. Die verbleibenden Monate und Tage auf der Kommandozeile ausgeben
        System.out.println("Verbleibende Monate: " + bisZurKlausur.getMonths());
        System.out.println("Verbleibende Tage: " + bisZurKlausur.getDays());
    }

    // --------------------------------------
}
