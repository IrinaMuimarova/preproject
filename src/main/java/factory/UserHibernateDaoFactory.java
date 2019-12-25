package factory;

import dao.UserDAO;
import dao.UserHibernateDaoImpl;

public class UserHibernateDaoFactory implements DaoFactory {
    @Override
    public UserDAO getUserDao() {
        return new UserHibernateDaoImpl();
    }
}
