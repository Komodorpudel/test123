package E_Other;

public class SumCalculator {

    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 10;

        int sum = add(number1, number2);

        System.out.println("The sum of " + number1 + " and " + number2 + " is: " + sum);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}