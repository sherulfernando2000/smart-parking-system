package lk.ijse.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentRequest {
    private Long parkingRecordId;
    private String cardNumber;
    private String cardHolder;
    private String paymentMethod;
}