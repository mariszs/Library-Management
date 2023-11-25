package clients;

public class ClientController {
    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public void displayAllClients() {
        clientService.displayClients();
    }

    public void findClientByName(String clientName) {
        Client client = clientService.findClientByName(clientName);
        System.out.println(client);
    }

    public void createClient() {
        clientService.createClient();
        System.out.println("Client is created successfully!");
    }

    public void deleteClient(String clientName) {
        clientService.deleteClient(clientName);
        System.out.println("Client deleted successfully!");
    }
}