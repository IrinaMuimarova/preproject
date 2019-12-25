package factory;

import util.PropertyReader;

import java.util.Objects;

public class DaoConfiguration {

    public static DaoFactory getDaoFactory() {
        String prop = Objects.requireNonNull(PropertyReader.readProperty()).getProperty("userDao");
        DaoFactory daoFactory = new UserHibernateDaoFactory();
        if ("JDBC".equals(prop)) {
            daoFactory = new UserJDBCDaoFactory();
        }
        return daoFactory;
    }
}
