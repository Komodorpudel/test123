package SoSe23.B_Uebung.uebung04_sub_4P.Aufgabe_18;

// Necessary packages/classes:
import java.util.HashMap;
import java.util.Map;
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/package-summary.html
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html
//


public class Aufgabe_18a {

    // --------------------------------------

    public static void main(String[] args) {

        // Erstellen Sie ein streng typisiertes HashMap-Objekt f¨ur Character-Integer-Paare und eine 
        // Variable map, welche dieses Objekt referenziert.
        Map<Character, Integer> map = new HashMap<>();

        // Iterieren Sie über die Kommandozeilenparameter des Programms
        for (String param : args) {
            for (char c : param.toCharArray()) {
                
                // Berechnen Sie, wie oft jedes enthaltene Zeichen vorkommt
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        // Geben Sie für alle enthaltenen Zeichen die jeweilige Anzahl der Vorkommen aus
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Zeichen '" + entry.getKey() + "' kommt " + entry.getValue() + " mal vor.");
        }
    }

    // --------------------------------------

}
