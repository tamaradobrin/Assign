package edu.iss.repository;

import edu.iss.model.Project;
import edu.iss.model.Skill;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository extends AbstractRepository {

  private SkillRepository skillRepository;

  public ProjectRepository() {
  }

  public ProjectRepository(Connection connection) {
    this.connection = connection;
    initialize();
  }

  @Override
  public void initialize() {
    super.initialize();
    skillRepository = new SkillRepository(connection);
  }

  public List<Project> findAll() {
    List<Project> projects = new ArrayList<Project>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM assign.project ORDER BY id");
      while (rs.next()) {
        projects.add(getProjectFromRs(rs));
      }
      rs.close();
      st.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return projects;
  }

  public Project findById(Integer projectId) {
    Project project = null;
    if (projectId != null) {
      try {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM assign.project WHERE id = ?");
        st.setInt(1, projectId);
        ResultSet rs = st.executeQuery();
        rs.next();
        project = getProjectFromRs(rs);
        rs.close();
        st.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    return project;
  }

  public List<Project> getProjects(Array a) {
    List<Project> projects = null;
    if (a != null) {
      try {
        Integer[] preferences = (Integer[]) a.getArray();
        projects = new ArrayList<Project>();
        for (Integer projId : preferences) {
          projects.add(findById(projId));
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    return projects;
  }

  private Project getProjectFromRs(ResultSet rs) throws SQLException {
    Integer id = rs.getInt("id");
    String name = rs.getString("name");
    String description = rs.getString("description");
    Integer quota = rs.getInt("quota");
    Array a = rs.getArray("requiredskills");
    List<Skill> requiredSkills = skillRepository.getSkills(a);
    return new Project(id, name, description, quota, requiredSkills);
  }

}
