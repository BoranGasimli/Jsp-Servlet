package az.azex.web;

import az.azex.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static az.azex.web.WebConstants.ROLE_ADMIN;
import static az.azex.web.WebConstants.USER;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = "/admin.jsp")
public class AuthorizationFilter implements Filter {
    public void destroy() {
        System.out.println("Authorization filter destroy oldu");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        if(session.getAttribute(USER) != null) {
            User user = (User) session.getAttribute(USER);
            long count = user.getRoleList().stream()
                    .filter(role -> role.getName().equalsIgnoreCase(ROLE_ADMIN))
                    .count();
            if(count > 0) {
                System.out.println("userin admin rolu var, icaze ver");
                chain.doFilter(req, resp);
            } else {
                System.out.println("userin admin rolu yoxdur, access denied sehifesine gonder");
                response.sendRedirect("access-denied.jsp");
            }

        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Authorization filter yarandi");
    }

}
