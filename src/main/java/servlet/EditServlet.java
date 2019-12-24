package servlet;

import service.UserServiceImpl;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringId = request.getParameter("id");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (stringId != null || name != null || login != null || password != null){
            Long id = Long.parseLong(stringId);
            new UserServiceImpl().updateUser(new User(id, name, login, password));
            response.setCharacterEncoding("utf-8");
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringId = request.getParameter("id");
        if (stringId != null) {
            Long id = Long.parseLong(stringId);
            User user = new UserServiceImpl().getUserById(id);
            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.getWriter().write("Error");
        }
    }
}
