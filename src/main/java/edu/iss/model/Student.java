package edu.iss.model;

import java.util.List;

public class Student {

  private Integer id;
  private String name;
  private Project project;
  private List<Skill> skills;
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
