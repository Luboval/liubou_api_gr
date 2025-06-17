package eu.senla.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection = null;

    public static Connection connectToDb() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    ReadPropertyFile.getProperty("DBURL"),
                    ReadPropertyFile.getProperty("DBUSER"),
                    ReadPropertyFile.getProperty("DBPSW"));
        } catch (SQLException e) {
            System.out.println("Connection to DB failed!\n" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connection closed.");
    }
}
