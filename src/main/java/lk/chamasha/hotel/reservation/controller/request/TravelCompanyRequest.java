package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class TravelCompanyRequest {
    private String name;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String address;
    private double discountRate;

    // Getters and Setters
}
