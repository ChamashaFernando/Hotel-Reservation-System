package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ResidentialSuite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String suiteNumber;

    private String description;

    private int capacity;

    private double weeklyRate;

    private double monthlyRate;

    private boolean available;

    // Getters and Setters
}
