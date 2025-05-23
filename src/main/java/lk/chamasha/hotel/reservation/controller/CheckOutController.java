package lk.chamasha.hotel.reservation.controller;


import lk.chamasha.hotel.reservation.controller.request.CheckOutRequest;
import lk.chamasha.hotel.reservation.controller.response.CheckOutResponse;
import lk.chamasha.hotel.reservation.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {

    @Autowired
    private CheckOutService checkOutService;

    @PostMapping
    public CheckOutResponse processCheckOut(@RequestBody CheckOutRequest request) {
        return checkOutService.processCheckOut(request);
    }

    @GetMapping("/{id}")
    public CheckOutResponse getCheckOutById(@PathVariable Long id) {
        return checkOutService.getCheckOutById(id);
    }

    @GetMapping
    public List<CheckOutResponse> getAllCheckOuts() {
        return checkOutService.getAllCheckOuts();
    }
}
