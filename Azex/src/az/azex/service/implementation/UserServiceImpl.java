package az.azex.service.implementation;

import az.azex.domain.Role;
import az.azex.domain.User;
import az.azex.repository.UserDao;
import az.azex.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> authenticate(String email, String password) {
        return userDao.authenticate(email, password);
    }

    @Override
    public List<Role> getUserRoles(long userId) {
        return userDao.getUserRoles(userId);
    }
}
