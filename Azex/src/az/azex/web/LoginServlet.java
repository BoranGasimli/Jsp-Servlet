package az.azex.web;

import az.azex.domain.Role;
import az.azex.domain.User;
import az.azex.repository.UserDao;
import az.azex.repository.implementation.DatabaseHelper;
import az.azex.repository.implementation.UserDaoImpl;
import az.azex.service.UserService;
import az.azex.service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("email") != null &&
            request.getParameter("password") != null) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                DataSource dataSource = DatabaseHelper.getDataSource();
                UserDao userDao = new UserDaoImpl(dataSource);
                UserService userService = new UserServiceImpl(userDao);

                Optional<User> optionalUser = userService.authenticate(email, password);
                if (optionalUser.isPresent()) {
                    // email ve parol dogrudur
                    User user = optionalUser.get();
                    List<Role> roles = userService.getUserRoles(user.getId());
                    System.out.println("user roles = " + roles);
                    user.setRoleList(roles);

                    String page = roles.get(0).getDefaultController();
                    System.out.println("after login redirect to " + page);

                    HttpSession session = request.getSession();
                    session.setAttribute("loginTime", LocalDateTime.now());
                    session.setAttribute("user", user);
                    response.sendRedirect(page);
                } else {
                    // email ve ya parol sehvdir
                    System.out.println("email ve ya parol sehvdir");
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", "Email ve ya sifreniz yanlisdir!");
                    response.sendRedirect("login.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("email ve parol yoxdur");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
