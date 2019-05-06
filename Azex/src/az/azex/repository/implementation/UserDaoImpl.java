package az.azex.repository.implementation;

import az.azex.domain.Person;
import az.azex.domain.Role;
import az.azex.domain.Status;
import az.azex.domain.User;
import az.azex.repository.UserDao;
import az.azex.utility.JdbcUtility;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<User> authenticate(String email, String password) {
        Optional<User> optionalUser = Optional.empty();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.AUTHENTICATE_USER);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
               User user = new User();
               user.setId(rs.getLong("id"));
               user.setEmail(rs.getString("email"));
               user.setPassword(rs.getString("password"));
               user.setStatus(Status.ACTIVE);
               optionalUser = Optional.of(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }

        return optionalUser;
    }

    @Override
    public List<Role> getUserRoles(long userId) {
        List<Role> roles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.GET_USER_ROLES);
            ps.setLong(1, userId);
            rs = ps.executeQuery();
            while(rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong("role_id"));
                role.setName(rs.getString("name"));
                role.setDefaultController(rs.getString("default_controller"));
                role.setDefaultPage(rs.getString("default_page"));
                role.setStatus(Status.ACTIVE);
                roles.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }

        return roles;
    }
}
