package lk.chamasha.hotel.reservation.controller;


import lk.chamasha.hotel.reservation.controller.request.RoomRequest;
import lk.chamasha.hotel.reservation.controller.response.RoomResponse;
import lk.chamasha.hotel.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public RoomResponse createRoom(@RequestBody RoomRequest request) {
        return roomService.createRoom(request);
    }

    @GetMapping
    public List<RoomResponse> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public RoomResponse getRoom(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}")
    public RoomResponse updateRoom(@PathVariable Long id, @RequestBody RoomRequest request) {
        return roomService.updateRoom(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

    @GetMapping("/available")
    public List<RoomResponse> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }
}
