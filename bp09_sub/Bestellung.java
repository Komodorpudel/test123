package bp09_sub;

public class Bestellung implements Rechnung {

    private boolean isPrepared;
    private Gast gast;

    public Bestellung(Gast gast) {
        this.gast = gast;
        this.isPrepared = false;
    }

    public boolean getIsPrepared() {
        return isPrepared;
    }

    public void setIsPrepared(boolean isPrepared) {
        this.isPrepared = isPrepared;
    }

    ////////////////////////////////////////////////////////

    public Gast getGast() {
        return gast;
    }

    public void setGast(Gast gast) {
        this.gast = gast;
    }
}
