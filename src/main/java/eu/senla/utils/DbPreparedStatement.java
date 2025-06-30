package eu.senla.utils;

import eu.senla.model.admin.dbresponse.StaffDBResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbPreparedStatement {
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static PreparedStatement createPreparedDbStatement(String query) throws SQLException {

        return   DbConnection.connectToDb().prepareStatement(query);

    }

    public static ResultSet executePreparedDbQuery(String query, int paramInd, int paramVal) throws SQLException {
        preparedStatement = createPreparedDbStatement(query);
        preparedStatement.setInt(paramInd, paramVal);
        preparedStatement.execute();
        return preparedStatement.getResultSet();
    }

    public static StaffDBResponse getResponseForPreparedSelectQuery(String query, int paramInd, int paramVal) throws SQLException {
        StaffDBResponse response;
        resultSet = executePreparedDbQuery(query, paramInd, paramVal);
        if (resultSet.next()) {
            response = new StaffDBResponse(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
                    );

        } else {
            response = null;
            }

        closePreparedStatement();
        DbConnection.closeConnection();

        return response;
    }

    public static void closePreparedStatement() {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("SQL Error: "
                    + e.getMessage());
        }
    }
}
