package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * UserDaoFactory - абстрактная фабрика которая возвращает реализацию дао на основе файла property
 */

public class UserDaoFactory {
    public static final String PATH_TO_PROPERTIES = "C:\\preproject\\src\\main\\resources\\config.properties";

    public static UserDAO createDao() {
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            prop.load(fileInputStream);
            String daoType = prop.getProperty("userDao");
            if ("JDBC".equals(daoType)){
                return new UserDaoJDBCImpl();
            }
            if ("Hibernate".equals(daoType)){
                return new UserHibernateDaoImpl();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
