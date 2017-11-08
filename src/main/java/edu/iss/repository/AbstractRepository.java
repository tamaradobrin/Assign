package edu.iss.repository;

import edu.iss.model.Project;
import edu.iss.model.Skill;
import java.sql.*;
import java.util.List;

public class AbstractRepository {

  Connection connection;

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  public void initialize() {
    connection = null;
    try {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost/lab4";
      connection = DriverManager.getConnection(url, "postgres", "postgres");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SkillRepository repository = new SkillRepository();
    ProjectRepository projectRepository = new ProjectRepository();
    repository.initialize();
    projectRepository.initialize();
    List<Skill> skills = repository.findAll();
    List<Project> projects = projectRepository.getProjects();
  }
}
