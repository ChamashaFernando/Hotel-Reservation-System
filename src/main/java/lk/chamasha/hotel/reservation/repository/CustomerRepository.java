package lk.chamasha.hotel.reservation.repository;

import lk.chamasha.hotel.reservation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
