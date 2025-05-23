package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ReportRequest {

    private LocalDate reportDate;
    private int totalOccupancy;
    private double totalRevenue;
    private int noShowCount;
    private int totalReservations;
    private String type;

    // Getters and Setters
}
