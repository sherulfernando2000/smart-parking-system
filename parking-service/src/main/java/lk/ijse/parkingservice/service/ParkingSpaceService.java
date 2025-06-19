package lk.ijse.parkingservice.service;

import lk.ijse.parkingservice.dto.ParkingSpaceRequest;
import lk.ijse.parkingservice.dto.ParkingSpaceStatusUpdateRequest;
import lk.ijse.parkingservice.entity.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {
    List<ParkingSpace> getSpacesByLot(Long lotId);
    ParkingSpace createSpace(ParkingSpaceRequest request);
    ParkingSpace updateStatus(Long id, ParkingSpaceStatusUpdateRequest status);

    void deleteSpace(Long id);
}