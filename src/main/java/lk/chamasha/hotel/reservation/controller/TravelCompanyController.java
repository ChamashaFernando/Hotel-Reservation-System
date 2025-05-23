package lk.chamasha.hotel.reservation.controller;

import lk.chamasha.hotel.reservation.controller.request.TravelCompanyRequest;
import lk.chamasha.hotel.reservation.controller.response.TravelCompanyResponse;
import lk.chamasha.hotel.reservation.service.TravelCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-companies")
public class TravelCompanyController {

    @Autowired
    private TravelCompanyService travelCompanyService;

    @PostMapping
    public TravelCompanyResponse createTravelCompany(@RequestBody TravelCompanyRequest request) {
        return travelCompanyService.createTravelCompany(request);
    }

    @GetMapping("/{id}")
    public TravelCompanyResponse getById(@PathVariable Long id) {
        return travelCompanyService.getTravelCompanyById(id);
    }

    @GetMapping
    public List<TravelCompanyResponse> getAll() {
        return travelCompanyService.getAllTravelCompanies();
    }

    @PutMapping("/{id}")
    public TravelCompanyResponse update(@PathVariable Long id, @RequestBody TravelCompanyRequest request) {
        return travelCompanyService.updateTravelCompany(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        travelCompanyService.deleteTravelCompany(id);
    }
}
