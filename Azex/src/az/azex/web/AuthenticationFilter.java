package az.azex.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static az.azex.web.WebConstants.LOGIN_TIME;
import static az.azex.web.WebConstants.USER;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/dashboard.jsp", "/logout", "/admin.jsp"})
public class AuthenticationFilter implements Filter {
    public void destroy() {
        System.out.println("Authentication filter destroy oldu");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        if(session.getAttribute(USER) != null &&
            session.getAttribute(LOGIN_TIME) != null
        ) {
            System.out.println("User login olub, davam etmeye icaze ver");
            System.out.println("User = " + session.getAttribute(USER));
            System.out.println("Login time = " + session.getAttribute(LOGIN_TIME));
            chain.doFilter(req, resp);
        } else {
            System.out.println("User login olmayib, login jsp sehifesine redirect ele");
            response.sendRedirect("login.jsp");
        }


    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Authentication Filter yarandi");
    }

}
