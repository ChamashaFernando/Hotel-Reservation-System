package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class ServiceChargeRequest {
    private Long reservationId;
    private String serviceType;
    private double amount;

    // Getters and Setters
}
