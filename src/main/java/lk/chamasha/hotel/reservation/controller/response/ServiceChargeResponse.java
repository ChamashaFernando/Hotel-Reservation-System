
package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

@Data
public class ServiceChargeResponse {
    private Long id;
    private Long reservationId;
    private String serviceType;
    private double amount;

    // Getters and Setters
}
