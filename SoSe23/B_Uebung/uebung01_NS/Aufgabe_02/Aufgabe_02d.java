package SoSe23.B_Uebung.uebung01_NS.Aufgabe_02;

public class Aufgabe_02d {

    public static void main (String[] args){

        if (args.length < 1){
            System.exit(1);
        }
        else{
            String str = "";

            for (int i = 0; i < args.length; i++){
                str.concat(args[i].replace("STOP", "."));
                str.concat("\n");
            }

            System.out.println(str);

        }

    }
    
}
