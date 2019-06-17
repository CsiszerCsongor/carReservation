package dndsys.csongor.project.service;

import dndsys.csongor.project.model.Role;
import dndsys.csongor.project.model.RoleName;
import dndsys.csongor.project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean existRoleName(RoleName roleName) {
        return roleRepository.existsByName(roleName);
    }

    @Override
    public Role save(Role role) {
        Role tmp = roleRepository.save(role);
        if(tmp != null)
            return tmp;
        return null;
    }

    @Override
    public boolean save(List<Role> roles) {
        for(int i = 0; i < roles.size(); ++i){
            Role tmp = roleRepository.save(roles.get(i));
            if(tmp == null){
                return false;
            }
        }
        return true;
    }
}
