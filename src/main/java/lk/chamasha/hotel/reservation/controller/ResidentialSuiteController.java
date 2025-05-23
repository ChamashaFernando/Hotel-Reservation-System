package lk.chamasha.hotel.reservation.controller;


import lk.chamasha.hotel.reservation.controller.request.ResidentialSuiteRequest;
import lk.chamasha.hotel.reservation.controller.response.ResidentialSuiteResponse;
import lk.chamasha.hotel.reservation.service.ResidentialSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residential-suites")
public class ResidentialSuiteController {

    @Autowired
    private ResidentialSuiteService service;

    @PostMapping
    public ResidentialSuiteResponse create(@RequestBody ResidentialSuiteRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ResidentialSuiteResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ResidentialSuiteResponse> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResidentialSuiteResponse update(@PathVariable Long id, @RequestBody ResidentialSuiteRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
