package library.service;

import library.model.Author;
import library.model.Book;
import library.model.Publisher;
import library.repository.BookRepository;
import library.repository.BookRepositoryImpl;
import library.utils.Validation;

import javax.persistence.EntityManager;
import java.time.Year;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository;


    public BookService() {
        EntityManager em = EntityManagerFactoryProvider.getEntityManagerFactory();
        this.bookRepository = new BookRepositoryImpl(em);
    }

    public Book searchByIsbn() {
        Long isbn = Validation.getUserInputIsbn("Enter ISBN: ");
        return bookRepository.searchByIsbn(isbn);
    }

    public Book searchByTitle() {
        String title = Validation.getUserInputString("Enter Title: ");
        return bookRepository.searchByTitle(title);
    }

    public List<Book> searchByAuthor() {
        String author = Validation.getUserInputString("Enter Author: ");
        return bookRepository.searchByAuthor(author);
    }

    public List<Book> searchByPublisher() {
        String publisher = Validation.getUserInputString("Enter Publisher: ");
        return bookRepository.searchByPublisher(publisher);
    }

    public void updateBook(){
        Book book = searchByIsbn();
        System.out.println("This is the book you want to update: ");
        System.out.println(book);

        bookRepository.updateBook(book);
    }

    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    public void deleteBook(Long isbn) {
        bookRepository.deleteBook(isbn);
    }

    public Book fillBook(){
        Long isbn = Validation.getUserInputIsbn("Enter ISBN: ");
        String title = Validation.getUserInputString("Enter Title: ");
        int yearNow = Year.now().getValue();
        Integer year = Validation.getUserInputInt("Enter Year: ", 1000, yearNow);
        Integer copies = Validation.getUserInputInt("Enter Number of Copies: ", 1, 50);
        Integer borrowedCopies = Validation.getUserInputInt("Enter Number of Borrowed Copies: ", 0, copies);
        Integer remainingCopies = Validation.getUserInputInt("Enter Number of Remaining Copies: ", 0, copies);
        Boolean registered = Validation.getUserInputBoolean("Is the book registered? (true/false): ");

        Author author = new Author();
        author.setName(Validation.getUserInputString("Enter author's name:"));
        author.setRegistered(Validation.getUserInputBoolean("Is the author registered? (true/false): "));

        Publisher publisher = new Publisher();
        publisher.setName(Validation.getUserInputString("Enter publisher's name: "));
        publisher.setRegistered(Validation.getUserInputBoolean("Is the publisher registered? (true/false): "));

        return new Book(isbn, title, year, copies, borrowedCopies, remainingCopies, registered, author, publisher);
    }
}
