package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TravelCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactPerson;

    private String email;

    private String phoneNumber;

    private String address;

    private double discountRate; // e.g., 0.1 for 10%

    // Getters and Setters
}
