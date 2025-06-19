package lk.ijse.parkingservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private Long durationMinutes;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private ParkingSpace parkingSpace;
}
