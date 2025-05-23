package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.BillingRequest;
import lk.chamasha.hotel.reservation.controller.response.BillingResponse;
import lk.chamasha.hotel.reservation.model.Billing;
import lk.chamasha.hotel.reservation.model.Reservation;
import lk.chamasha.hotel.reservation.repository.BillingRepository;
import lk.chamasha.hotel.reservation.repository.ReservationRepository;
import lk.chamasha.hotel.reservation.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public BillingResponse createBill(BillingRequest request) {
        Reservation reservation = reservationRepository.findById(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        double roomCharges = calculateRoomCharges(reservation);
        double total = roomCharges
                + request.getRestaurantCharges()
                + request.getRoomServiceCharges()
                + request.getLaundryCharges()
                + request.getTelephoneCharges()
                + request.getClubFacilityCharges()
                + request.getExtraNightCharges();

        Billing billing = new Billing();
        billing.setReservation(reservation);
        billing.setRoomCharges(roomCharges);
        billing.setRestaurantCharges(request.getRestaurantCharges());
        billing.setRoomServiceCharges(request.getRoomServiceCharges());
        billing.setLaundryCharges(request.getLaundryCharges());
        billing.setTelephoneCharges(request.getTelephoneCharges());
        billing.setClubFacilityCharges(request.getClubFacilityCharges());
        billing.setExtraNightCharges(request.getExtraNightCharges());
        billing.setTotalAmount(total);
        billing.setPaymentMethod(request.getPaymentMethod());
        billing.setBillingDate(LocalDateTime.now());

        return mapToResponse(billingRepository.save(billing));
    }

    @Override
    public BillingResponse getBillById(Long id) {
        return billingRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
    }

    @Override
    public List<BillingResponse> getAllBills() {
        return billingRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private double calculateRoomCharges(Reservation reservation) {
        long days = java.time.temporal.ChronoUnit.DAYS.between(
                reservation.getCheckInDate(), reservation.getCheckOutDate());
        return reservation.getRoom().getPricePerNight() * days;
    }

    private BillingResponse mapToResponse(Billing billing) {
        BillingResponse response = new BillingResponse();
        response.setId(billing.getId());
        response.setReservationId(billing.getReservation().getId());
        response.setRoomCharges(billing.getRoomCharges());
        response.setRestaurantCharges(billing.getRestaurantCharges());
        response.setRoomServiceCharges(billing.getRoomServiceCharges());
        response.setLaundryCharges(billing.getLaundryCharges());
        response.setTelephoneCharges(billing.getTelephoneCharges());
        response.setClubFacilityCharges(billing.getClubFacilityCharges());
        response.setExtraNightCharges(billing.getExtraNightCharges());
        response.setTotalAmount(billing.getTotalAmount());
        response.setPaymentMethod(billing.getPaymentMethod());
        response.setBillingDate(billing.getBillingDate());
        return response;
    }
}
