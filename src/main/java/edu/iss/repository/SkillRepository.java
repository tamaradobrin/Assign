package edu.iss.repository;

import edu.iss.model.Skill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository extends AbstractRepository {

  public List<Skill> findAll() {
    List<Skill> skills = new ArrayList<Skill>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM assign.skill");
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        skills.add(new Skill(id, name));
      }
      rs.close();
      st.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return skills;
  }

  public Skill findById(Integer skillId) {
    Skill skill = null;
    try {
      PreparedStatement st = connection.prepareStatement("SELECT * FROM assign.skill WHERE id = ?");
      st.setInt(1, skillId);
      ResultSet rs = st.executeQuery();
      rs.next();
      Integer id = rs.getInt("id");
      String name = rs.getString("name");
      skill = new Skill(id, name);

      rs.close();
      st.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return skill;
  }

}
