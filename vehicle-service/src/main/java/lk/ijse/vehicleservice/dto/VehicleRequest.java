package lk.ijse.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:35 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleRequest {
    private String licensePlate;
    private String type;
    private String userId;  // must be valid on register
}