package AdapterPatternExample;

public interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of " + amount + " through PayPal.");
    }
}

class StripePaymentGateway {
    public void charge(double amount) {
        System.out.println("Processing payment of " + amount + " through Stripe.");
    }
}