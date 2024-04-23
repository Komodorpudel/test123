package SoSe23.B_Uebung.uebung12_NS.A59_neu;

public class SupplyTruck extends Thread {

    private Warehouse warehouse;
    int value;

    public SupplyTruck(Warehouse warehouse, int value) {
        this.warehouse = warehouse;
        this.value = value;
    }

    public void run() {
        warehouse.supply(value);
    }

}
