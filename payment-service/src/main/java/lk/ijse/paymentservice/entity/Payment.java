package lk.ijse.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicleId;
    private Long parkingRecordId;
    private LocalDateTime paidAt;

    private double amount;
    private String paymentMethod; // e.g., CARD, CASH, etc.
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // SUCCESS, FAILED

    private String receiptNumber;
}
