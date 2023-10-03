package B_Uebung.uebung12_NS.A59_neu;

public class Warehouse {
    private int stock = 0;

    public synchronized void supply(int value) {
        stock += value;
    }

    public synchronized void demand(int value) {
        stock -= value;
    }

    public void print() {
        System.out.println(stock);
    }

    public static void main(String[] args) throws InterruptedException {

        Warehouse w = new Warehouse();

        SupplyTruck t1 = new SupplyTruck(w, 5);
        DemandTruck t2 = new DemandTruck(w, 3);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        w.print();
    }



}