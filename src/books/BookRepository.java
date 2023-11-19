package books;

import connection.ConnectionInitializer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {

    private ConnectionInitializer connectionInitializer;

    public BookRepository() {
        this.connectionInitializer = new ConnectionInitializer();
    }

    public ArrayList<Book> getAllBooks() throws SQLException {
        ResultSet resultSet = connectionInitializer.getPreparedStatement("SELECT * FROM books").executeQuery();
        ArrayList<Book> books = new ArrayList<>();

        while (resultSet.next()) {
            books.add(this.convertResultSetToBook(resultSet));
        }
        return books;
    }

    public Book findBookByName(String bookName) throws SQLException {
        ResultSet resultSet = connectionInitializer.getPreparedStatement("SELECT * FROM books WHERE bookName = '" + bookName + "'").executeQuery();

        if (resultSet.next()) {
            return this.convertResultSetToBook(resultSet);
        }
        throw new SQLException("Book " + bookName + " not found");

    }

    private Book convertResultSetToBook(ResultSet resultSet) throws SQLException {
        return new Book(
                resultSet.getInt("bookId"),
                resultSet.getString("bookName"),
                resultSet.getString("author"),
                resultSet.getInt("publishingYear"),
                resultSet.getString("department")
        );
    }

}