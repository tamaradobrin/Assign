package edu.iss.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJpaRepository<T> {

    @PersistenceContext(unitName = "assignPU")
    EntityManager em;

    @Transactional
    public void create(T t) {
        em.persist(t);
        em.close();
    }

    @Transactional
    public void update(T t) {
        em.merge(t);
        em.close();
    }

    @Transactional
    public void delete(T t) {
        em.remove(t);
        em.close();
    }
}
