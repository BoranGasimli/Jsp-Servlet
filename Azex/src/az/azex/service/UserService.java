package az.azex.service;

import az.azex.domain.Role;
import az.azex.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> authenticate(String email, String password);

    List<Role> getUserRoles(long userId);
}
