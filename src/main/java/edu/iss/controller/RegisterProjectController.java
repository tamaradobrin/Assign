package edu.iss.controller;

import edu.iss.model.Project;
import edu.iss.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterProjectController", urlPatterns = {"/projects/register"})
public class RegisterProjectController extends HttpServlet {

    private ProjectRepository projectRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/registerProject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        projectRepository.initialize();
        String projectName = req.getParameter("name");
        String description = req.getParameter("description");
        Integer quota = Integer.parseInt(req.getParameter("quota"));
        Project project = new Project();
        project.setName(projectName);
        project.setDescription(description);
        project.setQuota(quota);

    }
}
