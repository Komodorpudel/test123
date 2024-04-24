package SoSe23.B_Uebung.uebung01_NS.Aufgabe_02;

public class Aufgabe_02a_Stream {
    
    public static void main(String[] args){
        System.out.println(args.length); // ACHTUNG! length nicht length() weil property und nicht funktion

        if(args.length > 1) {

            long count = args[1].chars()
                                .filter(n -> n == 't')
                                .count();

            System.out.println(count);

        }

    }
    
}
