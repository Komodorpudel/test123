package SoSe23.B_Uebung.uebung01_NS.Aufgabe_03;

public class Aufgabe_03b {
    
    public static void main(String[] args) {
        Integer myNumber = Integer.parseInt(args[0]);

        System.out.println(isFibonacci(myNumber));

    }

    public static Boolean isFibonacci(Integer myNumber) {

        int f1 = 1;
        int f2 = 1;
        int f3;

        if (myNumber == 1) {
            return true;
        }

        do {
            f3 = f1 + f2;

            if (f3 == myNumber){
                return true;
            }

            f1 = f2;
            f2 = f3;
        }
        while (f3 < myNumber);

        return false;

    }

}
