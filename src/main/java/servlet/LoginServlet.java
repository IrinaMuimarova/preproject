package servlet;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null) {
            response.getWriter().write("Введите имя и пароль");
        } else {
            UserService userService = new UserServiceImpl();
            User user = userService.getUserByLogin(login);
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("user", user);
                if (user.getRole().equals("admin")) {
                    response.sendRedirect("/admin");
                } else if (user.getRole().equals("user")) {
                    response.sendRedirect("/view/userCard.jsp");
                }
            } else {
                request.setAttribute("isLogin", false);
                doGet(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/login.jsp");
        requestDispatcher.forward(request, response);
    }
}
