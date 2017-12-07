package edu.iss;

import edu.iss.model.Project;
import edu.iss.repository.ProjectJpaRepository;
import edu.iss.repository.SkillJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MainApp {

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    @Autowired
    private SkillJpaRepository skillJpaRepository;

    public static void main(String[] arg){
        Project p = new Project();
        p.setName("PROJ8239a");
        p.setDescription("Misc desc");
        p.setQuota(5);
    }
}
