package B_Uebung.uebung04_sub_4P.Aufgabe_18_neu;

import java.util.Map;

public class Aufgabe_18b_neu {

    public static void main (String[] args){

    }

    public static double averageRelativeDeltaFromMean(Map<Integer, Integer> inputMap){

        double sum = 0;

        for (Integer key : inputMap.keySet()){

            sum = sum + inputMap.get(key); // wie oft wurde eine bestimmte zahl zufällig gewählt
        }

        double average = sum / inputMap.size(); // der durchschnitt der Vorkommnisse aller Zahlen / 20x 1 und 10x 2 ergibt im Schnitt 15x

        return average;
        
    }

    // rekatuve absolute abweichung




    
}
