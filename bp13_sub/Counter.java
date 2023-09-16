package bp13_sub;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(count);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }
}