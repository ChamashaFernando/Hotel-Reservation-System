package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceType;  // e.g. Restaurant, Room Service, Laundry, Telephone, Club Facility

    private double amount;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Getters and Setters
}
