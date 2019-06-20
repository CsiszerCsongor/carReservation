package dndsys.csongor.project.repository;

import dndsys.csongor.project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByCarCode(String carCode);
}
