package edu.iss.controller;

import com.sun.faces.action.RequestMapping;
import edu.iss.entities.Project;
import edu.iss.entities.Skill;
import edu.iss.repository.ProjectJpaRepository;
import edu.iss.repository.SkillJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/skill")
public class SkillController{

    @Autowired
    private SkillJpaRepository skillJpaRepository;

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    @GetMapping
    public String getSkills(Model model){
        List<Skill> skills = skillJpaRepository.getAllSkills();
        model.addAttribute("skillList", skills);

        List<Project> projects = projectJpaRepository.getAllProjects();

        return "skills";
    }
}
