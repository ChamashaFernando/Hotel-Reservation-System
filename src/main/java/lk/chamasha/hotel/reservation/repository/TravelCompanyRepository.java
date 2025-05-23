package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.TravelCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelCompanyRepository extends JpaRepository<TravelCompany, Long> {
}
