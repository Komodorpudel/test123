package SoSe23.B_Uebung.uebung01_NS.Aufgabe_02;

public class Aufgabe_02a {

    public static void main(String[] args){
        System.out.println(args.length); // ACHTUNG! length nicht length() weil property und nicht funktion

        if(args.length > 1) {

            int count = 0;

            for (int i = 0; i < args[1].length(); i++){ // Achtung, bei String ist es length()

                if (args[1].charAt(i) == 't'){
                    count++;
                }

            }

            System.out.println("Anzahl:" + count);

        }

    }
    
}
