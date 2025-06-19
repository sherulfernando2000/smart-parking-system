package lk.ijse.parkingservice.api;

import lk.ijse.parkingservice.dto.ParkingLotRequest;
import lk.ijse.parkingservice.entity.ParkingLot;
import lk.ijse.parkingservice.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parking-service/api/v1/lots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService lotService;

    @PostMapping("/save")
    public ParkingLot create(@RequestBody ParkingLotRequest request) {
        return lotService.createLot(request);
    }

    @GetMapping("/get")
    public List<ParkingLot> getAll() {
        return lotService.getAllLots();
    }
}