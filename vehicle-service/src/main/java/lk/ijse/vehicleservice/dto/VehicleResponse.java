package lk.ijse.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:36 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponse {
    private Long id;
    private String licensePlate;
    private String type;
    private Long userId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}
