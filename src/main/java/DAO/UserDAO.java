package DAO;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAll() throws SQLException {
        createTable();
        List<User> list = new ArrayList<>();
        Statement stmt = connection.createStatement();
        stmt.execute("select * from users");
        ResultSet result = stmt.getResultSet();
        while (result.next()) {
            list.add(new User(result.getLong(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)));
        }
        result.close();
        stmt.close();
        return list;    }

    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("create table if not exists users (id bigint auto_increment,  name varchar(256), login varchar(256), password varchar(256), primary key (id))");
        statement.close();
    }

    public void add(User user) throws SQLException {
        createTable();
        Statement statement = connection.createStatement();
        if (getUserByLogin(user.getLogin()) == null) {
            statement.execute("insert into users (login, password, name) values ('" + user.getLogin() +
                    "', '" + user.getPassword() + "','" + user.getName() + "')");
        }
    }

    private User getUserByLogin(String login) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from users where name='" + login + "'");
        ResultSet resultSet = statement.getResultSet();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getLong(1),
                    resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4));
        }
        resultSet.close();
        statement.close();
        return user;
    }

    public void delete(long id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("delete from users where id =" + id);
        statement.close();
    }

    public User getUserById(Long id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from users where id =" + id);
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        User user = new User(resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4));
        resultSet.close();
        statement.close();
        return user;
    }

    public void update(User user) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("update users set name = '" + user.getName() + "', login = '" + user.getLogin() + "', password = '" + user.getPassword() + "' where id =" + user.getId());
    }
}
