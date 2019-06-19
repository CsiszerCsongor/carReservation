package dndsys.csongor.project.repository;

import dndsys.csongor.project.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
