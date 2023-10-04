package C_BP.bp09_sub;

import java.util.ArrayList;

public class Stammtisch {

    private ArrayList<Gast> gaeste;

    ////////////////////////////////////////////////////////////

    public Stammtisch(ArrayList<Gast> gaeste) {
        if (gaeste.size() >= 3) {
            this.gaeste = gaeste;
        } else {
            throw new IllegalArgumentException("Mindestens 3 Gäste erforderlich.");
        }
    }

    // Methoden zum Hinzufügen von Gästen
    public void addGast(Gast gast) {
        gaeste.add(gast);
    }

    public ArrayList<Gast> getGaeste() {
        return gaeste;
    }

}
