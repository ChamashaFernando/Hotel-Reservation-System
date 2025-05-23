package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReservationResponse {
    private Long id;
    private Long customerId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private boolean checkedIn;
    private boolean cancelled;
    private boolean creditCardProvided;

    // Getters and Setters
}
