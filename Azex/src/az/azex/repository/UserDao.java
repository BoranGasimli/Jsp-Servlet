package az.azex.repository;

import az.azex.domain.Role;
import az.azex.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> authenticate(String email, String password);

    List<Role> getUserRoles(long userId);
}
