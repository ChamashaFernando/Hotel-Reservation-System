package lk.chamasha.hotel.reservation.service;


import lk.chamasha.hotel.reservation.controller.request.RoomRequest;
import lk.chamasha.hotel.reservation.controller.response.RoomResponse;

import java.util.List;

public interface RoomService {
    RoomResponse createRoom(RoomRequest request);
    List<RoomResponse> getAllRooms();
    RoomResponse getRoomById(Long id);
    RoomResponse updateRoom(Long id, RoomRequest request);
    void deleteRoom(Long id);
    List<RoomResponse> getAvailableRooms();
}
