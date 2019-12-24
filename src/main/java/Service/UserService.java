package Service;

import DAO.UserDAO;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public List<User> getAllUser() throws IllegalAccessException {
        try {
            return getUserDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user) {
        try {
            getUserDAO().add(user);
            return true;
        } catch (SQLException | IllegalAccessException e) {
            return false;
        }
    }

    public void createTable() throws IllegalAccessException {
        UserDAO dao = getUserDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
        }
    }

    private static Connection getMysqlConnection() throws IllegalAccessException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=1234").       //password
                    append("&serverTimezone=UTC");   //setup server time
            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDAO getUserDAO() throws IllegalAccessException {
        return new UserDAO(getMysqlConnection());
    }

    public void deleteUser(long id) throws IllegalAccessException {
        try {
            getUserDAO().delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(Long id) {
        try {
            return getUserDAO().getUserById(id);
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(User user) {
        try {
            getUserDAO().update(user);
        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }
}
