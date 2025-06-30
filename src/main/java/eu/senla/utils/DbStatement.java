package eu.senla.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbStatement {
    private static Statement statement = null;

    public static Statement createDbStatement() throws SQLException {

           statement =  DbConnection.connectToDb().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           return statement;
    }

    public static ResultSet executeDbQuery(String query) throws SQLException {
          return createDbStatement().executeQuery(query);
    }

    public static  void getResultColumn(String query, int column) throws SQLException  {
        ResultSet resultSet = executeDbQuery(query);
            while (resultSet.next()) {

                System.out.println(resultSet.getInt(column));
            }
            //return i;

        closeStatement();
        DbConnection.closeConnection();
    }

    public static void executeSelectQuery(String query) throws SQLException {
        ResultSet resultSet = executeDbQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }
        closeStatement();
        DbConnection.closeConnection();
    }

    public static void closeStatement() {
        try {
            statement.close();
        } catch (SQLException e) {
            System.err.println("SQL Error: "
                    + e.getMessage());
        }
    }
}
