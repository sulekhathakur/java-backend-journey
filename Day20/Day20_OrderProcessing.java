package Day20;

import java.util.*;
import java.util.stream.*;

class Order {
    String name;
    double amount;

    public Order(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + " | ₹" + amount;
    }
}

public class Day20_OrderProcessing {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("Laptop", 70000),
                new Order("Phone", 30000),
                new Order("Tablet", 20000),
                new Order("Headphones", 2000),
                new Order("Monitor", 15000)
        );

        // Parallel Stream processing
        System.out.println("Processing Orders (Parallel):");
        orders.parallelStream()
                .filter(o -> o.amount > 10000)
                .map(o -> o.name.toUpperCase())
                .forEach(System.out::println); // method reference

        // Optional usage
        Optional<Order> expensiveOrder = orders.stream()
                .filter(o -> o.amount > 60000)
                .findFirst();

        System.out.println("\nExpensive Order:");
        System.out.println(expensiveOrder
                .map(Order::toString)
                .orElse("No expensive order found"));

        // Constructor reference
        List<String> names = Arrays.asList("Keyboard", "Mouse");

        List<Order> newOrders = names.stream()
                .map(name -> new Order(name, 1000)) // constructor logic
                .collect(Collectors.toList());

        System.out.println("\nNew Orders:");
        newOrders.forEach(System.out::println);
    }
}