package bp05_sub;

class Smartphone extends Product {

    // --------------------------------------

    // Attribut
    private final String brand;

    // --------------------------------------

    // Konstruktor
    public Smartphone(String brand, int productID, String name) throws IdAlreadyUsedException {
        super(name, productID);
        this.brand = brand;
    }

    // --------------------------------------

    // getBrand
    public String getBrand() {
        return brand;
    }

    // --------------------------------------

}

