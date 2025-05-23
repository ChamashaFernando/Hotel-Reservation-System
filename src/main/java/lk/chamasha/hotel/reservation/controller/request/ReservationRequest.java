package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReservationRequest {
    private Long customerId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private boolean creditCardProvided;

    // Getters and Setters
}
