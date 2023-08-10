package bp05_sub;

public class Main {

    // --------------------------------------

    public static void main(String[] args) {

        // SAH: Erstelle neue Instanz von Shelf mit name "productShelf", anfänglich leer
        Shelf<Product> productShelf = new Shelf<>();
        try {
            // SAH: Erstellt neue Instanz von Klasse Smartphone und fügt Apple iPhone 12 hinzu mit ID 0 dem productShelf hinzu
            productShelf.addProduct(new Smartphone("Apple", 0, "iPhone 12"));
        }
        // SAH: Fehlermeldung abfangen
        catch (IdAlreadyUsedException e) {
            // SAH: Falls Fehlermeldung, dann ausgeben
            System.err.println(e.getMessage());
        }

        try {
            // SAH: Prüfen ob productShelf ein Product der classe Smartphone enthält
            if (productShelf.containsProductOfType(Smartphone.class))
            {
                // SAH: Text ausgeben und Produkt von shelf entfernen
                System.out.println("Mindesten ein Smartphone vorhanden!");
                productShelf.takeProductFromShelf(Smartphone.class);
            }
        } catch (EmptyShelfException e) {
            System.err.println(e.getMessage());
        }

        try {
            // SAH: Probieren ob Shelf irgendein Produkt der Klasse Laptop enthält
            if (productShelf.containsProductOfType(Laptop.class))
                System.out.println("Mindesten ein Laptop vorhanden!");
        } catch (EmptyShelfException e) {
            // SAH: Fehlermeldung drucken wenn Shelf leer ist
            System.err.println(e.getMessage());
            try {
                // SAH: Versuche neues Produkt zu erstellen und hinzuzufügen
                productShelf.addProduct(new Laptop("Lenovo", 0, "ThinkPad X1"));
            } catch (IdAlreadyUsedException ex) {
                // SAH: Print Fehlermeldung falls vorhanden
                System.err.println(ex.getMessage());
            }
        }
    }

    // --------------------------------------

}