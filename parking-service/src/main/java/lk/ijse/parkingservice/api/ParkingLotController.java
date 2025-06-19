package lk.ijse.parkingservice.api;

import lk.ijse.parkingservice.dto.ParkingLotRequest;
import lk.ijse.parkingservice.entity.ParkingLot;
import lk.ijse.parkingservice.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //update
    //delete
    @PutMapping("update/{id}")
    public ResponseEntity<ParkingLot> updateLot(@PathVariable Long id, @RequestBody ParkingLotRequest request) {
        return ResponseEntity.ok(lotService.updateParkingLot(id, request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteLot(@PathVariable Long id) {
        lotService.deleteParkingLot(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/get")
    public List<ParkingLot> getAll() {
        return lotService.getAllLots();
    }
}