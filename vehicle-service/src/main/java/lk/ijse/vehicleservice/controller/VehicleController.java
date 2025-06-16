package lk.ijse.vehicleservice.controller;

import lk.ijse.vehicleservice.dto.VehicleRequest;
import lk.ijse.vehicleservice.dto.VehicleResponse;
import lk.ijse.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:55 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@RestController
@RequestMapping("vehicle-service/api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;



    @PostMapping("/save")
    public ResponseEntity<VehicleResponse> register(@RequestBody VehicleRequest request) {
        System.out.println("save");
        return new ResponseEntity<>(vehicleService.registerVehicle(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> getVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable Long id, @RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<VehicleResponse>> getVehiclesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByUserId(userId));
    }

//    @PostMapping("/{id}/entry")
//    public ResponseEntity<VehicleResponse> simulateEntry(@PathVariable Long id) {
//        return ResponseEntity.ok(vehicleService.simulateEntry(id));
//    }

//    @PostMapping("/{id}/exit")
//    public ResponseEntity<VehicleResponse> simulateExit(@PathVariable Long id) {
//        return ResponseEntity.ok(vehicleService.simulateExit(id));
//    }

    @GetMapping
    public String get(){
        return "Vehicle Service is running";
    }

}
