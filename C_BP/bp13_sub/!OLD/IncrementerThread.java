public class IncrementerThread extends Thread {
    private final Counter counter;
    private final int times;

    public IncrementerThread(Counter counter, int times) {
        this.counter = counter;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            // Das Schlüsselwort 'synchronized' stellt sicher, dass nur ein Thread zu einem bestimmten
            // Zeitpunkt Zugriff auf die Methode hat. Dies ist notwendig, um Inkonsistenzen beim
            // Inkrementieren des Zählers zu vermeiden, da mehrere Threads den Zähler gleichzeitig 
            // inkrementieren könnten.
            counter.increment();
        }
    }
}
