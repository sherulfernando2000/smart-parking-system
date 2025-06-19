package lk.ijse.parkingservice.service.impl;

import lk.ijse.parkingservice.dto.ParkingSpaceRequest;
import lk.ijse.parkingservice.entity.ParkingLot;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.entity.ParkingStatus;
import lk.ijse.parkingservice.repo.ParkingLotRepository;
import lk.ijse.parkingservice.repo.ParkingSpaceRepository;
import lk.ijse.parkingservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository spaceRepo;
    @Autowired
    private ParkingLotRepository lotRepo;

    public List<ParkingSpace> getSpacesByLot(Long lotId) {
        return spaceRepo.findByParkingLotId(lotId);
    }

    public ParkingSpace createSpace(ParkingSpaceRequest request) {
        ParkingLot lot = lotRepo.findById(request.lotId).orElseThrow();
        ParkingSpace space = new ParkingSpace();
        space.setParkingLot(lot);
        space.setStatus(ParkingStatus.AVAILABLE);
        return spaceRepo.save(space);
    }

    public ParkingSpace updateStatus(Long id, String status) {
        ParkingSpace space = spaceRepo.findById(status).orElseThrow();
        space.setStatus(ParkingStatus.valueOf(status));
        return spaceRepo.save(space);
    }
}