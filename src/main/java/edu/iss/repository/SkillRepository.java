package edu.iss.repository;

import edu.iss.entities.Skill;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository extends AbstractRepository {

  public SkillRepository() {
  }

  public SkillRepository(Connection connection) {
    this.connection = connection;
  }

  public List<Skill> findAll() {
    List<Skill> skills = new ArrayList<Skill>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM assign.skill");
      while (rs.next()) {
        skills.add(getSkillFromRs(rs));
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
    if (skillId != null) {
      try {
        PreparedStatement st = connection.prepareStatement("SELECT * FROM assign.skill WHERE id = ?");
        st.setInt(1, skillId);
        ResultSet rs = st.executeQuery();
        rs.next();
        skill = getSkillFromRs(rs);
        rs.close();
        st.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    return skill;
  }

  public List<Skill> getSkills(Array a) {
    List<Skill> skills = null;
    if (a != null) {
      try {
        Integer[] skillIds = (Integer[]) a.getArray();
        skills = new ArrayList<Skill>();
        for (Integer skillId : skillIds) {
          skills.add(findById(skillId));
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    return skills;
  }

  private Skill getSkillFromRs(ResultSet rs) throws SQLException {
    Integer id = rs.getInt("id");
    String name = rs.getString("name");
    return new Skill(id, name);
  }

}
