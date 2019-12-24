package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAOInterface {
    List<User> getAll() throws SQLException;
    void createTable() throws SQLException;
    void add(User user) throws SQLException;
    void delete(long id) throws SQLException;
    User getUserById(Long id) throws SQLException;
    void update(User user) throws SQLException;
    }