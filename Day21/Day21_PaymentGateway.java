package Day21;

import java.util.*;

// Sealed class
sealed abstract class Payment permits CardPayment, UpiPayment {
    abstract void pay(double amount);
}

// Subclasses
final class CardPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}

final class UpiPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// Record class with canonical constructor
record Transaction(String id, double amount) {

    public Transaction {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}

public class Day21_PaymentGateway {

    public static void main(String[] args) {

        // Local Variable Type Inference
        var transactions = new ArrayList<Transaction>();

        transactions.add(new Transaction("TXN101", 5000));
        transactions.add(new Transaction("TXN102", 2500));

        System.out.println("Transactions:");

        transactions.forEach(System.out::println);

        Payment payment1 = new CardPayment();
        Payment payment2 = new UpiPayment();

        payment1.pay(5000);
        payment2.pay(2500);
    }
}