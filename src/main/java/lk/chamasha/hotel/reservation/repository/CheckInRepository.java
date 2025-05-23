package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    boolean existsByRoomIdAndCheckInDateTimeIsNotNull(Long roomId);
}
