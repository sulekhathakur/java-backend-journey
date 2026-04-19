package Day3;

import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    void display() {
        System.out.println("Category: " + category + " | Amount: " + amount);
    }
}

public class Day03_ExpenseTracker {
    static Expense[] expenses = new Expense[100];
    static int count = 0;

    // Add expense
    public static void addExpense(String category, double amount) {
        expenses[count] = new Expense(category, amount);
        count++;
        System.out.println("Expense Added!");
    }

    // Overloaded method (quick add)
    public static void addExpense(double amount) {
        addExpense("Misc", amount);
    }

    // View all expenses
    public static void viewExpenses() {
        if (count == 0) {
            System.out.println("No expenses found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            expenses[i].display();
        }
    }

    // Total expense
    public static void totalExpense() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += expenses[i].amount;
        }
        System.out.println("Total Expense: " + total);
    }

    // Filter by category
    public static void filterCategory(String cat) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (expenses[i].category.equalsIgnoreCase(cat)) {
                expenses[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found for category: " + cat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Filter by Category");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    addExpense(category, amount);
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalExpense();
                    break;

                case 4:
                    System.out.print("Enter Category to Filter: ");
                    String cat = sc.nextLine();
                    filterCategory(cat);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}