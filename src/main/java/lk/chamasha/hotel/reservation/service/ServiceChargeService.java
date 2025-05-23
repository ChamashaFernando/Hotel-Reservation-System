package lk.chamasha.hotel.reservation.service;



import lk.chamasha.hotel.reservation.controller.request.ServiceChargeRequest;
import lk.chamasha.hotel.reservation.controller.response.ServiceChargeResponse;

import java.util.List;

public interface ServiceChargeService {
    ServiceChargeResponse addServiceCharge(ServiceChargeRequest request);
    List<ServiceChargeResponse> getChargesByReservation(Long reservationId);
    void deleteServiceCharge(Long id);
}
