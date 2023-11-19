package clients;

import connection.ConnectionInitializer;

import java.util.Scanner;

public class ClientController {
    // private final ClientRepository clientRepository;
    private final ConnectionInitializer connectionInitalizer;
    private final Scanner scanner;
    public ClientController() {
        // this.clientRepository = new ClientRepository();
        this.connectionInitalizer = new ConnectionInitializer();
        this.scanner = new Scanner(System.in);
    }
}
