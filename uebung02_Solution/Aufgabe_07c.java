package uebung02_Solution;


   import java.util.Random;
   public class Aufgabe_07c {
       public static void main(String[] args) {
Random rng = new Random();
double a = Math.random();
Double wrapperA = Double.valueOf(a);
int e = rng.nextInt(0, 1000);
double x = wrapperA.doubleValue() * Math.pow(10, e);
Double wrapperX = Double.valueOf(x);
if (wrapperX.isInfinite()) {
    System.out.println("Inhalt von x ist unendlich");
} else {
    System.out.println("Inhalt von x ist nicht unendlich");
}
String stringX = String.valueOf(x);
System.out.println(stringX);
stringX = wrapperX.toString();
System.out.println(stringX);
       }
    }