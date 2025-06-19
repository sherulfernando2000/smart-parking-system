package lk.ijse.parkingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/18/2025 10:17 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParkingSpaceStatusUpdateRequest {
    public String status; // AVAILABLE, RESERVED, OCCUPIED, BLOCKED
    public String spaceId; // Unique identifier for the parking space
    public Long lotId; // ID of the parking lot to which this space belongs
}
