package library.repository;

import library.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;

public class AuthorRepositoryImpl implements AuthorRepository{
    private final EntityManager em;

    public AuthorRepositoryImpl(EntityManager em){
        this.em = em;
    }
    @Override
    public void updateAuthor(Author author) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(author);
        tx.commit();
    }

    @Override
    public void deleteAuthor(Integer id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Author author = getAuthorById(id);
        em.remove(author);
        tx.commit();
    }

    @Override
    public void logicalDeleteAuthor(Integer id) {

    }


    @Override
    public Collection<Author> getAllAuthors() {
        return null;
    }

    @Override
    public Collection<Author> getRegisteredAuthors() {
        return null;
    }

    @Override
    public Collection<Author> getUnregisteredAuthors() {
        return null;
    }

    @Override
    public Author getAuthorById(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public Author getAuthorByName(String name) {
         return em.createQuery("SELECT a FROM Author a WHERE a.name = :name", Author.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Collection<Author> getAuthorsByName(String name) {
        return null;
    }
}
