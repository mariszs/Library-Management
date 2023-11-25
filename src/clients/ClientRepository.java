package clients;

import connection.ConnectionInitializer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientRepository {
    private ConnectionInitializer connectionInitializer;

    public ClientRepository() {
        this.connectionInitializer = ConnectionInitializer.getInstance();
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
        throw new SQLException("Client " + clientName + " not found");
    }

    public void createClient(Client client) throws SQLException {
        PreparedStatement preparedStatement = connectionInitializer.getPreparedStatement("INSERT INTO clients(clientName, email, phone) VALUES(?,?,?)");
        preparedStatement.setString(1, client.getClientName());
        preparedStatement.setString(2, client.getEmail());
        preparedStatement.setInt(3, client.getPhone());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteClient(Client client) {
      try {
          PreparedStatement preparedStatement = connectionInitializer.getPreparedStatement(
                  "DELETE FROM clients WHERE clientId = " + client.getClientId());
          preparedStatement.executeUpdate();
          //System.out.println("Client deleted successfully: " + client);

      } catch (SQLException exception) {
          exception.printStackTrace();
      }

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