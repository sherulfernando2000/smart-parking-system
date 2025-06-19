package lk.ijse.parkingservice.service.impl;

import lk.ijse.parkingservice.entity.ParkingRecord;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.entity.ParkingStatus;
import lk.ijse.parkingservice.repo.ParkingRecordRepository;
import lk.ijse.parkingservice.repo.ParkingSpaceRepository;
import lk.ijse.parkingservice.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ParkingRecordServiceImpl implements ParkingRecordService {

    @Autowired
    private ParkingRecordRepository recordRepo;

    @Autowired
    private ParkingSpaceRepository spaceRepo;

    public ParkingRecord startParking(String licensePlate, Long spaceId) {
        ParkingSpace space = spaceRepo.findById(spaceId).orElseThrow();
        space.setStatus(ParkingStatus.OCCUPIED);
        spaceRepo.save(space);

        ParkingRecord record = ParkingRecord.builder()
                .licensePlate(licensePlate)
                .entryTime(LocalDateTime.now())
                .parkingSpace(space)
                .build();

        return recordRepo.save(record);
    }

    public ParkingRecord endParking(Long recordId) {
        ParkingRecord record = recordRepo.findById(recordId).orElseThrow();
        record.setExitTime(LocalDateTime.now());

        long duration = Duration.between(record.getEntryTime(), record.getExitTime()).toMinutes();
        record.setDurationMinutes(duration);

        ParkingSpace space = record.getParkingSpace();
        space.setStatus(ParkingStatus.AVAILABLE);
        spaceRepo.save(space);

        return recordRepo.save(record);
    }
}
