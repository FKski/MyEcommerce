package pl.kamski.Sales;

public class PaymentData {
    public PaymentData(String paymentUrl, String paymentId) {
        this.paymentUrl = paymentUrl;
        this.paymentId = paymentId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public String getPaymentId() {
        return paymentId;
    }

    String paymentUrl;
    String paymentId;


}
