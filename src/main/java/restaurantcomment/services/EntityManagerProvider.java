package restaurantcomment.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EntityManagerProvider() {
        this.emf = Persistence.createEntityManagerFactory("restaurant");
    }

    public EntityManager startNewEm() {

        em = emf.createEntityManager();

        return em;
    }

    public EntityManager getCurrentEm() {
        return em;
    }

    public void startTransaction() {

        getCurrentEm().getTransaction().begin();

    }

    public void commitTransaction() {

        getCurrentEm().getTransaction().commit();

    }

    public void rollbackTransaction() {

        em.getTransaction().rollback();
    }

    public void endCurrentEm() {
        em.close();
        em = null;
    }

    public void clearEm() {

        em.clear();

    }

    public void closeJpa() {
        emf.close();
    }



}
