package SoSe23.B_Uebung.uebung12_NS.A59_neu;

public class DemandTruck extends Thread {

    private Warehouse warehouse;
    int value;

    public DemandTruck (Warehouse warehouse, int value) {
        this.warehouse = warehouse;
        this.value = value;
    }

    public void run() {
        warehouse.demand(value);
    }
}