package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser() throws IllegalAccessException;
    boolean addUser(User user);
    void deleteUser(long id) throws IllegalAccessException;
    User getUserById(Long id);
    void updateUser(User user);
    User getUserByLogin(String login);
}
