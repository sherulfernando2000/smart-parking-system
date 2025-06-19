package lk.ijse.parkingservice.service;

import lk.ijse.parkingservice.entity.ParkingRecord;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/19/2025 10:48 AM
 * Project: parking-system
 * ------------------------------------------------
 */
public interface ParkingRecordService {
    public ParkingRecord startParking(String licensePlate, Long spaceId);

    public ParkingRecord endParking(Long recordId);
}
