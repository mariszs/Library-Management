package books;

public class BookController {

    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public void displayAllBooks() {
        bookService.displayBooks();
    }

    public void findBookByName(String bookName) {
        bookService.findBookByName(bookName);
    }


}