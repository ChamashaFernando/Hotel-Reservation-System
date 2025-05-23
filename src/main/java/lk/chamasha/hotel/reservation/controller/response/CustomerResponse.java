package lk.chamasha.hotel.reservation.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
