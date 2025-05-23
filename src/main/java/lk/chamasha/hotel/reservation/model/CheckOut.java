package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime checkOutDateTime;

    private String paymentMethod; // "Cash" or "Credit Card"

    private double totalAmount;

    @OneToOne
    @JoinColumn(name = "checkin_id")
    private CheckIn checkIn;

    // Getters and Setters
}
