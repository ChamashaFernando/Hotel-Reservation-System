package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

@Data
public class ReportResponse {
    private String date;
    private Integer totalOccupancy;
    private Double totalRevenue;
}
