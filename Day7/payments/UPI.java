package Day7.payments;

public class UPI extends Payment {

    public UPI(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment of " + amount);
    }
}