package lk.chamasha.hotel.reservation.service.impl;


import lk.chamasha.hotel.reservation.controller.request.ReportRequest;
import lk.chamasha.hotel.reservation.controller.response.ReportResponse;
import lk.chamasha.hotel.reservation.model.Report;
import lk.chamasha.hotel.reservation.repository.ReportRepository;
import lk.chamasha.hotel.reservation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;

    @Override
    public ReportResponse create(ReportRequest request) {
        Report report = mapToEntity(request);
        return mapToResponse(repository.save(report));
    }

    @Override
    public ReportResponse getById(Long id) {
        Report report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        return mapToResponse(report);
    }

    @Override
    public List<ReportResponse> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReportResponse update(Long id, ReportRequest request) {
        Report report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setReportDate(request.getReportDate());
        report.setTotalOccupancy(request.getTotalOccupancy());
        report.setTotalRevenue(request.getTotalRevenue());
        report.setNoShowCount(request.getNoShowCount());
        report.setTotalReservations(request.getTotalReservations());
        report.setType(request.getType());

        return mapToResponse(repository.save(report));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Report mapToEntity(ReportRequest request) {
        Report report = new Report();
        report.setReportDate(request.getReportDate());
        report.setTotalOccupancy(request.getTotalOccupancy());
        report.setTotalRevenue(request.getTotalRevenue());
        report.setNoShowCount(request.getNoShowCount());
        report.setTotalReservations(request.getTotalReservations());
        report.setType(request.getType());
        return report;
    }

    private ReportResponse mapToResponse(Report report) {
        ReportResponse response = new ReportResponse();
        response.setId(report.getId());
        response.setReportDate(report.getReportDate());
        response.setTotalOccupancy(report.getTotalOccupancy());
        response.setTotalRevenue(report.getTotalRevenue());
        response.setNoShowCount(report.getNoShowCount());
        response.setTotalReservations(report.getTotalReservations());
        response.setType(report.getType());
        return response;
    }
}
