package library.repository;

import library.model.Author;

import java.util.Collection;

public interface AuthorRepository {
    Author getAuthorById(int id);
    Author getAuthorByName(String name);
    void updateAuthor(Author author);
    void deleteAuthor(Integer id);
    void logicalDeleteAuthor(Integer id);
    Collection<Author> getAllAuthors();
    Collection<Author> getRegisteredAuthors();
    Collection<Author> getUnregisteredAuthors();
    Collection<Author> getAuthorsByName(String name);

}
