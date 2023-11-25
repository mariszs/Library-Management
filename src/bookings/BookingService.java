package bookings;

import books.BookService;
import clients.ClientService;
import lombok.SneakyThrows;

import java.sql.Timestamp;
import java.time.Instant;

public class BookingService {
    private final BookingRepository bookingRepository;
    private final ClientService clientService;
    private final BookService bookService;



    public BookingService() {
        this.clientService = new ClientService();
        this.bookService = new BookService();
        this.bookingRepository = new BookingRepository();
    }

    public void displayBookings() {
        try {
            this.bookingRepository.getAllBookings().forEach(System.out::println);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void findBookingById(int bookingId) {
        try {
            System.out.println(this.bookingRepository.findByBookingId(bookingId));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @SneakyThrows
    public void saveBooking(String bookName, String clientName, Timestamp bookingDate) {
        int bookId = bookService.findBookByName(bookName).getBookId();
        int clientId = clientService.findClientByName(clientName).getClientId();

        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        System.out.println("Booking time: " + timestamp);

        Booking booking = new Booking();
        booking.setBookId(bookId);
        booking.setClientId(clientId);
        booking.setBookingDate(bookingDate);
        bookingRepository.saveBooking(booking);
    }


}
