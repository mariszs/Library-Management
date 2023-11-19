package bookings;

import clients.Client;
import connection.ConnectionInitializer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingRepository {
    private ConnectionInitializer connectionInitializer;
    public BookingRepository() {
        this.connectionInitializer = new ConnectionInitializer();
    }

    public ArrayList<Booking> getAllBookings() throws SQLException {
        ResultSet resultSet = connectionInitializer.getPreparedStatement("SELECT * FROM booking").executeQuery();
        ArrayList<Booking> bookings = new ArrayList<>();

        while (resultSet.next()) {
            bookings.add(this.convertResultSetToBooking(resultSet));
        }
        return bookings;
    }

    public Booking findByBookingId(int bookingId) throws SQLException {
        ResultSet resultSet = connectionInitializer.getPreparedStatement("SELECT * FROM booking WHERE bookingId = '" + bookingId + "'").executeQuery();

        if (resultSet.next()) {
            return this.convertResultSetToBooking(resultSet);
        }
        throw new SQLException("Booking " + bookingId + " not found");
    }

    private Booking convertResultSetToBooking(ResultSet resultSet) throws SQLException {
        return new Booking(
                resultSet.getInt("bookingId"),
                resultSet.getInt("clientId"),
                resultSet.getInt("bookId")
                //resultSet.getTimestamp("bookingDate")
        );
    }

    public void saveBooking(Booking booking) throws SQLException {
        PreparedStatement preparedStatement = connectionInitializer.getPreparedStatement("INSERT INTO booking(bookingId, clientId, bookId) VALUES(?, ?, ?)");
            preparedStatement.setInt(1, booking.getBookingId());
            preparedStatement.setInt(2, booking.getClientId());
            preparedStatement.setInt(3, booking.getBookId());
            //preparedStatement.setTimestamp(4, booking.getBookingDate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
    }



}
