package edu.iss.repository;

import edu.iss.entities.Project;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ProjectJpaRepository extends AbstractJpaRepository<Project> {

    public Project findById(Integer id) {
        return em.find(Project.class, id);
    }

    public List<Project> getAllProjects(){
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p", Project.class);
        return query.getResultList();
    }
}
