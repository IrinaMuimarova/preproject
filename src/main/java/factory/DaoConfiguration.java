package factory;

import util.PropertyReader;

import java.util.Properties;

public class DaoConfiguration {

    public static DaoFactory getDaoFactory(){
        Properties prop = PropertyReader.readProperty();
        DaoFactory daoFactory = new UserHibernateDaoFactory();
        if (prop != null) {
            if ("JDBC".equals(prop.getProperty("userDao"))) {
                return new UserJDBCDaoFactory();
            }
        }
        return daoFactory;
    }
}
