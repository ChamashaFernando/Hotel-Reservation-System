package lk.chamasha.hotel.reservation.service;


import lk.chamasha.hotel.reservation.controller.request.CheckOutRequest;
import lk.chamasha.hotel.reservation.controller.response.CheckOutResponse;

import java.util.List;

public interface CheckOutService {
    CheckOutResponse processCheckOut(CheckOutRequest request);
    CheckOutResponse getCheckOutById(Long id);
    List<CheckOutResponse> getAllCheckOuts();
}
