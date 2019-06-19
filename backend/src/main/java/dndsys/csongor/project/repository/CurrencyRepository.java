package dndsys.csongor.project.repository;

import dndsys.csongor.project.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    boolean existsByName(String name);
}
