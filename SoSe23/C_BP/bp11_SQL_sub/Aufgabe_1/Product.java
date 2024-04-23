package SoSe23.C_BP.bp11_SQL_sub.Aufgabe_1;

// package Uebung_11;

public class Product {

    // Attribute
    private int id;
    private String name;
    private double price;

    // --------------------------------------

    // Konstruktor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // --------------------------------------

    // getId
    public int getId() {
        return id;
    }

    // --------------------------------------

    // getName
    public String getName() {
        return name;
    }

    // --------------------------------------

    // getPrice
    public double getPrice() {
        return price;
    }

    // --------------------------------------

    // toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    // --------------------------------------
    
}
