package Day17;

import java.util.*;
import java.util.stream.*;

class Sale {
    String product;
    double amount;

    public Sale(String product, double amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return product + " | ₹" + amount;
    }
}

public class Day17_SalesAnalytics {

    public static void main(String[] args) {

        List<Sale> sales = Arrays.asList(
                new Sale("Laptop", 70000),
                new Sale("Phone", 30000),
                new Sale("Tablet", 20000),
                new Sale("Headphones", 2000),
                new Sale("Laptop", 80000)
        );

        // Filter: high-value sales
        List<Sale> highSales = sales.stream()
                .filter(s -> s.amount > 25000)
                .collect(Collectors.toList());

        System.out.println("High Value Sales:");
        highSales.forEach(System.out::println);

        // Map: extract amounts
        List<Double> amounts = sales.stream()
                .map(s -> s.amount)
                .collect(Collectors.toList());

        System.out.println("\nAll Amounts:");
        amounts.forEach(System.out::println);

        // Reduce: total revenue
        double totalRevenue = sales.stream()
                .map(s -> s.amount)
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("\nTotal Revenue: ₹" + totalRevenue);

        // Sorted
        System.out.println("\nSorted Sales:");
        sales.stream()
                .sorted((s1, s2) -> Double.compare(s2.amount, s1.amount))
                .forEach(System.out::println);
    }
}