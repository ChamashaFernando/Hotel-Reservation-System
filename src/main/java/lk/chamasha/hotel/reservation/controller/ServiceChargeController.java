package lk.chamasha.hotel.reservation.controller;


import lk.chamasha.hotel.reservation.controller.request.ServiceChargeRequest;
import lk.chamasha.hotel.reservation.controller.response.ServiceChargeResponse;
import lk.chamasha.hotel.reservation.service.ServiceChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicecharges")
public class ServiceChargeController {

    @Autowired
    private ServiceChargeService serviceChargeService;

    @PostMapping
    public ServiceChargeResponse addServiceCharge(@RequestBody ServiceChargeRequest request) {
        return serviceChargeService.addServiceCharge(request);
    }

    @GetMapping("/reservation/{reservationId}")
    public List<ServiceChargeResponse> getChargesByReservation(@PathVariable Long reservationId) {
        return serviceChargeService.getChargesByReservation(reservationId);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceCharge(@PathVariable Long id) {
        serviceChargeService.deleteServiceCharge(id);
    }
}
