package clients;/*package clients;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientRepository {

    private Connection connection;

    public ClientRepository() {
        this.initialiseConnection();
    }

    private void initialiseConnection() {
        String dbUsername = "JREE28";
        String dbPassword = "password";
        String url = "jdbc:mysql://localhost:3306/libraryManagerApp?serverTimezone=UTC";

        try {
            this.connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("<<<< Connection to database successful >>>>");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}*/