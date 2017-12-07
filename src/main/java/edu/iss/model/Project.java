package edu.iss.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @SequenceGenerator(name = "project_id_seq",
            sequenceName = "project_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "project_id_seq")
    private Integer id;
    private String name;
    private String description;
    private Integer quota;
    @JoinTable(name = "projectskill", joinColumns = {
            @JoinColumn(name = "projectid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "skillid", referencedColumnName = "id")})
    @ManyToMany
    private List<Skill> requiredSkills;

    public Project() {
    }

    public Project(Integer id, String name, String description, Integer quota, List<Skill> requiredSkills) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quota = quota;
        this.requiredSkills = requiredSkills;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
