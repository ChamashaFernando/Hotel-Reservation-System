package lk.chamasha.hotel.reservation.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckInRequest {
    @NotNull
    private Long reservationId;
}
