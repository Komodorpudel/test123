package C_BP.bp09_sub;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    // --------------------------------------

    private String kategorie;
    private String name;
    private List<Stammtisch> stammtische = new ArrayList<>();
    private List<Gast> gaeste = new ArrayList<>();

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
