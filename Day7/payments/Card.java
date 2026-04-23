package Day7.payments;

public class Card extends Payment {

    public Card(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Card payment of " + amount);
    }
}