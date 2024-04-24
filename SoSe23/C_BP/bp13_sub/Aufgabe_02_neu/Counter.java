package SoSe23.C_BP.bp13_sub.Aufgabe_02_neu;

public class Counter {
    private int count = 0;

    // Das hier ist weder ein Thread noch implementiert es Runnable, so dass es von einem Thread ausgeführt werden kann.

    // Aber die Methode increment ist synchronized so dass diese nur von einem Thread benutzt werden kann

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