package C_BP.bp11_SQL_sub.Aufgabe_1_neu;

import java.util.List;
import java.util.Scanner;

public class ProductManager {

    public static void main (String [] args){
        ProductDAO myProductDAO = new ProductDAO();
        List<Product> allProducts = myProductDAO.getAllProducts();

        // Durchschnitt
        double average = ProductStatistics.calculateAveragePrice(allProducts);
        System.out.println("Average: " + average);

        // mostExpensiveProducts
        List<Product> mostExpensiveProducts = ProductStatistics.findMostExpensiveProducts(allProducts, 3);
        System.out.println("Expensive: " + mostExpensiveProducts);

        // Cheapest
            List<Product> cheapestProducts = ProductStatistics.findCheapestProducts(allProducts, 3);
        System.out.println("Expensive: " + cheapestProducts);


        // 6. Benutzereingabe

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter ID:");
        int id = myScanner.nextInt();

        System.out.println("Enter price: ");
        double price = myScanner.nextDouble();

        myProductDAO.updateProductPrice(id,price);

        myScanner.close();

    }



    
}
