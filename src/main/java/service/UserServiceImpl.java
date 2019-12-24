package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import dao.UserHibernateDaoImpl;
import model.User;
import util.DbConnector;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO dao = new UserHibernateDaoImpl();

    public UserServiceImpl() {
    }

    public List<User> getAllUser() {
        return dao.getAll();
    }

    public boolean addUser(User user) {
        dao.add(user);
        return true;
    }

    public void deleteUser(long id) {
        dao.delete(id);
    }

    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    public void updateUser(User user) {
        dao.update(user);
    }
}
