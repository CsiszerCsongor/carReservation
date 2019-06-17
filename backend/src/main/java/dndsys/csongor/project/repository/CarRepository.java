package dndsys.csongor.project.repository;

import dndsys.csongor.project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
