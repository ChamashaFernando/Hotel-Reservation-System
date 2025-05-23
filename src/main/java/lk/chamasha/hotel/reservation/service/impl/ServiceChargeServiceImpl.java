package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.ServiceChargeRequest;
import lk.chamasha.hotel.reservation.controller.response.ServiceChargeResponse;
import lk.chamasha.hotel.reservation.model.Reservation;
import lk.chamasha.hotel.reservation.model.ServiceCharge;
import lk.chamasha.hotel.reservation.repository.ReservationRepository;
import lk.chamasha.hotel.reservation.repository.ServiceChargeRepository;
import lk.chamasha.hotel.reservation.service.ServiceChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceChargeServiceImpl implements ServiceChargeService {

    @Autowired
    private ServiceChargeRepository serviceChargeRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ServiceChargeResponse addServiceCharge(ServiceChargeRequest request) {
        Reservation reservation = reservationRepository.findById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        ServiceCharge serviceCharge = new ServiceCharge();
        serviceCharge.setReservation(reservation);
        serviceCharge.setServiceType(request.getServiceType());
        serviceCharge.setAmount(request.getAmount());

        return mapToResponse(serviceChargeRepository.save(serviceCharge));
    }

    @Override
    public List<ServiceChargeResponse> getChargesByReservation(Long reservationId) {
        List<ServiceCharge> charges = serviceChargeRepository.findByReservationId(reservationId);
        return charges.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteServiceCharge(Long id) {
        serviceChargeRepository.deleteById(id);
    }

    private ServiceChargeResponse mapToResponse(ServiceCharge serviceCharge) {
        ServiceChargeResponse response = new ServiceChargeResponse();
        response.setId(serviceCharge.getId());
        response.setReservationId(serviceCharge.getReservation().getId());
        response.setServiceType(serviceCharge.getServiceType());
        response.setAmount(serviceCharge.getAmount());
        return response;
    }
}
