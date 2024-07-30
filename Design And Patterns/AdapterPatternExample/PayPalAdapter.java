package AdapterPatternExample;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalPaymentGateway payPalGateway;

    public PayPalAdapter(PayPalPaymentGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

