package AdapterPatternExample;

public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of the payment gateways
        PayPalPaymentGateway payPal = new PayPalPaymentGateway();
        StripePaymentGateway stripe = new StripePaymentGateway();

        // Create adapters for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);

        // Process payments using the adapters
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
    }
}
