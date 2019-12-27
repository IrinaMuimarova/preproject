package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/view/userCard.jsp")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            chain.doFilter(req, resp);
        }
        else{
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
