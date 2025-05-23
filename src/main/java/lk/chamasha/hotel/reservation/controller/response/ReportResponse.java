package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReportResponse {

    private Long id;
    private LocalDate reportDate;
    private int totalOccupancy;
    private double totalRevenue;
    private int noShowCount;
    private int totalReservations;
    private String type;

    // Getters and Setters
}
