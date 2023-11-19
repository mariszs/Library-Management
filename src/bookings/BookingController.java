package bookings;


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

    public void saveBooking(String bookName, String clientName) {
        bookingService.saveBooking(bookName, clientName);
    }
}
