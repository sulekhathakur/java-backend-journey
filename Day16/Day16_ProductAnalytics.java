package Day16;

import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    double price;
    double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " | ₹" + price + " | Rating: " + rating;
    }
}

public class Day16_ProductAnalytics {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 70000, 4.5));
        products.add(new Product("Phone", 30000, 4.2));
        products.add(new Product("Tablet", 20000, 4.0));
        products.add(new Product("Headphones", 2000, 4.8));

        // Sorting using Comparator (by price)
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));

        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);

        // Stream API: filter high-rated products
        System.out.println("\nHigh Rated Products (rating > 4.2):");

        List<Product> filtered = products.stream()
                .filter(p -> p.rating > 4.2)
                .collect(Collectors.toList());

        filtered.forEach(p -> System.out.println(p));

        // Stream API: average price
        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0);

        System.out.println("\nAverage Price: ₹" + avgPrice);
    }
}