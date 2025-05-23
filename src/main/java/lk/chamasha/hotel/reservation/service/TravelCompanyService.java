package lk.chamasha.hotel.reservation.service;



import lk.chamasha.hotel.reservation.controller.request.TravelCompanyRequest;
import lk.chamasha.hotel.reservation.controller.response.TravelCompanyResponse;

import java.util.List;

public interface TravelCompanyService {
    TravelCompanyResponse createTravelCompany(TravelCompanyRequest request);
    TravelCompanyResponse getTravelCompanyById(Long id);
    List<TravelCompanyResponse> getAllTravelCompanies();
    TravelCompanyResponse updateTravelCompany(Long id, TravelCompanyRequest request);
    void deleteTravelCompany(Long id);
}
