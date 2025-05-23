package lk.chamasha.hotel.reservation.service;



import lk.chamasha.hotel.reservation.controller.request.ReservationRequest;
import lk.chamasha.hotel.reservation.controller.response.ReservationResponse;

import java.util.List;

public interface ReservationService {
    ReservationResponse createReservation(ReservationRequest request);
    List<ReservationResponse> getAllReservations();
    ReservationResponse getReservationById(Long id);
    ReservationResponse updateReservation(Long id, ReservationRequest request);
    void cancelReservation(Long id);
}
