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
}