package SoSe23.C_BP.bp11_SQL_sub.Aufgabe_1;

import java.util.List;
import java.util.Scanner;

public class ProductManager {

    public static void main(String[] args) {

        // 1. ProductDAO-Objekt erstellen
        ProductDAO productDAO = new ProductDAO();

        // 2. Alle Produkte aus der Tabelle holen
        List<Product> products = productDAO.getAllProducts();

        // 3. Durchschnittspreis ermitteln und ausgeben
        double averagePrice = ProductStatistics.calculateAveragePrice(products);
        System.out.println("Durchschnittspreis: \n" + averagePrice);
        System.out.println();

        // 4. Die drei günstigsten Produkte ermitteln und ausgeben
        List<Product> cheapestProducts = ProductStatistics.findCheapestProducts(products, 3);
        System.out.println("Drei günstigste Produkte: \n" + cheapestProducts);
        System.out.println();

        // 5. Die drei teuersten Produkte ermitteln und ausgeben
        List<Product> mostExpensiveProducts = ProductStatistics.findMostExpensiveProducts(products, 3);
        System.out.println("Drei teuerste Produkte: \n" + mostExpensiveProducts);
        System.out.println();

        // 6. Benutzereingabe für Produkt-ID und Preis
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Produkt-ID ein:");
        int productId = scanner.nextInt();
        System.out.println("Geben Sie den neuen Preis ein:");
        double newPrice = scanner.nextDouble();

        // 7. Preis des Produkts aktualisieren
        try {
            productDAO.updateProductPrice(productId, newPrice);
            System.out.println("Preis aktualisiert.\n");
        }
        catch (Exception e) {
            System.out.println("Fehler beim Aktualisieren des Preises.");
        }

        // 8. Streams schließen
        scanner.close();
    }
}
