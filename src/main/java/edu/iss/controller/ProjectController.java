package edu.iss.controller;

import edu.iss.entities.Project;
import edu.iss.entities.Student;
import edu.iss.repository.ProjectJpaRepository;
import edu.iss.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @GetMapping
    public String getProjects(Model model) {
        List<Project> projects = projectJpaRepository.getAllProjects();
        model.addAttribute("projects", projects);
        /*Project newProject = new Project();
        newProject.setName("project532");
        newProject.setDescription("descn324");
        newProject.setQuota(5);
        projectJpaRepository.create(newProject);
        Student newStudent = new Student();
        newStudent.setName("studentName542");
        newStudent.setProject(newProject);
        studentJpaRepository.create(newStudent);*/
        Project project = projectJpaRepository.findById(2);
        projectJpaRepository.delete(project);
        return "projects";
    }
}
