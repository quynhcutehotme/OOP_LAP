package dip2;

public interface PaymentMethod {
    void pay(double amount);
}

class PaypalPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with PayPal");
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with credit card");
    }
}

class CashPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with cash");
    }
}


class CheckoutService {
    private final PaymentMethod paymentMethod;

    public CheckoutService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void checkout(double amount) {
        paymentMethod.pay(amount);
    }
}

class checkout {
    public static void main(String[] args) {
        CheckoutService paypalCheckout = new CheckoutService(new PaypalPayment());
        CheckoutService creditCardCheckout = new CheckoutService(new CreditCardPayment());
        CheckoutService cashCheckout = new CheckoutService(new CashPayment());

        paypalCheckout.checkout(100.0);
        creditCardCheckout.checkout(200.0);
        cashCheckout.checkout(50.0);
    }
}




