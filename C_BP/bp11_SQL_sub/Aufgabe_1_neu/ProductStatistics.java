package SoSe23.C_BP.bp11_SQL_sub.Aufgabe_1_neu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductStatistics {

    public static double calculateAveragePrice(List<Product> products) {

        ArrayList<Product> allProducts = new ArrayList<>();

        allProducts.addAll(products);

        return allProducts.stream()
                            .mapToDouble(p -> p.getPrice())
                            .average()
                            .orElse(0);
    }

    public static List<Product> findMostExpensiveProducts(List<Product> products, int count) {

        return products.stream()
                        .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                        .limit(count)
                        .toList();
    }

    public static List<Product> findCheapestProducts(List<Product> products, int count) {
        return products.stream()
                .sorted(Comparator.comparingDouble(p -> p.getPrice()))
                .limit(count)
                .toList();
    }
    
}
