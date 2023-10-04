package C_BP.bp09_sub;

import java.util.ArrayList;

public class Bestellung implements Rechnung {

    private boolean isPrepared;
    private ArrayList <Gericht> gerichte = new ArrayList<>();

    public Bestellung(ArrayList <Gericht> gerichte) {
        this.gerichte = gerichte;
        this.isPrepared = false;
    }

    public boolean getIsPrepared() {

        gerichte.forEach(System.out::println);
        return isPrepared;
        
    }

    public void setIsPrepared(boolean isPrepared) {
        this.isPrepared = isPrepared;
    }

    ////////////////////////////////////////////////////////

/*     public Gast getGast() {
        return gast;
    }

    public void setGast(Gast gast) {
        this.gast = gast;
    } */
}
