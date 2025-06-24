package lk.ijse.parkingservice.api;

import lk.ijse.parkingservice.entity.ParkingRecord;
import lk.ijse.parkingservice.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parking-service/api/v1/parking-records")
public class ParkingRecordController {

    @Autowired
    private ParkingRecordService recordService;

    @PostMapping("/start")
    public ResponseEntity<ParkingRecord> start(@RequestParam String licensePlate, @RequestParam Long spaceId) {
        return ResponseEntity.ok(recordService.startParking(licensePlate, spaceId));
    }

    @PutMapping("/end/{id}")
    public ResponseEntity<ParkingRecord> end(@PathVariable Long id) {
        return ResponseEntity.ok(recordService.endParking(id));
    }
}
