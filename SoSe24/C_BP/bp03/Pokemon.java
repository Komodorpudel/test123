package bp03;

/**
 * Repräsentiert ein Pokémon.
 */
public class Pokemon {
    
    /**
     * Die Pokédex-Nummer.
     */
    final int number;
    
    /**
     * Der Name.
     */
    final String name;
    
    /**
     * Der erste Typ.
     */
    final String type1;
    
    /**
     * Der zweite Typ. {@code null}, falls das Pokemon nur einen Typ hat.
     */
    final String type2;
    
    /**
     * Die Summe der Statuswerte
     */
    final int total;
    
    /**
     * Die Basis-Kraftpunkte
     */
    final int hp;
    
    /**
     * Der Basis-Angriff
     */
    final int attack;
    
    /**
     * Die Basis-Verteidigung
     */
    final int defence;
    
    /**
     * Der Basis-Spezialangriff
     */
    final int specialAttack;
    
    /**
     * Die Basis-Spezialverteidigung
     */
    final int specialDefence;
    
    /**
     * Die Basis-Initiative.
     */
    final int speed;
    
    /**
     * {@code true}, falls dies ein legendäres Pokémon ist, sonst {@code false}
     */
    final boolean legendary;

    
    /**
     * Erzeugt ein neues Pokémon.
     */
    Pokemon(int number, String name, String type1, String type2, int total, int hp, int attack,
            int defence, int specialAttack, int specialDefence, int speed, boolean legendary) {
        
        this.number = number;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.specialAttack = specialAttack;
        this.specialDefence = specialDefence;
        this.speed = speed;
        this.legendary = legendary;
        
    }
    
    
    @Override
    public String toString() {
        
        // Ein Pokemon-Objekt wird als String durch seinen Namen repräsentiert.
        return this.name;
        
    }

}
