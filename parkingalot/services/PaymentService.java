package parkingalot.services;

import java.util.UUID;
import parkingalot.models.*;
import parkingalot.enums.*;;

public class PaymentService {

    public Payment processPayment(double amount, PaymentMethod method) {

        String transactionId = UUID.randomUUID().toString();

        return new Payment(amount,method,PaymentStatus.SUCCESS,transactionId);
    }
}