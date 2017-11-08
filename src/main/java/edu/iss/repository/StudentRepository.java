package edu.iss.repository;

import edu.iss.model.Project;
import edu.iss.model.Skill;
import edu.iss.model.Student;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends AbstractRepository {

  private SkillRepository skillRepository;
  private ProjectRepository projectRepository;

  @Override
  public void initialize() {
    super.initialize();
    skillRepository = new SkillRepository(connection);
    projectRepository = new ProjectRepository(connection);
  }

  public List<Student> findAll() {
    List<Student> students = new ArrayList<Student>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM assign.student ORDER BY id");
      while (rs.next()) {
        students.add(getStudentFromRs(rs));
      }
      rs.close();
      st.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return students;
  }

  public Student findById(Integer studentId) {
    Student student = null;
    try {
      PreparedStatement st = connection.prepareStatement("SELECT * FROM assign.student WHERE id = ?");
      st.setInt(1, studentId);
      ResultSet rs = st.executeQuery();
      rs.next();
      student = getStudentFromRs(rs);
      rs.close();
      st.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return student;
  }

  private Student getStudentFromRs(ResultSet rs) throws SQLException {
    Integer id = rs.getInt("id");
    String name = rs.getString("name");
    Integer projectId = rs.getInt("projectid");
    Project project = projectRepository.findById(projectId);
    Array a = rs.getArray("preferences");
    List<Project> preferedProjects = projectRepository.getProjects(a);
    Array b = rs.getArray("skillIds");
    List<Skill> skills = skillRepository.getSkills(b);
    return new Student(id, name, project, skills, preferedProjects);
  }
}
