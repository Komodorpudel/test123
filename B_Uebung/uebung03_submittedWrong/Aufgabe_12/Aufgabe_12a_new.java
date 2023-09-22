package B_Uebung.uebung03_submittedWrong.Aufgabe_12;

public class Aufgabe_12a_new {

    public static void main(String[] args) {


        // CharSequence is an Interface, but as any Interface can also be an object
        CharSequence[] charArray = new CharSequence[args.length];

        System.arraycopy(args, 0, charArray, 0, args.length);

        String myString = "matik";

        CharSequence myChar = myString;

        for(int i = 0 ; i < charArray.length; i++){
            int index = charArray[i].toString().indexOf(myString);
            if(index != -1){
                System.out.println("gefunden an position" + index + "in wort" + i);
            }

        }

    }
    
}
