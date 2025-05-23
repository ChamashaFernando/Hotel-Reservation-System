package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.ServiceCharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceChargeRepository extends JpaRepository<ServiceCharge, Long> {
    List<ServiceCharge> findByReservationId(Long reservationId);
}
