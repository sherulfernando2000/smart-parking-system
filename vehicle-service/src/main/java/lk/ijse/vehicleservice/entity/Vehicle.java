package lk.ijse.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ------------------------------------------------
 * Author: Sherul Fdo
 * GitHub: https://github.com/sherulfernando2000
 * Created: 6/16/2025 4:19 PM
 * Project: parking-system
 * ------------------------------------------------
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private String type;

    private Long userId; // Link to user service

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}

