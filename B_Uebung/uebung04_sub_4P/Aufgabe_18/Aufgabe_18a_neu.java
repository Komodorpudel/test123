package B_Uebung.uebung04_sub_4P.Aufgabe_18;

import java.util.HashMap;

public class Aufgabe_18a_neu {

    public static void main (String[] args){

        HashMap <Character, Integer> myHashMap = new HashMap<> ();

        for (String arg : args){

            for (char c : arg.toCharArray()){

                if (myHashMap.containsKey(c)) {
                    myHashMap.put(c, myHashMap.get(c) + 1); // hier macht er Autoboxing weil con char to Character
                }

                else {
                    myHashMap.put(c,1);
                }
            }
        }

        for (Character c : myHashMap.keySet()){
            System.out.println(c + " ; " + myHashMap.get(c));
        }
    }
    
}
