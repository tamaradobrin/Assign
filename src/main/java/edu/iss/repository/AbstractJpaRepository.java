package edu.iss.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJpaRepository<T> {

    @PersistenceContext(unitName = "jpa")
    public EntityManager em;

    public void create(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }
}
