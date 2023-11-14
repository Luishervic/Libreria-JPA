package library.repository;

import library.model.Book;

import java.util.List;


public interface BookRepository {
    Book searchByIsbn(Long isbn);
    Book searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    List<Book> searchByPublisher(String publisher);
    void updateBook(Book book);
    void saveBook(Book book);
    void deleteBook(Long isbn);

}
