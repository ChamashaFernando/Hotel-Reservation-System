package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

@Data
public class ResidentialSuiteResponse {

    private Long id;
    private String suiteNumber;
    private String description;
    private int capacity;
    private double weeklyRate;
    private double monthlyRate;
    private boolean available;

    // Getters and Setters
}
