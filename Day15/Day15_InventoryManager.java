package Day15;

import java.util.*;

// Shared Inventory Resource
class Inventory {

    private Map<String, Integer> stock = new HashMap<>();

    // synchronized method to avoid race condition
    public synchronized void updateStock(String item, int quantity) {
        int current = stock.getOrDefault(item, 0);
        stock.put(item, current + quantity);
        System.out.println(Thread.currentThread().getName() +
                " updated " + item + " to " + stock.get(item));
    }

    public void displayStock() {
        System.out.println("\nFinal Inventory:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

// Runnable task
class InventoryTask implements Runnable {

    private Inventory inventory;
    private String item;
    private int quantity;

    public InventoryTask(Inventory inventory, String item, int quantity) {
        this.inventory = inventory;
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        inventory.updateStock(item, quantity);
    }
}

public class Day15_InventoryManager {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // ArrayList (items)
        List<String> items = new ArrayList<>();
        items.add("Laptop");
        items.add("Phone");
        items.add("Tablet");

        // Set (unique categories)
        Set<String> categories = new HashSet<>();
        categories.add("Electronics");
        categories.add("Electronics"); // duplicate ignored

        System.out.println("Items: " + items);
        System.out.println("Categories: " + categories);

        // Threads simulating concurrent updates
        Thread t1 = new Thread(new InventoryTask(inventory, "Laptop", 10));
        Thread t2 = new Thread(new InventoryTask(inventory, "Laptop", -2));
        Thread t3 = new Thread(new InventoryTask(inventory, "Phone", 5));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        inventory.displayStock();
    }
}