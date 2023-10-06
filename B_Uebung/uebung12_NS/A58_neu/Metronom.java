package B_Uebung.uebung12_NS.A58_neu;

public class Metronom implements Runnable {

    public final int x; // bis dahin wird gezäglt
    private int count; // interne hilfsvariable

    private Thread metronomThread;

    public Metronom (int x){
        this.x = x;

        // Start
        start();
    }

    // --------------------------------------------------

    public void start() {


        // Das hätte ich eigentlich auch in den Konstruktor reinschmeißen können -> Nein warte; Problem: this würde dann nicht funktioniren glaube ich
        if (metronomThread == null) {
            count = 1;
            metronomThread = new Thread(this);

            // Run aufrufen
            metronomThread.start();
        }

    }

    // --------------------------------------------------

    public void stop() {

        if (metronomThread != null) {
            metronomThread.interrupt();
            metronomThread = null;
        }
    }

    // --------------------------------------------------

    @Override
    public void run() {
        while (!metronomThread.isInterrupted()) {
            try {
                System.out.println(count++);

                if (count > x) {
                    count = 1;
                }

                Thread.sleep(1000);
            }

            catch (InterruptedException e) {
                break;

            }

        }
    }

    // --------------------------------------------------

    public static void main (String [] args){
        new Metronom(10);
    }
    
}
