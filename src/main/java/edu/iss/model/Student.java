package edu.iss.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @SequenceGenerator(name = "student_id_seq",
          sequenceName = "student_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "student_id_seq")
  private Integer id;
  private String name;
  @OneToOne
  private Project project;
  @JoinTable(name = "studentskill", joinColumns = {
                  @JoinColumn(name = "studentid", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "skillid", referencedColumnName = "id")})
  @ManyToMany
  private List<Skill> skills;
    @JoinTable(name = "studentproject", joinColumns = {
            @JoinColumn(name = "studentid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "projectid", referencedColumnName = "id")})
  @ManyToMany
  private List<Project> preferences;

  public Student() {
  }

  public Student(Integer id, String name, Project project, List<Skill> skills, List<Project> preferences) {
    this.id = id;
    this.name = name;
    this.project = project;
    this.skills = skills;
    this.preferences = preferences;
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

  public List<Project> getPreferences() {
    return preferences;
  }

  public void setPreferences(List<Project> preferences) {
    this.preferences = preferences;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }
}
