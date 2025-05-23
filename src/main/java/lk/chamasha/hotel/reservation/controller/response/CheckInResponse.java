package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CheckInResponse {
    private Long id;
    private Long reservationId;
    private Long customerId;
    private Long roomId;
    private LocalDateTime checkInDateTime;

    // Getters and Setters
}
