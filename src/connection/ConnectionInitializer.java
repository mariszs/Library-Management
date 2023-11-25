package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionInitializer {

    private Connection connection;
    private static ConnectionInitializer instance;


    private ConnectionInitializer() {
        String dbUsername = "UusKasutaja";
        String dbPassword = "Lamp12345";
        String url = "jdbc:mysql://localhost:3306/libraryManagerApp?serverTimezone=UTC";

        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("<<<<< Connection to database successful >>>>>");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static ConnectionInitializer getInstance() {
        if (instance == null) {
            instance = new ConnectionInitializer();
        }
        return instance;
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {

        return connection.prepareStatement(query);
    }
}
