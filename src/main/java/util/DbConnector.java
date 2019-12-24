package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection getMysqlConnection() throws IllegalAccessException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=1234").       //password
                    append("&serverTimezone=UTC");   //setup server time
            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
