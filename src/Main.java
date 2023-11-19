import bookings.BookingController;
import books.BookController;
import clients.ClientController;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = "";
        while (!userChoice.strip().equals("8")) {
            displayMenu();
            userChoice = scanner.nextLine();
            handleUserChoice(userChoice);
        }
//        Book book = new Book();
//        book.setBookName();
//        book.setAuthor();
//        book.setPublishingYear();
//        book.setDepartment();

        //      Client client = new Client();
    }

    private static void handleUserChoice(String userChoice) {
        ClientController clientController = new ClientController();
        BookingController bookingController = new BookingController();
        BookController bookController = new BookController();

        switch (userChoice) {
            case "1":
                bookController.displayAllBooks();
                break;
            case "2":
                String valueToFind = getUserInput("Enter book name to find:");
                bookController.findBookByName(valueToFind);
                break;
            case "3":
                clientController.displayAllClients();
                break;
            case "4":
                String nameToFind = getUserInput("Enter client name to find:");
                clientController.findClientByName(nameToFind);
                break;
            case "5":
                bookingController.displayAllBookings();
                break;
            case "6":
                String bookName = getUserInput("Enter book name to find: ");
                String clientName = getUserInput("Enter client name: ");
                bookingController.saveBooking(bookName, clientName);
                break;
            case "15":
                System.exit(0);
                break;
            default:
                System.out.println("Please enter one of the options above");
                break;
        }
    }

    public static void displayMenu() {
        System.out.println("""
                Welcome to library management!
                1. Display all books available
                2. Find book by name
                3. Display all users in system
                4. Find user by name
                5. 
                6. Borrow book
                                
                Enter your option:
                """);
    }

    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}