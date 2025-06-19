package lk.ijse.parkingservice.api;

import lk.ijse.parkingservice.dto.ParkingSpaceRequest;
import lk.ijse.parkingservice.dto.ParkingSpaceStatusUpdateRequest;
import lk.ijse.parkingservice.entity.ParkingSpace;
import lk.ijse.parkingservice.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parking-service/spaces")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService spaceService;

    @GetMapping("/lot/{lotId}")
    public List<ParkingSpace> getByLot(@PathVariable Long lotId) {
        return spaceService.getSpacesByLot(lotId);
    }

    @PostMapping("/reserve")
    public ParkingSpace create(@RequestBody ParkingSpaceRequest request) {
        return spaceService.createSpace(request);
    }

    @PutMapping("/status/{id}")
    public ParkingSpace updateStatus(@PathVariable Long id, @RequestBody ParkingSpaceStatusUpdateRequest request) {
        return spaceService.updateStatus(id, request.status);
    }
}