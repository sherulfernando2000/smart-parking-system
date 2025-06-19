package lk.ijse.parkingservice.repo;

import jakarta.transaction.Transactional;
import lk.ijse.parkingservice.entity.ParkingLot;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.entity.ParkingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/18/2025 10:19 AM
 * Project: parking-system
 * ------------------------------------------------
 */
@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByParkingLotId(Long lotId);

    @Modifying
    @Transactional
    @Query("UPDATE ParkingSpace ps SET ps.status = :status WHERE ps.spaceId = :spaceId AND ps.parkingLot = :parkingLot")
    int updateStatusBySpaceIdAndLot(@Param("status") ParkingStatus status,
                                    @Param("spaceId") String spaceId,
                                    @Param("parkingLot") ParkingLot parkingLot);
}

