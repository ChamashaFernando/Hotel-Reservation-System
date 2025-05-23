package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate reportDate;

    private int totalOccupancy;

    private double totalRevenue;

    private int noShowCount;

    private int totalReservations;

    private String type; // e.g., "Daily", "Monthly"

    // Getters and Setters
}
