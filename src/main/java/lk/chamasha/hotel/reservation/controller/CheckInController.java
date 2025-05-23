package lk.chamasha.hotel.reservation.controller;


import lk.chamasha.hotel.reservation.controller.request.CheckInRequest;
import lk.chamasha.hotel.reservation.controller.response.CheckInResponse;
import lk.chamasha.hotel.reservation.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @PostMapping
    public CheckInResponse checkInCustomer(@RequestBody CheckInRequest request) {
        return checkInService.checkInCustomer(request);
    }

    @GetMapping("/{id}")
    public CheckInResponse getCheckInById(@PathVariable Long id) {
        return checkInService.getCheckInById(id);
    }

    @GetMapping
    public List<CheckInResponse> getAllCheckIns() {
        return checkInService.getAllCheckIns();
    }
}
