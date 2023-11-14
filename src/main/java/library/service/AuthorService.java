package library.service;

import library.model.Author;
import library.repository.AuthorRepositoryImpl;
import library.utils.Validation;

import javax.persistence.EntityManager;

public class AuthorService {
    private final AuthorRepositoryImpl authorRepository;

    public AuthorService() {
        EntityManager em = EntityManagerFactoryProvider.getEntityManagerFactory();
        this.authorRepository = new AuthorRepositoryImpl(em);
    }

    public Author searchByName() {
        String name = Validation.getUserInputString("Enter Author Name: ");
        return authorRepository.getAuthorByName(name);
    }


}
