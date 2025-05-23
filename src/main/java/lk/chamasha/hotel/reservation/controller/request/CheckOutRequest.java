
package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class CheckOutRequest {
    private Long checkInId;
    private String paymentMethod;

    // Getters and Setters
}
