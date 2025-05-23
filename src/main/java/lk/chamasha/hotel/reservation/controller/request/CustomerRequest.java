package lk.chamasha.hotel.reservation.controller.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private String phone;

}
