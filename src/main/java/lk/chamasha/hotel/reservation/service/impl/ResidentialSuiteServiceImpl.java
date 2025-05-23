package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.ResidentialSuiteRequest;
import lk.chamasha.hotel.reservation.controller.response.ResidentialSuiteResponse;
import lk.chamasha.hotel.reservation.model.ResidentialSuite;
import lk.chamasha.hotel.reservation.repository.ResidentialSuiteRepository;
import lk.chamasha.hotel.reservation.service.ResidentialSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentialSuiteServiceImpl implements ResidentialSuiteService {

    @Autowired
    private ResidentialSuiteRepository repository;

    @Override
    public ResidentialSuiteResponse create(ResidentialSuiteRequest request) {
        ResidentialSuite suite = mapToEntity(request);
        return mapToResponse(repository.save(suite));
    }

    @Override
    public ResidentialSuiteResponse getById(Long id) {
        ResidentialSuite suite = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Residential Suite not found"));
        return mapToResponse(suite);
    }

    @Override
    public List<ResidentialSuiteResponse> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResidentialSuiteResponse update(Long id, ResidentialSuiteRequest request) {
        ResidentialSuite suite = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Residential Suite not found"));

        suite.setSuiteNumber(request.getSuiteNumber());
        suite.setDescription(request.getDescription());
        suite.setCapacity(request.getCapacity());
        suite.setWeeklyRate(request.getWeeklyRate());
        suite.setMonthlyRate(request.getMonthlyRate());
        suite.setAvailable(request.isAvailable());

        return mapToResponse(repository.save(suite));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ResidentialSuite mapToEntity(ResidentialSuiteRequest request) {
        ResidentialSuite suite = new ResidentialSuite();
        suite.setSuiteNumber(request.getSuiteNumber());
        suite.setDescription(request.getDescription());
        suite.setCapacity(request.getCapacity());
        suite.setWeeklyRate(request.getWeeklyRate());
        suite.setMonthlyRate(request.getMonthlyRate());
        suite.setAvailable(request.isAvailable());
        return suite;
    }

    private ResidentialSuiteResponse mapToResponse(ResidentialSuite suite) {
        ResidentialSuiteResponse response = new ResidentialSuiteResponse();
        response.setId(suite.getId());
        response.setSuiteNumber(suite.getSuiteNumber());
        response.setDescription(suite.getDescription());
        response.setCapacity(suite.getCapacity());
        response.setWeeklyRate(suite.getWeeklyRate());
        response.setMonthlyRate(suite.getMonthlyRate());
        response.setAvailable(suite.isAvailable());
        return response;
    }
}
