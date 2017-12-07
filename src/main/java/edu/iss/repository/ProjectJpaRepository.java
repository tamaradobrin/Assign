package edu.iss.repository;

import edu.iss.model.Project;

import java.util.List;

public class ProjectJpaRepository extends AbstractJpaRepository<Project> {

    public Project findById(Long id){
        return em.find(Project.class, id);
    }
}
