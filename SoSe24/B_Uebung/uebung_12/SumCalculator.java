public class SumCalculator                           {
    public static final int[] set1 = {1, 2, 3, 4, 5};
    public static final int[] set2 = {6, 7, 8, 9, 10};
    
    private int[] numbers;
    private int sum;

    public SumCalculator(int[] numbers) {
        this.numbers = numbers;
        this.sum = 0;
    }

    public int getSum() {
        return sum;
    }
}
