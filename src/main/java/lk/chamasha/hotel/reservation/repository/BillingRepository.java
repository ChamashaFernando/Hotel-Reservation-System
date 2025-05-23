package lk.chamasha.hotel.reservation.repository;


import lk.chamasha.hotel.reservation.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
