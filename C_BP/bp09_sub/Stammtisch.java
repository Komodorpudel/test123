package C_BP.bp09_sub;

import java.util.ArrayList;
import java.util.List;

public class Stammtisch {

    private List<Gast> gaeste;

    ////////////////////////////////////////////////////////////

    public Stammtisch(List<Gast> gaeste) {
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

    public List<Gast> getGaeste() {
        return gaeste;
    }

}
