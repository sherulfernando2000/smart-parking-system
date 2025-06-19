package lk.ijse.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse {
    private String receiptNumber;
    private double amount;
    private LocalDateTime paidAt;
    private String status;
}