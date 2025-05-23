package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class CheckInRequest {
    private Long reservationId;  // can be null if walk-in
    private Long customerId;
    private Long roomId;

    // Getters and Setters
}
