package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.TravelCompanyRequest;
import lk.chamasha.hotel.reservation.controller.response.TravelCompanyResponse;
import lk.chamasha.hotel.reservation.model.TravelCompany;
import lk.chamasha.hotel.reservation.repository.TravelCompanyRepository;
import lk.chamasha.hotel.reservation.service.TravelCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelCompanyServiceImpl implements TravelCompanyService {

    @Autowired
    private TravelCompanyRepository repository;

    @Override
    public TravelCompanyResponse createTravelCompany(TravelCompanyRequest request) {
        TravelCompany company = mapToEntity(request);
        return mapToResponse(repository.save(company));
    }

    @Override
    public TravelCompanyResponse getTravelCompanyById(Long id) {
        TravelCompany company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel company not found"));
        return mapToResponse(company);
    }

    @Override
    public List<TravelCompanyResponse> getAllTravelCompanies() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TravelCompanyResponse updateTravelCompany(Long id, TravelCompanyRequest request) {
        TravelCompany company = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Travel company not found"));

        company.setName(request.getName());
        company.setContactPerson(request.getContactPerson());
        company.setEmail(request.getEmail());
        company.setPhoneNumber(request.getPhoneNumber());
        company.setAddress(request.getAddress());
        company.setDiscountRate(request.getDiscountRate());

        return mapToResponse(repository.save(company));
    }

    @Override
    public void deleteTravelCompany(Long id) {
        repository.deleteById(id);
    }

    private TravelCompany mapToEntity(TravelCompanyRequest request) {
        TravelCompany company = new TravelCompany();
        company.setName(request.getName());
        company.setContactPerson(request.getContactPerson());
        company.setEmail(request.getEmail());
        company.setPhoneNumber(request.getPhoneNumber());
        company.setAddress(request.getAddress());
        company.setDiscountRate(request.getDiscountRate());
        return company;
    }

    private TravelCompanyResponse mapToResponse(TravelCompany company) {
        TravelCompanyResponse response = new TravelCompanyResponse();
        response.setId(company.getId());
        response.setName(company.getName());
        response.setContactPerson(company.getContactPerson());
        response.setEmail(company.getEmail());
        response.setPhoneNumber(company.getPhoneNumber());
        response.setAddress(company.getAddress());
        response.setDiscountRate(company.getDiscountRate());
        return response;
    }
}
