package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.dto.VehicleRequest;
import lk.ijse.vehicleservice.dto.VehicleResponse;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:40 PM
 * Project: parking-system
 * ------------------------------------------------
 */

public interface VehicleService {
    VehicleResponse registerVehicle(VehicleRequest request);
    VehicleResponse getVehicle(Long id);
    List<VehicleResponse> getVehiclesByUserId(Long userId);
    VehicleResponse updateVehicle(Long id, VehicleRequest request);
    void deleteVehicle(Long id);
    VehicleResponse simulateEntry(Long id);
    VehicleResponse simulateExit(Long id);

    VehicleResponse getVehicleByLicensePlate(String licensePlate);
}
