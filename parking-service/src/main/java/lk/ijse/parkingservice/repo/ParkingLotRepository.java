package lk.ijse.parkingservice.repo;

import lk.ijse.parkingservice.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/18/2025 10:18 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

}
