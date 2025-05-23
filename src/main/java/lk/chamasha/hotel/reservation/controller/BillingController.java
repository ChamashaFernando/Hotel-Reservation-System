package lk.chamasha.hotel.reservation.controller;


import lk.chamasha.hotel.reservation.controller.request.BillingRequest;
import lk.chamasha.hotel.reservation.controller.response.BillingResponse;
import lk.chamasha.hotel.reservation.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public BillingResponse createBill(@RequestBody BillingRequest request) {
        return billingService.createBill(request);
    }

    @GetMapping("/{id}")
    public BillingResponse getBill(@PathVariable Long id) {
        return billingService.getBillById(id);
    }

    @GetMapping
    public List<BillingResponse> getAllBills() {
        return billingService.getAllBills();
    }
}
