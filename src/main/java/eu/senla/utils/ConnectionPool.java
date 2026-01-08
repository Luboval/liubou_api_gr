package eu.senla.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static eu.senla.utils.ReadPropertyFile.getProperty;

public class ConnectionPool {

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(getProperty("DBURL"));
        config.setUsername(getProperty("DBUSER"));
        config.setPassword(getProperty("DBPSW"));
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000); //30s
        config.setMaxLifetime(180000000); //30 min

        dataSource = new HikariDataSource(config);

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
