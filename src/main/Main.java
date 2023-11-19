package main;

import main.bookings.BookingController;
import main.books.BookController;
import main.clients.ClientController;
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
                String valueToFind = getUserInput("Enter book name to find:");
                bookController.findBookByName(valueToFind); // message as parameter
                break;
            case "2":
                bookController.displayAllBooks();
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
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
                1. Find books by name
                2. Display all book available
                3. Borrow book
                4. Return book
                5. Exit
                                
                Enter your option:
                """);
    }

    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
