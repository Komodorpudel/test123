public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        IncrementerThread thread1 = new IncrementerThread(counter, 50);
        IncrementerThread thread2 = new IncrementerThread(counter, 50);
        IncrementerThread thread3 = new IncrementerThread(counter, 50);

        thread1.start();
        thread2.start();
        thread3.start();

        // Warten, bis alle Threads ihre Arbeit beendet haben
        thread1.join();
        thread2.join();
        thread3.join();

        // Den aktuellen Wert des Zählers ausgeben
        System.out.println("Finaler Zählerwert: " + counter.getCount());
    }
}
