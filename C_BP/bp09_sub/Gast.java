package C_BP.bp09_sub;

import java.util.ArrayList;
import java.util.List;

public class Gast {

    // --------------------------------------

    public static String status = "König";
    private List<Bestellung> bestellungen = new ArrayList<>();
    private List<Stammtisch> stammtische = new ArrayList<>();

    // --------------------------------------

    public void linkBestellung(Bestellung bestellung) {
        bestellungen.add(bestellung);
    }

    public void unlinkBestellung(Bestellung bestellung) {
        bestellungen.remove(bestellung);
    }

    public List<Bestellung> getLinkedBestellungen() {
        return bestellungen;
    }

    public Bestellung getBestellung(int index) {
        return bestellungen.get(index);
    }
    
    public void linkStammtisch(Stammtisch stammtisch) {
        stammtische.add(stammtisch);
    }

    public void unlinkStammtisch(Stammtisch stammtisch) {
        stammtische.remove(stammtisch);
    }

    public List<Stammtisch> getLinkedStammtische() {
        return stammtische;
    }

    public Stammtisch getStammtisch(int index) {
        return stammtische.get(index);
    }

    // --------------------------------------
    
}
