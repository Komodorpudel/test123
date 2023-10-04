package C_BP.bp09_sub;

import java.util.ArrayList;

public class Restaurant {

    // --------------------------------------

    private String kategorie;
    private String name;
    private ArrayList<Stammtisch> stammtische = new ArrayList<>();
    private ArrayList<Gast> gaeste = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////

    // --------------------------------------

    // Konstruktor
    public Restaurant(String kategorie, String name) {
        this.kategorie = kategorie;
        this.name = name;
    }

    // --------------------------------------

    // Methoden zum Hinzufügen von Stammtischen und Gästen
    public void addStammtisch(Stammtisch stammtisch) {
        stammtische.add(stammtisch);

        System.out.println(kategorie + name);
    }

    public boolean addGast(Gast gast) {
        if (gaeste.size() < 100) {
            gaeste.add(gast);
            return true;
        }
        return false;
    }

    // --------------------------------------

}
