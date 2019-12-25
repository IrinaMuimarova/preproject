package service;

import dao.UserDAO;
import factory.DaoFactory;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO dao = DaoConfiguration.getDaoFactory().getUserDao();

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
