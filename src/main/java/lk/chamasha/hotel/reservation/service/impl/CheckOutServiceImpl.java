package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.CheckOutRequest;
import lk.chamasha.hotel.reservation.controller.response.CheckOutResponse;
import lk.chamasha.hotel.reservation.model.CheckIn;
import lk.chamasha.hotel.reservation.model.CheckOut;
import lk.chamasha.hotel.reservation.model.ServiceCharge;
import lk.chamasha.hotel.reservation.repository.CheckInRepository;
import lk.chamasha.hotel.reservation.repository.CheckOutRepository;
import lk.chamasha.hotel.reservation.repository.ServiceChargeRepository;
import lk.chamasha.hotel.reservation.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private CheckOutRepository checkOutRepository;

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ServiceChargeRepository serviceChargeRepository;

    @Override
    public CheckOutResponse processCheckOut(CheckOutRequest request) {
        if (checkOutRepository.existsByCheckInId(request.getCheckInId())) {
            throw new RuntimeException("Already checked out.");
        }

        CheckIn checkIn = checkInRepository.findById(request.getCheckInId())
                .orElseThrow(() -> new RuntimeException("CheckIn not found"));

        LocalDateTime now = LocalDateTime.now();

        // Example cost calculation (simplified)
        long nightsStayed = Duration.between(checkIn.getCheckInDateTime(), now).toDays();
        if (nightsStayed == 0) nightsStayed = 1;

        double roomRate = checkIn.getRoom().getPricePerNight(); // Assume this field exists
        double roomCharge = roomRate * nightsStayed;

        // Additional service charges
        List<ServiceCharge> extras = serviceChargeRepository.findByReservationId(
                checkIn.getReservation() != null ? checkIn.getReservation().getId() : -1L
        );
        double extraCharge = extras.stream().mapToDouble(ServiceCharge::getAmount).sum();

        double total = roomCharge + extraCharge;

        CheckOut checkOut = new CheckOut();
        checkOut.setCheckIn(checkIn);
        checkOut.setPaymentMethod(request.getPaymentMethod());
        checkOut.setCheckOutDateTime(now);
        checkOut.setTotalAmount(total);

        return mapToResponse(checkOutRepository.save(checkOut));
    }

    @Override
    public CheckOutResponse getCheckOutById(Long id) {
        return checkOutRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Checkout not found"));
    }

    @Override
    public List<CheckOutResponse> getAllCheckOuts() {
        return checkOutRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CheckOutResponse mapToResponse(CheckOut checkOut) {
        CheckOutResponse response = new CheckOutResponse();
        response.setId(checkOut.getId());
        response.setCheckInId(checkOut.getCheckIn().getId());
        response.setPaymentMethod(checkOut.getPaymentMethod());
        response.setTotalAmount(checkOut.getTotalAmount());
        response.setCheckOutDateTime(checkOut.getCheckOutDateTime());
        return response;
    }
}
