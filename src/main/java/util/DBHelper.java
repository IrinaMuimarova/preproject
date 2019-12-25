package util;

import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class DBHelper {
    private static final DBHelper dbHelper = new DBHelper();

    private DBHelper() {
    }

    public static DBHelper getInstance(){
        return dbHelper;
    }

    public Connection getConnection(){
        return DbConnector.getMysqlConnection();
    }

    public Configuration getConfiguration(){
        return DbConnectorHibernate.getMySqlConfiguration();
    }
}
