package service;

import factory.DaoFactory;
import factory.UserHibernateDaoFactory;
import factory.UserJDBCDaoFactory;
import util.PropertyReader;

import java.util.Properties;

public class DaoConfiguration {

    public static DaoFactory getDaoFactory(){
        Properties prop = PropertyReader.readProperty();
        if (prop != null) {
            if ("JDBC".equals(prop.getProperty("userDao"))) {
                return new UserJDBCDaoFactory();
            } else if ("Hibernate".equals(prop.getProperty("userDao"))) {
                return new UserHibernateDaoFactory();
            } else {
                System.out.println("Error. Property UserDao not found");
            }
        } else {
            System.out.println("Error. Properties not found");
        }
        return null;
    }
}
