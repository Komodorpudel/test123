package SoSe23.B_Uebung.uebung12_NS.A60_neu;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread {

    private Warehouse warehouse;

    public Consumer (Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    
    @Override
    public void run() {

        try {
            while (true) {
                int value = warehouse.consume(); // Muss int value machen, weil consume ja was returned
                Thread.sleep(ThreadLocalRandom.current().nextInt(1,6)* 1000);

                // Nur damit meldung nicht auftaucht
                System.out.println(value);
                
            }
        }

        catch(InterruptedException e ) {

        }
    }
}