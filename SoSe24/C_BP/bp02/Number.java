package SoSe24.C_BP.bp02;

/**
 * Repräsentiert eine Zahl.
 */
public abstract class Number {

    // Da diese Methoden abstrakt sind, benötigen Sie keine Implementierung.
    
    /**
     * Gibt zurück, ob diese Zahl null ist.
     * 
     * @return <code>true</code>, falls diese Zahl null ist; andernfalls
     *         <code>false</code>
     */
    public abstract boolean isZero();
    
    /**
     * Gibt zurück, ob diese Zahl positive ist.
     * 
     * @return <code>true</code>, falls diese Zahl positiv ist; andernfalls
     *         <code>false</code>
     */
    public abstract boolean isPositive();
    
}
