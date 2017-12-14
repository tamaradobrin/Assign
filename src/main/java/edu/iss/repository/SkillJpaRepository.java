package edu.iss.repository;

import edu.iss.entities.Skill;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class SkillJpaRepository extends AbstractJpaRepository<Skill> {

    public Skill findById(Long id) {
        return em.find(Skill.class, id);
    }

    public List<Skill> getAllSkills(){
        TypedQuery<Skill> query = em.createQuery("SELECT s FROM Skill s", Skill.class);
        return query.getResultList();
    }
}
