package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CheckOutResponse {
    private Long id;
    private Long checkInId;
    private String paymentMethod;
    private double totalAmount;
    private LocalDateTime checkOutDateTime;

    // Getters and Setters
}
