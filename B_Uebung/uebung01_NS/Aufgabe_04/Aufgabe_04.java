package B_Uebung.uebung01_NS.Aufgabe_04;

public class Aufgabe_04 {

    public static void main (String[]args){

    String test = "Ich hasse mein Leben";

    System.out.println(reverseAllWords(test));

    }

    public static String reverseAllWords(String s) {

        String[] myString = s.split(" ");

        for (String h : myString){
            System.out.println(h);
        }

        String reverseString = "";

        for (int i = 0; i < myString.length; i++){

            reverseString = reverseString.concat(new StringBuilder(myString[i]).reverse().toString());
            reverseString = reverseString.concat(" ");

        }

        return reverseString;
    }
    
}
