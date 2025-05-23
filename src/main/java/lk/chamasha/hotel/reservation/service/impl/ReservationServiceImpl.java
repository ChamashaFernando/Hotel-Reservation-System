package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.ReservationRequest;
import lk.chamasha.hotel.reservation.controller.response.ReservationResponse;
import lk.chamasha.hotel.reservation.model.Customer;
import lk.chamasha.hotel.reservation.model.Reservation;
import lk.chamasha.hotel.reservation.model.Room;
import lk.chamasha.hotel.reservation.repository.CustomerRepository;
import lk.chamasha.hotel.reservation.repository.ReservationRepository;
import lk.chamasha.hotel.reservation.repository.RoomRepository;
import lk.chamasha.hotel.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public ReservationResponse createReservation(ReservationRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setNumberOfGuests(request.getNumberOfGuests());
        reservation.setCreditCardProvided(request.isCreditCardProvided());

        return mapToResponse(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponse getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Override
    public ReservationResponse updateReservation(Long id, ReservationRequest request) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        reservation.setRoom(room);
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        reservation.setNumberOfGuests(request.getNumberOfGuests());
        reservation.setCreditCardProvided(request.isCreditCardProvided());

        return mapToResponse(reservationRepository.save(reservation));
    }

    @Override
    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setCancelled(true);
        reservationRepository.save(reservation);
    }

    private ReservationResponse mapToResponse(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();
        response.setId(reservation.getId());
        response.setCustomerId(reservation.getCustomer().getId());
        response.setRoomId(reservation.getRoom().getId());
        response.setCheckInDate(reservation.getCheckInDate());
        response.setCheckOutDate(reservation.getCheckOutDate());
        response.setNumberOfGuests(reservation.getNumberOfGuests());
        response.setCheckedIn(reservation.isCheckedIn());
        response.setCancelled(reservation.isCancelled());
        response.setCreditCardProvided(reservation.isCreditCardProvided());
        return response;
    }
}
