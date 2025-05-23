package lk.chamasha.hotel.reservation.controller.response;


import lk.chamasha.hotel.reservation.model.RoomType;
import lombok.Data;

@Data
public class RoomResponse {
    private Long id;
    private String roomNumber;
    private RoomType roomType;
    private int capacity;
    private boolean available;
    private double pricePerNight;

    // Getters and Setters
}
