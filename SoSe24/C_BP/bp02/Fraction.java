package SoSe24.C_BP.bp02;

/**
 * Repräsentiert einen mathematischen Bruch als Zähler/Nenner.
 */
public class Fraction extends Number implements Comparable<Fraction> {

    private final IntegerNumber numerator;
    private final IntegerNumber denominator;

    // Standardkonstruktor, der den Bruch als 0/1 definiert.
    public Fraction() {
        this.numerator = new IntegerNumber(0);
        this.denominator = new IntegerNumber(1);
    }

    public Fraction(IntegerNumber numerator, IntegerNumber denominator) {
        if (denominator == null || denominator.isZero() || !denominator.isPositive()) {
            throw new IllegalArgumentException("Der Nenner darf nicht null oder negativ sein.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean isZero() {
        return numerator.isZero();
    }

    @Override
    public boolean isPositive() {
        return (numerator.isPositive() == denominator.isPositive());
    }

    @Override
    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }

    @Override
    public int compareTo(Fraction other) {
        if (this.denominator.equals(other.denominator)) {
            return this.numerator.compareTo(other.numerator);
        }
        else {
            IntegerNumber commonDenominator = this.denominator.times(other.denominator);
            IntegerNumber newNumeratorThis = this.numerator.times(other.denominator);
            IntegerNumber newNumeratorOther = other.numerator.times(this.denominator);
            
            return new Fraction(newNumeratorThis, commonDenominator).compareTo(new Fraction(newNumeratorOther, commonDenominator));
        }
    }
}