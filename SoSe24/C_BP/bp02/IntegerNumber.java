package SoSe24.C_BP.bp02;

/**
 * Repräsentiert eine ganze Zahl.
 */
public class IntegerNumber extends Number implements Comparable<IntegerNumber>{
    
    // Das interne Feld für den Wert der Zahl, der nicht verändert werden kann
    private final int value;

    /**
     * Standardkonstruktor, der ein IntegerNumber-Objekt mit dem Wert 0 erstellt.
     */
    public IntegerNumber() {
        this.value = 0;
    }

      public IntegerNumber(int value) {
        this.value = value;
    }

    @Override
    public boolean isZero() {
        return this.value == 0;
    }

    @Override
    public boolean isPositive() {
        return this.value > 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int compareTo(IntegerNumber other) {
        return Integer.compare(this.value, other.value);
    }

    public IntegerNumber times(IntegerNumber factor) {
        return new IntegerNumber(this.value * factor.value);
    }
}
