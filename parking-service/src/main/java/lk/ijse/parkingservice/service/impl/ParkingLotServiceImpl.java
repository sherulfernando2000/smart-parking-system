package lk.ijse.parkingservice.service.impl;

import lk.ijse.parkingservice.dto.ParkingLotRequest;
import lk.ijse.parkingservice.dto.ParkingLotResponse;
import lk.ijse.parkingservice.entity.ParkingLot;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.entity.ParkingStatus;
import lk.ijse.parkingservice.repo.ParkingLotRepository;
import lk.ijse.parkingservice.repo.ParkingSpaceRepository;
import lk.ijse.parkingservice.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private  ParkingLotRepository parkingLotRepository;

    @Autowired
    private  ParkingSpaceRepository parkingSpaceRepository;

    public ParkingLot createLot(ParkingLotRequest request) {
        // Create and save the parking lot
        ParkingLot lot = new ParkingLot();
        lot.setName(request.getName());
        lot.setLocation(request.getLocation());
        ParkingLot savedLot = parkingLotRepository.save(lot);

        //Create parking spaces auto
        List<ParkingSpace> spaces = new ArrayList<>();
        for (int i = 1; i <= request.getTotalSpaces(); i++) {
            ParkingSpace space = new ParkingSpace();
            space.setParkingLot(savedLot);
            space.setStatus(ParkingStatus.AVAILABLE);
            space.setSpaceId("P" + i); // Example: P1, P2, ...
            spaces.add(space);
        }

        //  Save all parking spaces
        parkingSpaceRepository.saveAll(spaces);

        return new ParkingLot(savedLot.getId(), savedLot.getName(), savedLot.getLocation(),spaces);
    }

    public List<ParkingLot> getAllLots() {
        return parkingLotRepository.findAll();
    }
}
