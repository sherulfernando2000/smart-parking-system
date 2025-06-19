package lk.ijse.parkingservice.api;

import lk.ijse.parkingservice.dto.ParkingSpaceRequest;
import lk.ijse.parkingservice.dto.ParkingSpaceStatusUpdateRequest;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parking-service/spaces")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    // Get spaces by lot ID
    @GetMapping("get/lot/{lotId}")
    public ResponseEntity<List<ParkingSpace>> getSpacesByLot(@PathVariable Long lotId) {
        List<ParkingSpace> spaces = parkingSpaceService.getSpacesByLot(lotId);
        return ResponseEntity.ok(spaces);
    }

    // Create a new space under a lot
    @PostMapping("save")
    public ResponseEntity<ParkingSpace> createSpace(@RequestBody ParkingSpaceRequest request) {
        ParkingSpace newSpace = parkingSpaceService.createSpace(request);
        return ResponseEntity.status(201).body(newSpace);
    }

    // Update parking space status
    @PutMapping("update/{id}")
    public ResponseEntity<ParkingSpace> updateStatus(@PathVariable Long id, @RequestBody ParkingSpaceStatusUpdateRequest status) {
        ParkingSpace updated = parkingSpaceService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    // Delete a parking space
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteSpace(@PathVariable Long id) {
        parkingSpaceService.deleteSpace(id);
        return ResponseEntity.noContent().build();
    }
}