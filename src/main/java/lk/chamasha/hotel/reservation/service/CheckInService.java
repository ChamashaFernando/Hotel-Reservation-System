package lk.chamasha.hotel.reservation.service;


import lk.chamasha.hotel.reservation.controller.request.CheckInRequest;
import lk.chamasha.hotel.reservation.controller.response.CheckInResponse;

import java.util.List;

public interface CheckInService {
    CheckInResponse checkInCustomer(CheckInRequest request);
    List<CheckInResponse> getAllCheckIns();
    CheckInResponse getCheckInById(Long id);
}
