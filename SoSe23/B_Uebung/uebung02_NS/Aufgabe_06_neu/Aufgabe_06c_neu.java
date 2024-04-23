package SoSe23.B_Uebung.uebung02_NS.Aufgabe_06_neu;

import java.util.Scanner;

public class Aufgabe_06c_neu {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 0; i < args.length; i++){
            Scanner myScanner = new Scanner(args[i]);

            while (myScanner.hasNextInt()){
                sum = sum + myScanner.nextInt();
            }

            myScanner.close();

        }

        System.out.println(sum);
        

    }
    
}
