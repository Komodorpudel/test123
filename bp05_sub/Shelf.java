package bp05_sub;


// Necessary packages/shelfs:
import java.util.ArrayList;
import java.util.List;
//

// Definition der Klasse Shelf (T könnte ein beliebiger Buchstabe sein, T ist subclass of Product)
// "Shelf <Smartphone>"" wurde nur Smartphones erlauben
class Shelf<T extends Product> {

    // --------------------------------------

    // Attribute
    // Definition einer generischen Liste namens products, um die Produkte zu speichern
    private final List<T> products = new ArrayList<>();

    // --------------------------------------

    // Methode, um ein Produkt zur Liste hinzuzufügen und seine Details auszugeben
    // Call "addProduct("blabla")" würde in einem compile-time error resultieren"
    public void addProduct(T product) {

        // Produkt zur Liste hinzufügen
        products.add(product);

        // Ausgabe
        System.out.println("Produkt hinzugefügt: " + product.getName() + ", ID: " + product.getProductID());  // Gibt die Details des Produkts aus
    }

    // --------------------------------------

    // Methode, um zu überprüfen, ob ein Produkt eines bestimmten Typs in der Liste vorhanden ist
    //      "Class<? extends T> productType" means that the productType parameter is a
    //       Class object that represents a class or interface that is a subtype of T.
    // Giving "duck" as productType would give compile-time error
    public boolean containsProductOfType(Class<? extends T> productType) throws EmptyShelfException {

        // Überprüft, ob die Liste leer ist
        if (products.isEmpty()) {  
            // Wenn die Liste leer ist, wird eine EmptyShelfException ausgelöst
            throw new EmptyShelfException("Das Regal ist leer!");
        }

        // Durchläuft die Liste und überprüft, ob ein Produkt des angegebenen Typs vorhanden ist
        for (T product : products) {
            // Überprüft ob product eine Class Instance von productType ist
            if (productType.isInstance(product)) {

                //Return
                return true;  // Gibt true zurück, wenn ein passendes Produkt gefunden wird
            }
        }

        // Return
        return false;  // Gibt false zurück, wenn kein passendes Produkt gefunden wird
    }

    // --------------------------------------

    // Methode zum entfernen eines Produktes einer bestimmten Kategorie
    public T takeProductFromShelf(Class<? extends T> productType) throws EmptyShelfException {

        // Prüfen ob Liste leer ist
        if (products.isEmpty()) {
            // Wenn die Liste leer ist, wird eine EmptyShelfException ausgelöst
            throw new EmptyShelfException("Das Regal ist leer!");
        }

        // Durch Liste loopen
        for (T product : products) {

            // Prüfen ob product eine Instance of productType ist
            if (productType.isInstance(product)) {

                // Entfernen
                products.remove(product);

                // Ausgabe
                System.out.println("Took product from shelf with ID: " + product.getProductID() + " and category: " + product.getClass().getSimpleName());
                
                // Return
                return product;
            }
        }
    
        // Ausgabe
        System.out.println("No product of type: " + productType.getSimpleName() + " is available on the shelf.");
        
        // Return
        return null;
    }

    // --------------------------------------
    
}
