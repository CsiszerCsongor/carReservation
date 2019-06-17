package dndsys.csongor.project.repository;

import dndsys.csongor.project.model.Role;
import dndsys.csongor.project.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(RoleName roleName);
    Optional<Role> findByName(RoleName roleName);
}
