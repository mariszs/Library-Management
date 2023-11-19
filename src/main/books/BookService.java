package main.books;

public class BookService {

    // method display all main.books, returns list of all main.books

    private final BookRepository bookRepository;


    // call display all main.books from service class

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

    public void findBookByName(String bookName) {
        try {

            System.out.println(this.bookRepository.findBookByName(bookName));
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }


}
