package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

@Data
public class TravelCompanyResponse {
    private Long id;
    private String name;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String address;
    private double discountRate;

    // Getters and Setters
}
