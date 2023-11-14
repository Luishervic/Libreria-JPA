package library.repository;

import library.model.Book;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final EntityManager em;

    public BookRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Book searchByIsbn(Long isbn) {
        try {
            return em.find(Book.class, isbn);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Book searchByTitle(String title) {
        try {
            return em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<Book> searchByAuthor(String author) {
        try {
            return em.createQuery("SELECT b FROM Book b WHERE b.author.name = :author", Book.class)
                    .setParameter("author", author)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<Book> searchByPublisher(String publisher) {
        try {
            return em.createQuery("SELECT b FROM Book b WHERE b.publisher.name = :publisher", Book.class)
                    .setParameter("publisher", publisher)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void updateBook(Book book) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(book);
        tx.commit();
    }

    @Override
    public void saveBook(Book book) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
    }

    @Override
    public void deleteBook(Long isbn) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Book book = searchByIsbn(isbn);
        em.remove(book);
        tx.commit();
    }


}
