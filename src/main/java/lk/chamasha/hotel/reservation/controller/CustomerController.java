package lk.chamasha.hotel.reservation.controller;

import lk.chamasha.hotel.reservation.controller.request.CustomerRequest;
import lk.chamasha.hotel.reservation.controller.response.CustomerResponse;
import lk.chamasha.hotel.reservation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest request) {
        return customerService.updateCustomer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
