package Day7.payments;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Wallet");

        int choice = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        Payment payment;

        switch (choice) {
            case 1:
                payment = new UPI(amount);
                break;
            case 2:
                payment = new Card(amount);
                break;
            case 3:
                payment = new Wallet(amount);
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        payment.processPayment(); // polymorphism

        sc.close();
    }
}