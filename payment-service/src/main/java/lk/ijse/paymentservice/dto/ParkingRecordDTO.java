package lk.ijse.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingRecordDTO {
    private Long id;
    private Long vehicleId;
    private Long parkingSpaceId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}
