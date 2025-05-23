package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.RoomRequest;
import lk.chamasha.hotel.reservation.controller.response.RoomResponse;
import lk.chamasha.hotel.reservation.model.Room;
import lk.chamasha.hotel.reservation.repository.RoomRepository;
import lk.chamasha.hotel.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomResponse createRoom(RoomRequest request) {
        Room room = new Room();
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setCapacity(request.getCapacity());
        room.setPricePerNight(request.getPricePerNight());
        room.setAvailable(true);

        return mapToResponse(roomRepository.save(room));
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return mapToResponse(room);
    }

    @Override
    public RoomResponse updateRoom(Long id, RoomRequest request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setCapacity(request.getCapacity());
        room.setPricePerNight(request.getPricePerNight());

        return mapToResponse(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<RoomResponse> getAvailableRooms() {
        return roomRepository.findByAvailableTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private RoomResponse mapToResponse(Room room) {
        RoomResponse response = new RoomResponse();
        response.setId(room.getId());
        response.setRoomNumber(room.getRoomNumber());
        response.setRoomType(room.getRoomType());
        response.setCapacity(room.getCapacity());
        response.setAvailable(room.isAvailable());
        response.setPricePerNight(room.getPricePerNight());
        return response;
    }
}
