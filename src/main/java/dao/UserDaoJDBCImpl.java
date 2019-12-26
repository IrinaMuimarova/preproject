package dao;

import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDAO {
    private Connection connection = DBHelper.getInstance().getConnection();

    public UserDaoJDBCImpl() {
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("select * from users");
            try (ResultSet result = stmt.getResultSet()) {
                while (result.next()) {
                    list.add(new User(result.getLong(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getString(5)));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


    public void add(User user) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            if (getUserByLogin(user.getLogin()) == null) {
                statement.execute("insert into users (login, password, name, role) values ('" + user.getLogin() +
                        "', '" + user.getPassword() + "','" + user.getName() + "','" + user.getRole() + "')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User getUserByLogin(String login) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("select * from users where name='" + login + "'");
            User user;
            try (ResultSet resultSet = statement.getResultSet()) {
                user = null;
                while (resultSet.next()) {
                    user = new User(resultSet.getLong(1),
                            resultSet.getString(2)
                            , resultSet.getString(3)
                            , resultSet.getString(4)
                            , resultSet.getString(5));
                }
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void delete(long id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("delete from users where id =" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User getUserById(Long id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("select * from users where id =" + id);

            try (ResultSet resultSet = statement.getResultSet()) {
                resultSet.next();
                return new User(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            assert statement != null;
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(User user) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("update users set name = '" + user.getName() + "', login = '" + user.getLogin() + "', password = '" + user.getPassword() + "' where id =" + user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert statement != null;
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
