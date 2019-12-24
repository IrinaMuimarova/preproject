package servlets;

import Service.UserService;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        if (login == null || password == null || name == null) {
            response.getWriter().write("Заполните все поля");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
        } else {
            User user = new User(name, login, password);
            UserService userService = new UserService();
            request.setAttribute("isAdd", userService.addUser(user) ? "true" : "false");
            request.setAttribute("userName", user.getName());
            doGet(request, response);
    }

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(request, response);
    }
}