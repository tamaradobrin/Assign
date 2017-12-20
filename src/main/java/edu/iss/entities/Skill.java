package edu.iss.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {

  @Id
  @SequenceGenerator(name = "skill_id_seq",
          sequenceName = "skill_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "skill_id_seq")
  private Integer id;
  private String name;

  public Skill() {
  }

  public Skill(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
