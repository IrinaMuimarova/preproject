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
import java.util.List;

@WebServlet("/")
public class ListServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = userService.getAllUser();
        request.setAttribute("userNames", list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
