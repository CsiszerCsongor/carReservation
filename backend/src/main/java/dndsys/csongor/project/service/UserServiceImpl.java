package dndsys.csongor.project.service;

import dndsys.csongor.project.model.Role;
import dndsys.csongor.project.model.RoleName;
import dndsys.csongor.project.model.User;
import dndsys.csongor.project.repository.RoleRepository;
import dndsys.csongor.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User save() {
        return null;
    }

    @Override
    public User save(User item) {
        item.setPassword(encoder.encode(item.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(adminRole);

        item.setRoles(roles);
        return userRepository.save(item);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent())
            return user.get();
        return null;
    }
}
