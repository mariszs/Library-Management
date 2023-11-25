package bookings;


import java.sql.Timestamp;

public class BookingController {
    private BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    public void displayAllBookings() {
        bookingService.displayBookings();
    }

    public void findBookingById(int bookingId) {
        bookingService.findBookingById(bookingId);
    }

    public void saveBooking(String bookName, String clientName, Timestamp bookingDate) {
        bookingService.saveBooking(bookName, clientName, bookingDate);

        System.out.println("Booking is saved! Client: " + clientName + ", book: " + bookName);
    }
}
