package service;

import dao.UserDAO;
import dao.UserDAOType;
import factory.DaoFactory;
import factory.UserHibernateDaoFactory;
import factory.UserJDBCDaoFactory;
import model.User;
import util.PropertyReader;

import java.util.List;
import java.util.Properties;

public class UserServiceImpl implements UserService {
    private UserDAO dao;

    public UserServiceImpl() {
        initUserDao();
    }

    public void initUserDao() {
        Properties prop = PropertyReader.readProperty();
        if (prop != null) {
            if ("JDBC".equals(prop.getProperty("userDao"))) {
                dao = new UserJDBCDaoFactory().getUserDao();
            } else if ("Hibernate".equals(prop.getProperty("userDao"))) {
                dao = new UserHibernateDaoFactory().getUserDao();
            } else {
                System.out.println("Error. Property UserDao not found");
            }
        } else {
            System.out.println("Error. Properties not found");
        }
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
