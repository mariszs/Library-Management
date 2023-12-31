package books;

public class BookService {

    // method display all books, returns list of all books

    private final BookRepository bookRepository;


    // call display all books from service class

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public void displayBooks() {
        try {
            this.bookRepository.getAllBooks().forEach(System.out::println);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Book findBookByName(String bookName) {
        try {
            return this.bookRepository.findBookByName(bookName);
        } catch (Exception exception){
            System.out.println(exception.getMessage());

        }
        return null;
    }




}