package lk.chamasha.hotel.reservation.service;


import lk.chamasha.hotel.reservation.controller.request.ResidentialSuiteRequest;
import lk.chamasha.hotel.reservation.controller.response.ResidentialSuiteResponse;

import java.util.List;

public interface ResidentialSuiteService {

    ResidentialSuiteResponse create(ResidentialSuiteRequest request);
    ResidentialSuiteResponse getById(Long id);
    List<ResidentialSuiteResponse> getAll();
    ResidentialSuiteResponse update(Long id, ResidentialSuiteRequest request);
    void delete(Long id);
}
