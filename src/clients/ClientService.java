package clients;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public void displayClients() {
        try {
            this.clientRepository.getAllClients().forEach(System.out::println);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Client findClientByName(String clientName) {
        try {
            return clientRepository.findClientByName(clientName);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
