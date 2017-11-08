package edu.iss.model;

import java.util.List;

public class Student {

  private Integer id;
  private String name;
  private Integer projectId;
  private List<Project> preferences;

  public Student() {
  }

  public Student(Integer id, String name, Integer projectId, List<Project> preferences) {
    this.id = id;
    this.name = name;
    this.projectId = projectId;
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

  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public List<Project> getPreferences() {
    return preferences;
  }

  public void setPreferences(List<Project> preferences) {
    this.preferences = preferences;
  }
}
