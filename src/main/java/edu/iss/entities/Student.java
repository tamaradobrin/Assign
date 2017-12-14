package edu.iss.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

  @Id
  @SequenceGenerator(name = "student_id_seq",
          sequenceName = "student_id_seq", allocationSize = 1)
  @GeneratedValue(generator = "student_id_seq")
  private Integer id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "projectid", referencedColumnName = "id")
  private Project project;

  public Student() {
  }

  public Student(Integer id, String name, Project project) {
    this.id = id;
    this.name = name;
    this.project = project;
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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
