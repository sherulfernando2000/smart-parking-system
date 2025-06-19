package lk.ijse.paymentservice.service.impl;

import lk.ijse.paymentservice.client.UserClient;
import lk.ijse.paymentservice.dto.ParkingRecordDTO;
import lk.ijse.paymentservice.dto.PaymentRequest;
import lk.ijse.paymentservice.dto.PaymentResponse;
import lk.ijse.paymentservice.entity.Payment;
import lk.ijse.paymentservice.entity.PaymentStatus;
import lk.ijse.paymentservice.repo.PaymentRepository;
import lk.ijse.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/19/2025 3:58 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private UserClient userClient;

    public PaymentResponse processPayment(PaymentRequest request) {
        ParkingRecordDTO record = userClient.getParkingRecordById(request.getParkingRecordId());

        if (record.getExitTime() == null)
            throw new RuntimeException("Vehicle has not exited yet.");

        // Calculate hours and fee
        Duration duration = Duration.between(record.getEntryTime(), record.getExitTime());
        long hours = Math.max(1, duration.toHours()); // Minimum 1 hour
        double amount = hours * 100.0; // Example: Rs.100 per hour

        // Simulate card validation (mock)
        if (!request.getCardNumber().startsWith("4")) {
            throw new RuntimeException("Card Declined (mock check)");
        }

        // Save payment
        Payment payment = new Payment();
        payment.setVehicleId(record.getVehicleId());
        payment.setParkingRecordId(record.getId());
        payment.setAmount(amount);
        payment.setPaidAt(LocalDateTime.now());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setReceiptNumber(UUID.randomUUID().toString());

        paymentRepo.save(payment);

        return new PaymentResponse(
                payment.getReceiptNumber(), amount, payment.getPaidAt(), payment.getStatus().toString()
        );
    }
}
