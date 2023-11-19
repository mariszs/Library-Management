package clients;

import connection.ConnectionInitializer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientRepository {
    private ConnectionInitializer connectionInitializer;

    public ClientRepository() {
        this.connectionInitializer = new ConnectionInitializer();
    }

    public ArrayList<Client> getAllClients() throws SQLException {
        ResultSet resultSet = connectionInitializer.getPreparedStatement("SELECT * FROM clients").executeQuery();
        ArrayList<Client> clients = new ArrayList<>();

        while (resultSet.next()) {
            clients.add(this.convertResultSetToClient(resultSet));
        }
        return clients;
    }

    public Client findClientByName(String clientName) throws SQLException {
        ResultSet resultSet = connectionInitializer.getPreparedStatement("SELECT * FROM clients WHERE clientName = '" + clientName + "'").executeQuery();

        if (resultSet.next()) {
            return this.convertResultSetToClient(resultSet);
        }
        throw new SQLException("Book " + clientName + " not found");

    }



    private Client convertResultSetToClient(ResultSet resultSet) throws SQLException {
        return new Client(
                resultSet.getInt("clientId"),
                resultSet.getString("clientName"),
                resultSet.getString("email"),
                resultSet.getInt("phone")
        );
    }
}