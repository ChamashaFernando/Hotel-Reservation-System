package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class BillingRequest {
    private Long reservationId;
    private double restaurantCharges;
    private double roomServiceCharges;
    private double laundryCharges;
    private double telephoneCharges;
    private double clubFacilityCharges;
    private double extraNightCharges;
    private String paymentMethod;

    // Getters and Setters
}
