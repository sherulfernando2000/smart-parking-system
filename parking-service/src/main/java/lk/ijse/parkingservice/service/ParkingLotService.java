package lk.ijse.parkingservice.service;

import lk.ijse.parkingservice.dto.ParkingLotRequest;
import lk.ijse.parkingservice.entity.ParkingLot;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/18/2025 10:21 AM
 * Project: parking-system
 * ------------------------------------------------
 */
public interface ParkingLotService {
    ParkingLot createLot(ParkingLotRequest request);

    List<ParkingLot> getAllLots();
}
