import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " | " + category + " | Price: " + price;
    }
}

public class ProductStreams {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 800, "Electronics"),
            new Product("Phone", 500, "Electronics"),
            new Product("Shirt", 40, "Clothing"),
            new Product("Jeans", 60, "Clothing")
        );

        // Group by category
        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Grouped by Category: " + grouped);

        // Most expensive product in each category
        Map<String, Optional<Product>> maxPrice = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));
        System.out.println("\nMost Expensive in Each Category:");
        maxPrice.forEach((cat, prod) -> System.out.println(cat + ": " + prod.get()));

        // Average price of all products
        double avgPrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of Products: " + avgPrice);
    }
}
