package service;

import dao.UserDAO;
import model.User;
import util.DbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService implements UserServiceInterface{

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

    private static UserDAO getUserDAO() throws IllegalAccessException {
        return new UserDAO(DbConnector.getMysqlConnection());
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
