
package lk.chamasha.hotel.reservation.controller;

import lk.chamasha.hotel.reservation.controller.request.ReportRequest;
import lk.chamasha.hotel.reservation.controller.response.ReportResponse;
import lk.chamasha.hotel.reservation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService service;

    @PostMapping
    public ReportResponse create(@RequestBody ReportRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ReportResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ReportResponse> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ReportResponse update(@PathVariable Long id, @RequestBody ReportRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
