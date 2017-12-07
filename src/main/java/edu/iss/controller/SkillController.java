package edu.iss.controller;

import edu.iss.model.Skill;
import edu.iss.repository.SkillJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SkillController", urlPatterns = {"/skills/register"})
public class SkillController extends HttpServlet {

    @Autowired
    SkillJpaRepository skillJpaRepository;

    @Override
    public void init() throws ServletException {
        skillJpaRepository = new SkillJpaRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Skill s = new Skill();
        s.setName("Miscellaneous skill");
        skillJpaRepository.create(s);
    }
}
