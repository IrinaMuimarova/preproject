package servlet;

import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            new UserService().deleteUser(Long.parseLong(request.getParameter("id")));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
            requestDispatcher.forward(request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
