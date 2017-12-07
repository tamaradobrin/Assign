package edu.iss.repository;

import edu.iss.model.Skill;

public class SkillJpaRepository extends AbstractJpaRepository<Skill> {

    public Skill findById(Long id) {
        return em.find(Skill.class, id);
    }
}
