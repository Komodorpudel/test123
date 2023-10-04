package C_BP.bp13_sub.Aufgabe_02_neu;

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