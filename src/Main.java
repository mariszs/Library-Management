import bookings.BookingController;
import books.BookController;
import clients.ClientController;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";
        while (!userChoice.strip().equals("12")) {
            displayMenu();
            userChoice = scanner.nextLine();
            handleUserChoice(userChoice);
        }
    }

    private static void handleUserChoice(String userChoice) {
        ClientController clientController = new ClientController();
        BookingController bookingController = new BookingController();
        BookController bookController = new BookController();

        switch (userChoice) {
            case "1": // Display all books available
                bookController.displayAllBooks();
                break;
            case "2": // Find book by name
                String valueToFind = getUserInput("Enter book name to find:");
                bookController.findBookByName(valueToFind);
                break;
            case "3": // Borrow book
                String bookName = getUserInput("Enter book name to find: ");
                String clientName = getUserInput("Enter client name: ");
                Timestamp bookingDate = new Timestamp(System.currentTimeMillis());
                bookingController.saveBooking(bookName, clientName, bookingDate);
                break;
            case "4": // Return book
                // TODO: return book
                break;
            case "5": // Display all books borrowed out currently
                bookingController.displayAllBookings();
                // TODO: have output in a better format
                break;
            case "6": // Add new book to library
                // TODO: add new books
                break;
            case "7": // Delete book from library
                // TODO: delete book
                break;

            case "8": // Display all clients in system
                clientController.displayAllClients();
                break;
            case "9": // Find client by name
                String nameToFind = getUserInput("Enter client name to find:");
                clientController.findClientByName(nameToFind);
                break;
            case "10": // Create new client account
                clientController.createClient();
                break;
            case "11": // Delete client
                // TODO: delete client
                // String clientToDelete = getUserInput("Enter client name to delete:");
                // clientController.deleteClient(clientToDelete);
                break;
            case "12": // Exit system
                System.exit(0);
                break;
            default:
                System.out.println("Please enter one of the options above");
                break;
        }
    }

    public static void displayMenu() {
        System.out.println("""
                ----- Welcome to library management! -----
                
                1. Display all books available
                2. Find book by name
                3. Borrow book
                4. Return book
                5. Display all books borrowed out currently
                6. Add new book to library
                7. Delete book from library
                8. Display all clients in system
                9. Find client by name
                10. Create new client account
                11. Delete client
                12. Exit
                                
                Enter your option:
                """);
    }

    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}