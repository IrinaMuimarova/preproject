package dao;

import factory.DaoFactory;

public class UserDAOType {
    private final UserDAO userDAO;

    public UserDAOType(DaoFactory daoFactory) {
        this.userDAO = daoFactory.getUserDao();
    }
}
