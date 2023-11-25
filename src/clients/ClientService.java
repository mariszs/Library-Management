package clients;

import java.util.Scanner;

public class ClientService {
    private final ClientRepository clientRepository;
    private final Scanner scanner;

    public ClientService() {
        this.clientRepository = new ClientRepository();
        this.scanner = new Scanner(System.in);
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

    public void createClient(){
        try {
            Client client = this.collectClientInfo();
            this.clientRepository.createClient(client);
        } catch (Exception exception) {
            System.out.println("Failed to create client, reason: " + exception.getMessage());
        }
    }

    private Client collectClientInfo() {
        Client client = new Client();
        client.setClientName(this.getUserInput("Enter client name to create:"));
        client.setEmail(this.getUserInput("Enter email:"));
        client.setPhone(Integer.parseInt(this.getUserInput("Enter phone number:")));

        return client;
    }

    public void deleteClient(String clientName) {
        try {
            Client client = this.findClientByName(clientName);
            this.clientRepository.deleteClient(client);

        } catch (Exception exception) {
            System.out.println("Failed to delete client, reason: " + exception.getMessage());
        }
    }


    private String getUserInput(String message) {
        System.out.println(message);
        return this.scanner.nextLine();
    }

}
