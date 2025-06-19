package lk.ijse.parkingservice.repo;

import lk.ijse.parkingservice.entity.ParkingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRecordRepository extends JpaRepository<ParkingRecord, Long> {
}