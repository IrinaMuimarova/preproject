package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUser() throws IllegalAccessException;
    boolean addUser(User user);
    void createTable() throws IllegalAccessException;
    void deleteUser(long id) throws IllegalAccessException;
    User getUserById(Long id);
    void updateUser(User user);
    }
