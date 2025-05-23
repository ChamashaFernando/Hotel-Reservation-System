package lk.chamasha.hotel.reservation.service;



import lk.chamasha.hotel.reservation.controller.request.BillingRequest;
import lk.chamasha.hotel.reservation.controller.response.BillingResponse;

import java.util.List;

public interface BillingService {
    BillingResponse createBill(BillingRequest request);
    BillingResponse getBillById(Long id);
    List<BillingResponse> getAllBills();
}
