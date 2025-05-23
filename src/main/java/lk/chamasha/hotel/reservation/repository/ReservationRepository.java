package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCheckInDate(LocalDate date);
    List<Reservation> findByCreditCardProvidedFalseAndCancelledFalseAndCheckedInFalse();
}
