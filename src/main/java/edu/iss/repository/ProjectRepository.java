package edu.iss.repository;

import edu.iss.model.Project;
import edu.iss.model.Skill;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository extends AbstractRepository {

  private SkillRepository skillRepository;

  @Override
  public void initialize() {
    super.initialize();
    skillRepository = new SkillRepository();
    skillRepository.setConnection(connection);
  }

  public List<Project> getProjects() {
    List<Project> projects = new ArrayList<Project>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM assign.project ORDER BY id");
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        Integer quota = rs.getInt("quota");
        Array a = rs.getArray("requiredskills");
        Integer[] requiredSkillsIds = (Integer[]) a.getArray();
        List<Skill> requiredSkills = new ArrayList<Skill>();
        for (Integer skillId : requiredSkillsIds) {
          requiredSkills.add(skillRepository.findById(skillId));
        }
        projects.add(new Project(id, name, description, quota, requiredSkills));
      }
      rs.close();
      st.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return projects;
  }

}
