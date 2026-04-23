package Day7.payments;

public class Wallet extends Payment {

    public Wallet(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Wallet payment of " + amount);
    }
}