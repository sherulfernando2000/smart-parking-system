package lk.ijse.vehicleservice.service.impl;

import lk.ijse.vehicleservice.client.UserClient;
import lk.ijse.vehicleservice.dto.VehicleRequest;
import lk.ijse.vehicleservice.dto.VehicleResponse;
import lk.ijse.vehicleservice.entity.Vehicle;
import lk.ijse.vehicleservice.repo.VehicleRepository;
import lk.ijse.vehicleservice.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:42 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserClient userClient;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleResponse registerVehicle(VehicleRequest request) {
        if (!userClient.isUserExists(Long.valueOf(request.getUserId()))) {
            throw new RuntimeException("User ID " + request.getUserId() + " not found");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlate(request.getLicensePlate());
        vehicle.setType(request.getType());

        vehicle.setUserId(Long.valueOf(request.getUserId()));

        Vehicle saved = vehicleRepository.save(vehicle);
        return modelMapper.map(saved,VehicleResponse.class);// Convert VehicleRequest to Vehicle entity

    }

    @Override
    public VehicleResponse getVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        return modelMapper.map(vehicle,VehicleResponse.class);
    }

    @Override
    public List<VehicleResponse> getVehiclesByUserId(Long userId) {
        return vehicleRepository.findByUserId(userId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse updateVehicle(Long id, VehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (!userClient.isUserExists(Long.valueOf(request.getUserId()))) {
            throw new RuntimeException("User ID " + request.getUserId() + " not found");
        }

        vehicle.setLicensePlate(request.getLicensePlate());
        vehicle.setType(request.getType());
        vehicle.setUserId(Long.valueOf(request.getUserId()));

        return mapToResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public VehicleResponse simulateEntry(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setEntryTime(LocalDateTime.now());
        vehicle.setExitTime(null);
        return mapToResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleResponse simulateExit(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setExitTime(LocalDateTime.now());
        return mapToResponse(vehicleRepository.save(vehicle));
    }

    private VehicleResponse mapToResponse(Vehicle vehicle) {
        VehicleResponse response = new VehicleResponse();
        response.setId(vehicle.getId());
        response.setLicensePlate(vehicle.getLicensePlate());
        response.setType(vehicle.getType());
        response.setUserId(vehicle.getUserId());
        return response;
    }
}
