package C_BP.bp13_sub;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Initialisieren Sie ein Counter-Objekt.
        Counter counter = new Counter();
        
        // 2. Erzeugen und starten Sie drei Threads, die jeweils 50 Mal den Zähler inkrementieren. Die
        // Threads sollen dabei parallel arbeiten.
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counter.increment();  // Das Schlüsselwort 'synchronized' ist erforderlich, um gleichzeitigen Zugriff zu verhindern
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counter.increment();  // Das Schlüsselwort 'synchronized' ist erforderlich, um gleichzeitigen Zugriff zu verhindern
            }
        });
        
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counter.increment();  // Das Schlüsselwort 'synchronized' ist erforderlich, um gleichzeitigen Zugriff zu verhindern
            }
        });

        // Starten der Threads
        thread1.start();
        thread2.start();
        thread3.start();
        
        // 3. Warten Sie, bis alle Threads ihre Aufgabe beendet haben und geben Sie den aktuellen Wert
        // des Zählers aus.
        thread1.join();
        thread2.join();
        thread3.join();
        
        // Ausgeben des aktuellen Wertes des Zählers
        System.out.println("Endwert des Zählers: " + counter.getCount());
    }
}
