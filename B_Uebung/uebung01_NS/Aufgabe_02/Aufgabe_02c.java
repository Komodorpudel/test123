package SoSe23.B_Uebung.uebung01_NS.Aufgabe_02;

public class Aufgabe_02c {

    public static void main(String[] args){

        if(args.length != 1){
            System.err.println("ungültige Eingabe");
        }

        else{

            try{ // Ist so nicht verlangt.
                String myString = args[0].toUpperCase();


                System.out.println(myString.substring(myString.lastIndexOf('A')));
                myString.lastIndexOf('A', 0);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("There are no As");
                System.exit(1);
            }
        }
    }
    
}
