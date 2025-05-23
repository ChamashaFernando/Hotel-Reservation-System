package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class ResidentialSuiteRequest {

    private String suiteNumber;
    private String description;
    private int capacity;
    private double weeklyRate;
    private double monthlyRate;
    private boolean available;

    // Getters and Setters
}
