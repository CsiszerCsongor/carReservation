package dndsys.csongor.project.service;

import dndsys.csongor.project.model.Role;
import dndsys.csongor.project.model.RoleName;

import java.util.List;

public interface RoleService {
    boolean existRoleName(RoleName roleName);
    Role save(Role role);
    boolean save(List<Role> roles);
}
