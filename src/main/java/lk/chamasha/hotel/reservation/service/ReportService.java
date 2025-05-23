package lk.chamasha.hotel.reservation.service;



import lk.chamasha.hotel.reservation.controller.request.ReportRequest;
import lk.chamasha.hotel.reservation.controller.response.ReportResponse;

import java.util.List;

public interface ReportService {

    ReportResponse create(ReportRequest request);
    ReportResponse getById(Long id);
    List<ReportResponse> getAll();
    ReportResponse update(Long id, ReportRequest request);
    void delete(Long id);
}
