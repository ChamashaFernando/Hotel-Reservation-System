package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double roomCharges;
    private double restaurantCharges;
    private double roomServiceCharges;
    private double laundryCharges;
    private double telephoneCharges;
    private double clubFacilityCharges;
    private double extraNightCharges;

    private double totalAmount;
    private String paymentMethod;

    private LocalDateTime billingDate;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Getters and Setters
}
