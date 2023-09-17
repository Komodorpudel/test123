package C_BP.bp05_sub;

// Necessary packages/classes (SAH: Add HashSet):
import java.util.HashSet;
//

// Abstract class als fundament um subclassen zu erstelle
abstract class Product {

    // --------------------------------------

    // Attribute
    // private: Can only be modified inside this class
    // final: cannot be changed after assigned
    private final String name;
    private final int productID;

    // Definition der statischen Variable usedIds, um die bereits verwendeten IDs zu speichern
    private static final HashSet<Integer> usedIds = new HashSet<>();
    // Anmerkung: HashSet effizienter als ArrayList, für diese aufgabe aber overblown
    // private static final List<Integer> usedIds = new ArrayList<>();

    // --------------------------------------

    // Konstruktor wird verwendet um Subclasses zu erstellen (Vermeidung duplicate code etc.) (SAH: throws ... hinzugefügt)
    public Product(String name, int productID) throws IdAlreadyUsedException {

        // SAH: Überprüfen, ob die ID bereits verwendet wurde
        if (usedIds.contains(productID)) {  
            // SAH: Wenn die ID bereits verwendet wurde, wird eine IdAlreadyUsedException ausgelöst
            throw new IdAlreadyUsedException(name + " kann nicht angelegt werden, da die angegebene ID bereits verwendet wird!");
            // HashSet erlaubt keine Duplicate aber droppet einfach entry, daher exception still useful
        }

        // Sämtlicher code nach throw wird nichtmehr ausgeführt falls throw geworfen wird

        // SAH: Wenn die ID noch nicht verwendet wurde, wird sie der Liste der verwendeten IDs hinzugefügt
        usedIds.add(productID);

        // Set Attribute
        this.name = name;
        this.productID = productID;
    }

    // --------------------------------------

    // getName
    public String getName() {
        return name;
    }

    // --------------------------------------

    // get ProductID
    public int getProductID()
    {
        return this.productID;
    }

    // --------------------------------------

}
