package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;
import util.DbConnector;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO dao = new UserDAOImpl();

    public UserServiceImpl() {
    }

    public List<User> getAllUser() throws IllegalAccessException {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user) {
        try {
            dao.add(user);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public void deleteUser(long id) throws IllegalAccessException {
        try {
            dao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(Long id) {
        try {
            return dao.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        public void updateUser(User user) {
        try {
            dao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
