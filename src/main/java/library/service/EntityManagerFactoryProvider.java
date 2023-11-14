package library.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("libreria");
        }
        return entityManagerFactory.createEntityManager();
    }

}
