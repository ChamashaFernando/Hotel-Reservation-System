package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findByReportDate(LocalDate date);
}
