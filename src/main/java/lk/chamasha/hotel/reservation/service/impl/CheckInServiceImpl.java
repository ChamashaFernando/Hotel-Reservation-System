package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.CheckInRequest;
import lk.chamasha.hotel.reservation.controller.response.CheckInResponse;
import lk.chamasha.hotel.reservation.model.CheckIn;
import lk.chamasha.hotel.reservation.model.Customer;
import lk.chamasha.hotel.reservation.model.Reservation;
import lk.chamasha.hotel.reservation.model.Room;
import lk.chamasha.hotel.reservation.repository.CheckInRepository;
import lk.chamasha.hotel.reservation.repository.CustomerRepository;
import lk.chamasha.hotel.reservation.repository.ReservationRepository;
import lk.chamasha.hotel.reservation.repository.RoomRepository;
import lk.chamasha.hotel.reservation.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public CheckInResponse checkInCustomer(CheckInRequest request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Check if room is already occupied
        boolean isOccupied = checkInRepository.existsByRoomIdAndCheckInDateTimeIsNotNull(room.getId());
        if (isOccupied) {
            throw new RuntimeException("Room is already occupied");
        }

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Reservation reservation = null;
        if (request.getReservationId() != null) {
            reservation = reservationRepository.findById(request.getReservationId())
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));
        }

        CheckIn checkIn = new CheckIn();
        checkIn.setRoom(room);
        checkIn.setCustomer(customer);
        checkIn.setReservation(reservation);
        checkIn.setCheckInDateTime(LocalDateTime.now());

        CheckIn saved = checkInRepository.save(checkIn);
        return mapToResponse(saved);
    }

    @Override
    public List<CheckInResponse> getAllCheckIns() {
        return checkInRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CheckInResponse getCheckInById(Long id) {
        CheckIn checkIn = checkInRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CheckIn not found"));
        return mapToResponse(checkIn);
    }

    private CheckInResponse mapToResponse(CheckIn checkIn) {
        CheckInResponse response = new CheckInResponse();
        response.setId(checkIn.getId());
        response.setRoomId(checkIn.getRoom().getId());
        response.setCustomerId(checkIn.getCustomer().getId());
        response.setReservationId(checkIn.getReservation() != null ? checkIn.getReservation().getId() : null);
        response.setCheckInDateTime(checkIn.getCheckInDateTime());
        return response;
    }
}
