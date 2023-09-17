package B_Uebung.uebung04_sub_4P;

// Necessary packages/classes:
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//

public class Aufgabe_18b {

    // --------------------------------------

    public static double averageRelativeDeltaFromMean(Map<Integer, Integer> map) {
        
        // 1. zuerst den Durchschnittswert der Values f¨ur alle Keys berechne
        double sum = 0.0;

        for (Integer value : map.values()) {
            sum = sum + value;
        }
        double avg = sum / map.size();

        // 2. f¨ur jeden Key die relative absolute Abweichung von diesem Durchschnittswert berechnet
        double sumRelativeDeltas = 0.0;

        for (Integer value : map.values()) {
            sumRelativeDeltas = sumRelativeDeltas + Math.abs(value - avg) / avg;
        }
        // 3. den Durchschnitt dieser relativen Abweichungen f¨ur alle Keys berechnet und zur¨uckgibt.
        return sumRelativeDeltas / map.size();
    }

    // --------------------------------------

    public static void main(String[] args) {

        // 1. erzeugen Sie ein HashMap<Integer, Integer>-Objekt und ...
        Map<Integer, Integer> map = new HashMap<>();

        // ... initialisieren Sie die Werte für die Keys 0 bis 9 mit 0
        for (int i = 0; i < 10; i = i + 1) {
            map.put(i, 0);
        }

        // 2. Berechnen Sie 10 zufällige Zahlen zwischen 0 und 9 und ...
        Random rand = new Random(); // random seed

        for (int i = 0; i < 10; i = i + 1) {
            int num = rand.nextInt(10);
        
            // ... zählen Sie deren Vorkommen in Ihrer Map
            map.put(num, map.get(num) + 1);
        }

        // 3. Berechnen Sie die durchschnittliche relative Abweichung und geben diese aus
        double avgRelDelta = averageRelativeDeltaFromMean(map);
        System.out.println("Durchschnittliche relative Abweichung: " + avgRelDelta);

        // 4. Erzeugen Sie dann so lange zufällige Zahlen zwischen 0 und 9, bis die durchschnittliche relative Abweichung weniger als 0.01 beträgt
        while (avgRelDelta >= 0.01) {

            // Generiere Zufallszahl zwischen 0 und 9
            int num = rand.nextInt(10);

            // Zähle hoch in map
            map.put(num, map.get(num) + 1);

            // Berechne averageRelativeDelta neu
            avgRelDelta = averageRelativeDeltaFromMean(map);
        }

        // 5. Geben Sie dann die Anzahl der berechneten Zahlen aus
        int total = 0;
        for (int count : map.values()) {
            total += count;
        }
        System.out.println("Anzahl der berechneten Zahlen: " + total);
    }

    // --------------------------------------
    
}
