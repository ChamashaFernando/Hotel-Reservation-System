package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BillingResponse {
    private Long id;
    private Long reservationId;
    private double roomCharges;
    private double restaurantCharges;
    private double roomServiceCharges;
    private double laundryCharges;
    private double telephoneCharges;
    private double clubFacilityCharges;
    private double extraNightCharges;
    private double totalAmount;
    private String paymentMethod;
    private LocalDateTime billingDate;

    // Getters and Setters
}
