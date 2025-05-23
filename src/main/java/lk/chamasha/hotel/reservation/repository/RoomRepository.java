package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailableTrue();
}
