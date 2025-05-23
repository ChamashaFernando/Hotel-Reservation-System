package lk.chamasha.hotel.reservation.controller.request;


import lk.chamasha.hotel.reservation.model.RoomType;
import lombok.Data;

@Data
public class RoomRequest {
    private String roomNumber;
    private RoomType roomType;
    private int capacity;
    private double pricePerNight;

    // Getters and Setters
}
