package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void add(User user);
    void delete(long id);
    User getUserById(Long id);
    void update(User user);
    }
