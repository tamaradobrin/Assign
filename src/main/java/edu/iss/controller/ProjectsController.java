package edu.iss.controller;

import edu.iss.model.Project;
import edu.iss.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ProjectsController", urlPatterns = {"/projects"})
public class ProjectsController extends HttpServlet {

  private ProjectRepository projectRepository = new ProjectRepository();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    projectRepository.initialize();
    List<Project> projects = projectRepository.findAll();
    req.setAttribute("projects", projects);
    req.getRequestDispatcher("/pages/projects.jsp").forward(req, resp);
  }
}
