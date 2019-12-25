package factory;

import dao.UserDAO;
import dao.UserDaoJDBCImpl;

public class UserJDBCDaoFactory implements DaoFactory {

    @Override
    public UserDAO getUserDao() {
        return new UserDaoJDBCImpl();
    }
}
