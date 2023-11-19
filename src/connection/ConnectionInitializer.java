package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionInitializer {
    private Connection connection;

    public ConnectionInitializer() {
        this.initialiseConnection();
    }

    private void initialiseConnection() {
        String dbUsername = "JREE28";
        String dbPassword = "password";
        String url = "jdbc:mysql://localhost:3306/libraryManagerApp?serverTimezone=UTC";

        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("<<<<< Connection to database successful >>>>>");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    public PreparedStatement getPreparedStatement(String query) throws SQLException {

        return connection.prepareStatement(query);
    }
}
