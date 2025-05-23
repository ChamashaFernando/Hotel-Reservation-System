package lk.chamasha.hotel.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private int capacity;

    private boolean available = true;

    private double pricePerNight;

    // Getters and Setters
}
