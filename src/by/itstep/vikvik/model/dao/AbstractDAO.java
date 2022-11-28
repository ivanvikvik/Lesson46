package by.itstep.vikvik.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AbstractDAO {
    public Connection getConnection() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        Connection connection = null;
        try {
            Class.forName(resourceBundle.getString("db.driver"));

            connection = DriverManager.getConnection(
                    resourceBundle.getString("db.url"),
                    resourceBundle.getString("db.user"),
                    resourceBundle.getString("db.password"));
        } catch (
                ClassNotFoundException exception) {
            System.out.println(exception);
        } catch (
                SQLException exception) {
            System.out.println(exception);
        }

        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }
    }
}
