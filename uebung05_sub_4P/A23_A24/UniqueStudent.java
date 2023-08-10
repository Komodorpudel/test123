package uebung05_sub_4P.A23_A24;

// Necessary packages/classes:
import java.util.HashMap;
import java.util.Map;
//

// Teilaufgabe c.3. Erstellen Sie eine neue Klasse UniqueStudent, die von der Klasse Student erbt.

public class UniqueStudent extends Student_c {

    // --------------------------------------

    // Attribute:
    // Teilaufgabe c.4. Verwenden Sie eine Klassenvariable geeigneten Typs, um einerseits die Einzigartigkeit
    //                  von Matrikelnummern sicherzustellen und andererseits einen leichten Zugriff auf
    //                  UniqueStudent-Objekte anhand ihrer Matrikelnummer zu erm¨oglichen.
    private static Map<Integer, UniqueStudent> students = new HashMap<>();
    // SAH: Da "static" teilen sich alle Instanzen von UniqueStudent eine HashMap

    // --------------------------------------

    // Konstruktur:
    public UniqueStudent(String name, int matrikelNummer) throws DuplicateException {

        // Teilaufgabe c.5. Im Konstruktor der Klasse UniqueStudent rufen Sie zuerst den Konstruktor der Oberklasse
        //                  auf.
        super(name, matrikelNummer);

        // Teilaufgabe c.6. Danach ¨uberpr¨ufen Sie, ob die Matrikelnummer bereits vergeben ist – wenn das der
        //                  Fall ist, soll eine passende DuplicateException geworfen werden.
        if (students.containsKey(matrikelNummer)) {
            throw new DuplicateException("Matrikelnummer", String.valueOf(matrikelNummer));
        }

        // SAH: Platziert die matrikelnummer in der HashMap
        students.put(matrikelNummer, this);
    }

    // --------------------------------------

    // Teilaufgabe c.7. Erstellen Sie eine Klassenmethode, die eine Matrikelnummer erwartet und das
    //                  UniqueStudent-Objekt mit der jeweiligen Matrikelnummer zur¨uckgibt, sofern es existiert
    //                  und sonst null.
    public static UniqueStudent getByMatrikelNummer(int matrikelNummer) {
        return students.get(matrikelNummer);
    }

    // --------------------------------------

}
