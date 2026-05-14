package parkingalot.models;

import java.util.UUID;
import parkingalot.enums.*;

public class Payment {
    private UUID id;
    private double amount;
    private PaymentMethod method;
    private PaymentStatus status;
    private String transactionId;

    public Payment(double amount, PaymentMethod method, PaymentStatus status, String transactionId) {

        this.id = UUID.randomUUID();
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.transactionId = transactionId;
    }
}