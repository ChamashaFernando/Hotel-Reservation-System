package lk.chamasha.hotel.reservation.service;

import lk.chamasha.hotel.reservation.controller.request.CustomerRequest;
import lk.chamasha.hotel.reservation.controller.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest request);
    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(Long id);
    CustomerResponse updateCustomer(Long id, CustomerRequest request);
    void deleteCustomer(Long id);
}
