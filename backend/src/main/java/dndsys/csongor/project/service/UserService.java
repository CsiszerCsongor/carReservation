package dndsys.csongor.project.service;

import dndsys.csongor.project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save();

    User save(User item);

    User findByUsername(String username);
}
