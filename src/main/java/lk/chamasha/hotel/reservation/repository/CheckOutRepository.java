package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
    boolean existsByCheckInId(Long checkInId);
}
