package lk.ijse.paymentservice.service;

import lk.ijse.paymentservice.dto.PaymentRequest;
import lk.ijse.paymentservice.dto.PaymentResponse;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/19/2025 3:58 PM
 * Project: parking-system
 * ------------------------------------------------
 */
public interface PaymentService {
    public PaymentResponse processPayment(PaymentRequest request);

    List<PaymentResponse> getAllPayments();
}
